package com.tsh.job.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.service.JobInfoService;
import com.tsh.job.vo.JobInfoVo;
import com.tsh.job.vo.ResponseMessageVo;


@Controller
@RequestMapping("/jobInfo")
public class JobInfoController extends BaseController{
    @Autowired
    private JobInfoService jobInfoService;



    /**
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @RequestMapping(value = "/queryJobByCategoryCid")
    @ResponseBody
    public ResponseMessageVo queryJobByCategoryCid(Long categoryCid,Long cityId){
        Result result = this.getResult();
        if(categoryCid == null || cityId == null){
            return getResError("缺少参数");
        }

        jobInfoService.getJobInfoByCategoryCid(result, categoryCid,cityId);
        return getResSuccess("获取成功",result.getData());
    }



    /**
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/queryJobInfoPage")
    @ResponseBody
    public Pagination queryJobInfoPage(int page,int rows,String jobInfoJson){
        Result result = this.getResult();
        Pagination pagination = null;
        Page pageInfo = new Page(page,rows);
        JobInfoVo jobInfoVo = JSONObject.parseObject(jobInfoJson, JobInfoVo.class);
        if(jobInfoVo == null) jobInfoVo = new JobInfoVo();

        result =  jobInfoService.queryJobInfoList(result, pageInfo, jobInfoVo);
        pagination = (Pagination)result.getData();

        return pagination;
    }

    /**
     * 批量上下架 
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @RequestMapping(value = "/batch/updateTshStatus")
    @ResponseBody
    public ResponseMessageVo batchUpdateTshStatus(@RequestParam(value = "jobIds[]") Long[] jobIds,@RequestParam Long status){
        Result result = this.getResult();

        if(jobIds == null || status== null){
            return getResError("参数为空 ");
        }

        try{
            jobInfoService.bathUpdateJobInfoTshStatus(result, jobIds, status);
        }catch(Exception e){
            return getResError(getErrorMessage(e));
        }

        return getResSuccess("修改成功");
    }



    /**
     * 单个上下架 
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @RequestMapping(value = "/updateTshStatus")
    @ResponseBody
    public ResponseMessageVo updateTshStatus(@RequestParam  Long jobId,@RequestParam Long status){
        Result result = this.getResult();

        if(jobId == null || status== null){
            return getResError("参数为空 ");
        }
        try{
            jobInfoService.updateJobInfoTshStatus(result, jobId, status);
        }catch(Exception e){
            return getResError(getErrorMessage(e));
        }
        return getResSuccess("修改成功");
    }


    /**
     * 单个上下架 
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public ResponseMessageVo getJobInfoDetail(Long jobId){
        Result result = this.getResult();

        if(jobId == null ){
            return getResError("参数为空 ");
        }

        jobInfoService.getJobInfoDetailByJobId(result, jobId);

        return getResSuccess("修改成功",result.getData());
    }



}
