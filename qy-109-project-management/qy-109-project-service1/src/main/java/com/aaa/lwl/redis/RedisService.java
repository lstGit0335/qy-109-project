package com.aaa.lwl.redis;

import com.aaa.lwl.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.aaa.lwl.staticproperties.RedisProperties.*;

/**
 * fileName:RedisService
 * Author:李守堂
 * createTime:2020/7/10   16:46
 * version:1.0.0
 * Description
 */
@Service
public class RedisService<T> {

        private RedisSerializer keySerializer = null;

        /***
         * 初始化redis的key序列化器
         */

        @PostConstruct
        public void intRedisSerializer(){
            if (this.keySerializer == null){
                this.keySerializer = new JdkSerializationRedisSerializer(this.getClass().getClassLoader());
            }
        }


        @Autowired
        private JedisCluster jedisCluster;
        public String set(String key,T value,String nxxx,String expx,Integer seconds){
            if (null != seconds && 0 < seconds &&
                    (EX.equals(expx) || PX.equals(expx)) &&
                    (XX.equals(nxxx) || NX.equals(nxxx))){
                    return jedisCluster.set(key, JSONUtils.toJsonString(value),nxxx,expx,seconds);
                }else  {
                      if (NX.equals(nxxx)){
                          return String.valueOf(jedisCluster.setnx(key, JSONUtils.toJsonString(value)));

                      }else if (NX.equals(nxxx)){
                          return jedisCluster.set(key, JSONUtils.toJsonString(value));
                      }
                }
            return NO;
            }

        /**
         * 从redis中查询数据（一个数据）
          * @param key
         * @return
         */
        public T getOne(String key){
               return (T) JSONUtils.toObject(jedisCluster.get(key),Object.class);
            }


        /**
         *从redis中查询数据
         * @param key
         * @return
         */
        public String getString(String key){
                return jedisCluster.get(key);
            }


    /**
     * 从redis中查询数据（集合数据）
     * @param key
     * @return
     */
    public List<T> getLsit(String key){
            return (List<T>) JSONUtils.toList(jedisCluster.get(key),Object.class );
            }

     public Long delOne(Object key){
        return jedisCluster.del(rawKey(key));
     }

     public Long delMany(Collection<T> keys){
        if (CollectionUtils.isEmpty(keys)){
            return 0L;
        }else {
            byte [][] bytes = this.rawkeys(keys);
            return jedisCluster.del(bytes);
        }
     }

    /**
     * 把Object对象转换成字节数组
     * @param key
     * @return
     */
     private byte[] rawKey(Object key){
         Assert.notNull(key,"not null key required");

         return this.keySerializer == null && key instanceof byte[] ?
                 (byte[]) key : this.keySerializer.serialize(key);
     }

     private byte[][] rawkeys(Collection<T> keys){
        byte[][] rks = new byte[keys.size()][];
        int i = 0;
        Object key;
        for (Iterator i9 = keys.iterator(); i9.hasNext();rks[i++] = this.rawKey(key)){

            key = i9.next();
        }
        return rks;
     }

    }


