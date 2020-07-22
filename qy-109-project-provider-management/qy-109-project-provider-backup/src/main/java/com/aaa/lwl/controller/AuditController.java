package com.aaa.lwl.controller;

import com.aaa.lwl.base.BaseService;
import com.aaa.lwl.base.CommonController;
import com.aaa.lwl.base.ResultData;
import com.aaa.lwl.model.Audit;
import com.aaa.lwl.service.AuditService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * fileName:AuditController
 * Author:李守堂
 * createTime:2020/7/17   22:23
 * version:1.0.0
 * Description
 */
@RestController
public class AuditController extends CommonController {

    @Autowired
    private AuditService auditService;


    @Override
    public BaseService getBaseService() {
        return auditService;
    }

    /**
     * 分頁查詢audit
     * @param audit
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAuditByPage")
    public ResultData selectAuditByPage(Audit audit, @RequestParam("pageNumber") Integer pageNumber,
                                        @RequestParam("pageSize") Integer pageSize){
        PageInfo<Audit> auditPageInfo = auditService.selectListByPage(audit, pageNumber, pageSize);
        if (auditPageInfo != null && !"".equals(auditPageInfo)){
            return operationSuccess(auditPageInfo);
        }else {
            return operationFailed();
        }
    }

    /**
     * 查询所有
     * @param audit
     * @return
     */

    @PostMapping("/allAudit")
    public ResultData selectAll(Audit audit){
        List<Audit> auditList = auditService.selectList(audit);
        if (auditList.size()>0){
            return operationSuccess(auditList);
        }else {
            return operationFailed();
        }
    }


    /**
     * 添加数据
     * @param audit
     * @return
     */
    @PostMapping("/insertAudit")
    public ResultData insert(Audit audit){
        Integer add = auditService.add(audit);
        if (add > 0){
            return INSERT_SUCCESS();
        }else {
            return INSERT_FAILED();
        }
    }

    /**
     * 删除数据根据主键
     * @param audit
     * @return
     */
    @PostMapping("/deleteAudit")
    public ResultData delete(Audit audit){
        Integer delete = auditService.delete(audit);

        if (delete > 0){
            return  DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }

    }

    /**
     * 更新数据
     * @param audit
     * @return
     */
    @PostMapping("/updateAudit")
    public ResultData update(Audit audit){
        Integer update = auditService.update(audit);
        if (update > 0){
            return UPDATE_SUCCESS();
        }else {
            return UPDATE_FAILED();
        }


    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteAuditByIds")
    public ResultData deleteByIds(@RequestParam("ids") List<Integer> ids){
        Integer integer = auditService.deleteByIds(ids);
        if (integer > 0){
            return DELETE_SUCCESS();
        }else {
            return DELETE_FAILED();
        }
    }


}
