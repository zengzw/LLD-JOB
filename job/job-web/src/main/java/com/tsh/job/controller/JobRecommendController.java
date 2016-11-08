package com.tsh.job.controller;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.tsh.job.service.JobRecommendService;
import com.tsh.job.vo.CustomerJobRecommenedVo;
import com.tsh.job.vo.JobRecommendVo;
import com.tsh.job.vo.RecommendQueryVo;
import com.tsh.job.vo.ResponseMessageVo;
import com.tsh.job.controller.BaseController;
import com.dtds.platform.util.security.UserInfo;
import com.job.util.StringUtils;


@Controller
@RequestMapping("/jobRecommend")
public class JobRecommendController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(JobRecommendController.class);

    @Autowired
    private JobRecommendService jobRecommendService;


    /**
     * @param pages
     * @param rows
     * @return 返回站内广告列表数据
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/list")
    @ResponseBody
    public Pagination queryJobInfoPage(int page,int rows,String recJson){
        Result result = this.getResult();
        Pagination pagination = null;
        Page pageInfo = new Page(page,rows);
        RecommendQueryVo queryVO = JSONObject.parseObject(recJson, RecommendQueryVo.class);
        if(queryVO == null) queryVO = new RecommendQueryVo();

        result =  jobRecommendService.queryListRecommendInfo(result, pageInfo, queryVO);
        pagination = (Pagination)result.getData();

        return pagination;
    }
    
    
    
    
    /**
     * 保存招工接口对象
     * @param result
     * @param jobRecommend
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public ResponseMessageVo saveJobRecommend(String paramJson)  {
        Result result = this.getResult();
        UserInfo user = result.getUserInfo();
        CustomerJobRecommenedVo job = JSONObject.parseObject(paramJson, CustomerJobRecommenedVo.class);
        System.out.println(JSON.toJSONString(job));

        try{
            String[] ids = job.getJobIds().split(",");
            Long[] jobIds = StringUtils.stringArrayToLongArray(ids);
            for(Long id:jobIds){
                JobRecommendVo vo = new JobRecommendVo();
                if(StringUtils.isNotEmpty(job.getCity())){
                    vo.setCityId(StringUtils.parseLong(job.getCity()));
                }
                if(StringUtils.isNotEmpty(job.getProvince())){
                    vo.setProvinceId(StringUtils.parseLong(job.getProvince()));
                }
                if(StringUtils.isNotEmpty(job.getCountry())){
                    vo.setCountry(1L);
                }
                vo.setCityName(job.getCityName());
                vo.setProvinceName(job.getProvinceName());
                vo.setCreateTime(new Date());
                vo.setJobInfoId(id);
                vo.setCreateId(user.getUserId());
                vo.setStatus(1L);

                jobRecommendService.addJobRecommend(result, vo);
            }

        }catch(Exception e){
            log.error("保存出错",e);
            return this.getResError(getErrorMessage(e));
        }

        return getResSuccess("添加成功");
    }

    
    
    

    /**
     * 根据ID查询招工接口对象的数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public ResponseMessageVo getJobRecommendById(Long id,Long status){
        Result result = this.getResult();
        try {
            jobRecommendService.updateJobRecommend(result, id, status);
        } catch (Exception e) {
            log.error("修改出错！",e);
            return this.getResError(getErrorMessage(e));
        }

        return getResSuccess("修改成功");


    }




}
