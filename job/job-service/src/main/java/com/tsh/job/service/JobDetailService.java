package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.JobDetailPo;
import com.tsh.job.vo.JobDetailVo;
import com.tsh.job.dao.JobDetailDao;


@Service
@SuppressWarnings("all")
public class JobDetailService {
    @Autowired
    private JobDetailDao jobDetailDao;

    /**
     * 新增职位详情接口对象
     * @param result
     * @param jobDetail
     * @return
     */
    public Result addJobDetail(Result result,JobDetailVo jobDetailVo)throws Exception{
        JobDetailPo jobDetailPo = new JobDetailPo();

        if (jobDetailVo != null) {
            copyProjectValue(jobDetailVo, jobDetailPo);
        }

        result = jobDetailDao.addJobDetail(result,jobDetailPo);
        return result;
    }



    /**
     * 保存 职位详情接口对象
     * @param result
     * @return
     */
    public Result saveorUpdateJobDetail(Result result,JobDetailVo jobDetailVo) throws Exception {
        if(jobDetailVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        result = jobDetailDao.getJobDetailByJobId(result, jobDetailVo.getJobInfoId());
        JobDetailPo jobDetailPo  = (JobDetailPo)result.getData();

        if (jobDetailPo != null) {
            copyProjectValue(jobDetailVo, jobDetailPo);
        }else{
            jobDetailPo = new JobDetailPo();
            copyProjectValue(jobDetailVo, jobDetailPo);
            result = jobDetailDao.addJobDetail(result,jobDetailPo);
        }
        return result;
    }



    /**
     * 根据ID获取 职位详情接口对象
     * @param result
     * @return
     */
    public Result getJobDetailByJobId(Result result,Long jobId){
        result = jobDetailDao.getJobDetailByJobId(result,jobId);
        JobDetailPo jobDetailPo = result.getData();
        return result;
    }



    /**
     * @param jobDetailVo
     * @param jobDetailPo
     */
    private void copyProjectValue(JobDetailVo jobDetailVo, JobDetailPo jobDetailPo) {
        if(jobDetailVo.getJobInfoId()!=null){
            jobDetailPo.setJobInfoId(jobDetailVo.getJobInfoId());
        }
        if(jobDetailVo.getEntryAward()!=null){
            jobDetailPo.setEntryAward(jobDetailVo.getEntryAward());
        }
        if(jobDetailVo.getSalaryDesc()!=null){
            jobDetailPo.setSalaryDesc(jobDetailVo.getSalaryDesc());
        }
        if(jobDetailVo.getWorkContent()!=null){
            jobDetailPo.setWorkContent(jobDetailVo.getWorkContent());
        }
        if(jobDetailVo.getEnvironment()!=null){
            jobDetailPo.setEnvironment(jobDetailVo.getEnvironment());
        }
        if(jobDetailVo.getRequirements()!=null){
            jobDetailPo.setRequirements(jobDetailVo.getRequirements());
        }
        if(jobDetailVo.getBenefit()!=null){
            jobDetailPo.setBenefit(jobDetailVo.getBenefit());
        }
        if(jobDetailVo.getIntroduction()!=null){
            jobDetailPo.setIntroduction(jobDetailVo.getIntroduction());
        }
        if(jobDetailVo.getImages()!=null){
            jobDetailPo.setImages(jobDetailVo.getImages());
        }
    }

}
