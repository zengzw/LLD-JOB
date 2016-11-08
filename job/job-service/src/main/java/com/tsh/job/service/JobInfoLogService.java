package com.tsh.job.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.tsh.job.dao.JobInfoLogDao;
import com.tsh.job.po.JobInfoLogPo;
import com.tsh.job.vo.JobInfoLogVo;


@Service
@SuppressWarnings("all")
public class JobInfoLogService {
    @Autowired
    private JobInfoLogDao jobInfoLogDao;

    /**
     * 新增招工接口对象
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result addJobInfoLog(Result result,JobInfoLogVo jobInfoLogVo){
        JobInfoLogPo jobInfoLogPo = new JobInfoLogPo();

        if (jobInfoLogVo != null) {
            copyProperties(jobInfoLogVo, jobInfoLogPo);
        }

        result = jobInfoLogDao.addJobInfoLog(result,jobInfoLogPo);
        return result;
    }



    /**
     * @param jobInfoLogVo
     * @param jobInfoLogPo
     */
    private void copyProperties(JobInfoLogVo jobInfoLogVo, JobInfoLogPo jobInfoLogPo) {
        if(jobInfoLogVo.getAction()!=null){
            jobInfoLogPo.setAction(jobInfoLogVo.getAction());
        }
        if(jobInfoLogVo.getCreateId()!=null){
            jobInfoLogPo.setCreateId(jobInfoLogVo.getCreateId());
        }
        if(jobInfoLogVo.getCreateTime()!=null){
            jobInfoLogPo.setCreateTime(jobInfoLogVo.getCreateTime());
        }
        if(jobInfoLogVo.getJobInfoId()!=null){
            jobInfoLogPo.setJobInfoId(jobInfoLogVo.getJobInfoId());
        }
    }



    /**
     * 保存 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result saveJobInfoLog(Result result,JobInfoLogVo jobInfoLogVo,UserInfo user) throws Exception {
        if(jobInfoLogVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = jobInfoLogVo.getId();
        result = jobInfoLogDao.getJobInfoLogById(result,id);
        JobInfoLogPo jobInfoLogPo  = (JobInfoLogPo)result.getData();

        if (jobInfoLogPo != null) {
            copyProperties(jobInfoLogVo, jobInfoLogPo);
        }else{
            jobInfoLogPo = new JobInfoLogPo();
            copyProperties(jobInfoLogVo, jobInfoLogPo);
            result = jobInfoLogDao.addJobInfoLog(result,jobInfoLogPo);
        }
        return result;
    }



    /**
     * 保存 招工接口对象
     * @param result
     * @return
     */
    public Result saveJobInfoLog(Result result,JobInfoLogVo jobInfoLogVo) throws Exception {
        if(jobInfoLogVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = jobInfoLogVo.getId();
        result = jobInfoLogDao.getJobInfoLogById(result,id);
        JobInfoLogPo jobInfoLogPo  = (JobInfoLogPo)result.getData();

        if (jobInfoLogPo != null) {
            copyProperties(jobInfoLogVo, jobInfoLogPo);
        }else{
            jobInfoLogPo = new JobInfoLogPo();
            copyProperties(jobInfoLogVo, jobInfoLogPo);
            result = jobInfoLogDao.addJobInfoLog(result,jobInfoLogPo);
        }
        return result;
    }


  
    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteJobInfoLog(Result result, Long id) throws Exception {
        result = jobInfoLogDao.deleteJobInfoLog(result,id);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result batchDelJobInfoLog(Result result, List<JobInfoLogVo> jobInfoLog_list)throws Exception{
        List<JobInfoLogVo> list = new ArrayList<JobInfoLogVo>(); 
        jobInfoLogDao.batchDelete(list);
        return result;
    }


    /**
     * 批量删除招工接口对象ByIds
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result batchDelJobInfoLogByIds(Result result,Long[] ids)throws Exception{
        jobInfoLogDao.batchDelJobInfoLogByIds(result,ids);
        return result;
    }





    /**
     * 根据ID获取 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result getJobInfoLogById(Result result,Long id,UserInfo user) throws Exception{
        result = jobInfoLogDao.getJobInfoLogById(result,id);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobInfoLogById(Result result,Long id) throws Exception{
        result = jobInfoLogDao.getJobInfoLogById(result,id);
        return result;
    }


    /**
     * 更新 招工接口对象
     * @param result
     * @return
     */
    public Result updateJobInfoLog(Result result,JobInfoLogVo jobInfoLogVo) throws Exception {
        Long id = jobInfoLogVo.getId();
        result = jobInfoLogDao.getJobInfoLogById(result,id);
        JobInfoLogPo jobInfoLogPo  = (JobInfoLogPo)result.getData();
        if (jobInfoLogPo != null) {
            copyProperties(jobInfoLogVo, jobInfoLogPo);
        }
        return result;
    }


}
