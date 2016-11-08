package com.tsh.job.controller;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Result;
import com.alibaba.fastjson.JSONObject;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.tsh.job.service.ApplyJobService;
import com.tsh.job.vo.ApplyJobQueryVo;
import com.tsh.job.vo.ResponseMessageVo;
import com.tsh.commons.JobConstants;
import com.tsh.job.controller.BaseController;
import com.dtds.platform.util.security.UserInfo;


@Controller
@RequestMapping("/applyJob")
public class ApplyJobController extends BaseController{
    @Autowired
    private ApplyJobService applyJobService;
    
    private org.slf4j.Logger logger = LoggerFactory.getLogger(ApplyJobController.class);



    /**
     * 根据ID查询招工接口对象的数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public ResponseMessageVo getApplyJobById(Long jobId,Long userId){
        if(jobId == null || userId == null){
            return getResError("缺少参数");
        }
        Result result = this.getResult();
        result = applyJobService.getApplyJobDetailByJobId(result,jobId,userId);
        return getResSuccess("获取成功", result.getData());
    }







    /**
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/list")
    @ResponseBody
    public Pagination queryApplyJobPage(int page,int rows,String applyJobJson){
        logger.info("-->applyJob reqeustParams :"+applyJobJson);
        
        Result result = this.getResult();
        UserInfo user = result.getUserInfo();
        Page pageInfo = new Page(page,rows);

        ApplyJobQueryVo queryVo = JSONObject.parseObject(applyJobJson, ApplyJobQueryVo.class);
        if(queryVo == null)queryVo=new ApplyJobQueryVo();
        boolean isBiz = (user.getRoleType().intValue() == JobConstants.RoleType.CITY.intValue());
        logger.info("login user role type:{},is cityrole:{}",user.getRoleType(),isBiz);
        if(isBiz){
            queryVo.setUserBlongBizId(user.getBizId());//县域
        }
        
        result = applyJobService.queryListApplyUserJob(result, pageInfo, queryVo);  
        Pagination pagination = (Pagination)result.getData();

        return pagination;
    }




}
