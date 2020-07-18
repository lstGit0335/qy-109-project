package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.User;
import com.aaa.lwl.service.UserService;
import com.aaa.lwl.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.aaa.lwl.status.AddStatus.ADD_DATA_SUCCESS;
import static com.aaa.lwl.status.DeleteStatus.DELETE_DATA_SUCCESS;
import static com.aaa.lwl.status.SelectStatus.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wyh
 * date 2020-07-17
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends CommonController<User> {
    @Autowired
    private UserService userService;

    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }

    /**
     * 查询用户全部信息
     * @param user
     * @return
     */
    @PostMapping("/selectAllUser")
    ResultData selectAllUser(User user){
        Map<String,Object> selectUser = userService.selectAllUser();
        if (SELECT_DATA_SUCCESS.getCode().equals(selectUser.get("code"))){
            return super.operationSuccess(selectUser.get("data"));
        } else {
            return super.operationFailed();
        }
    }
    /**
     * 修改员工所有信息
     */
    @PostMapping("/updateUser")
    ResultData updateUser(@RequestBody  User user){
       return userService.updateUser(user);
    }
    /**
     * 批量删除
     */
    @PostMapping("/delUser/{ids}")
    ResultData delUser(@PathVariable ("ids") List<Long> ids){
        Map<String, Object> resultMap = userService.delUser(ids);
        if (DELETE_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.deleteSuccess();
        }else{
            return super.deleteFailed();
        }
    }
    /**
     * 通过id删除
     */
    @PostMapping("/delUserById")
    ResultData delUserById(@RequestParam("id") Long id){
        Map<String,Object> resultMap = userService.delUserByid(id);
        if (DELETE_DATA_SUCCESS.getCode().equals(resultMap.get("code"))){
            return super.deleteSuccess();
        }else{
            return super.deleteFailed();
        }
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    ResultData addUser(@RequestBody User user){
        Map<String, Object> addResult = userService.addUser(user);
        if (ADD_DATA_SUCCESS.getCode().equals(addResult.get("code"))){
            return super.INSERT_SUCCESS();
        }else{
            return super.INSERT_FAILED();
        }

    }
    /**
     * 导出EXcel
     */
    @GetMapping("/exportExcle")
    public void exportExcle(HttpServletResponse response){
        Map<String, Object> map = userService.selectAllUser();
        if (SELECT_DATA_SUCCESS.getCode().equals(map.get("code"))){
            List<User> users = (List<User>) map.get("data");
            //不为空，开始进行导出
            if (null != users && !users.isEmpty()){
                //list存放表格数据
                List<List<String>> excelData = new ArrayList<List<String>>();
                if(null != users){
                    //表格头
                    List<String> headList = new ArrayList<String>();
                    headList.add("用户ID");
                    headList.add("用户名");
                    headList.add("部门ID");
                    headList.add("邮箱");
                    headList.add("联系电话");
                    headList.add("状态");
                    headList.add("创建时间");
                    headList.add("修改时间");
                    headList.add("最近访问时间");
                    headList.add("性别");
                    headList.add("描述");
                    headList.add("用户类型");
                    //把表头放入表格数据中
                    excelData.add(headList);
                    //遍历表格数据并放入excelData
                    for (User user : users) {
                        List<String> list = new ArrayList<String>();
                        list.add(String.valueOf(user.getId()));
                        list.add(String.valueOf(user.getUsername()));
                        list.add(String.valueOf(user.getDeptId()));
                        list.add(String.valueOf(user.getEmail()));
                        list.add(String.valueOf(user.getMobile()));
                        if ("0".equals(user.getStatus())){
                            list.add("锁定");
                        }else if ("1".equals(user.getStatus())){
                            list.add("有效");
                        }
                        list.add(String.valueOf(user.getCreateTime()));
                        list.add(String.valueOf(user.getModifyTime()));
                        list.add(String.valueOf(user.getLastLoginTime()));
                        if ("0".equals(user.getSsex())){
                            list.add("男");
                        }else if ("1".equals(user.getSsex())){
                            list.add("女");
                        }else if ("2".equals(user.getSsex())){
                            list.add("保密");
                        }
                        list.add(String.valueOf(user.getDescription()));
                        if ("0".equals(user.getType())){
                            list.add("单位用户");
                        }else if ("1".equals(user.getType())){
                            list.add("审核用户");
                        }else if ("2".equals(user.getType())){
                            list.add("管理员");
                        }
                        //把数据放入excelData
                        excelData.add(list);
                    }
                }
                String sheetName = "用户信息";
                String fileName = "用户信息表";
                try {
                    ExcelUtil.exportExcel(response, excelData, sheetName, fileName, 12);
                } catch (IOException e) {
                    log.error("用户信息数据导出失败！");
                }

            }
        }else{
            log.error("用户管理中的导出数据出错！");
        }
    }
//    /**
//     * 分页查询全部用户
//     */
//    @PostMapping("/selectUser")
//    ResultData selectUserAll(@RequestBody HashMap map){
//        Map<String, Object> userAll = userService.selectAllUser(map);
//        if (SELECT_DATA_SUCCESS.getCode().equals(userAll.get("code"))){
//            return super.selectSuccess(userAll);
//        }else if (SELECT_DATA_FAILED.getCode().equals(userAll.get("code"))){
//            return super.selectFailed();
//        }else{
//            return super.selectFailed(SELECT_DATA_NOT_EXIST.getMsg());
//        }
//    }

}
