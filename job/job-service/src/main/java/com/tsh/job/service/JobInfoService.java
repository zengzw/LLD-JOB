package com.tsh.job.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.job.util.JobUtils;
import com.tsh.commons.JobConstants;
import com.tsh.commons.exceptions.BusinessRuntimeException;
import com.tsh.dubbo.bis.vo.CompanyVO;
import com.tsh.job.dao.CompanyDao;
import com.tsh.job.dao.JobDetailDao;
import com.tsh.job.dao.JobInfoDao;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.po.CommomCategoryPo;
import com.tsh.job.po.CompanyPo;
import com.tsh.job.po.JobDetailPo;
import com.tsh.job.po.JobInfoLogPo;
import com.tsh.job.po.JobInfoPo;
import com.tsh.job.vo.AppJobInfoVo;
import com.tsh.job.vo.CompanyVo;
import com.tsh.job.vo.JobDetailVo;
import com.tsh.job.vo.JobInfoLogVo;
import com.tsh.job.vo.JobInfoVo;


/**
 * 
 *  TSL： 是淘实惠缩写
 *  LLD： 是蓝领带缩写
 *  
 * @author zengzw
 * @date 2016年10月9日
 */
@Service
@SuppressWarnings("all")
public class JobInfoService {
    private static Logger logger = LoggerFactory.getLogger(JobInfoService.class);

    @Autowired
    private CommomAreaService areaService;

    @Autowired
    private CommomCategoryService categoryService;


    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobDetailService jobDetailService;

    @Autowired
    private JobInfoDao jobInfoDao;

    @Autowired
    private JobInfoLogService jobInfoLogService;

    @Autowired
    private PublishService publishService;


    /**
     * 新增招工接口对象
     * @param result
     * @param jobInfo
     * @return
     */
    public Result addJobInfo(Result result,JobInfoVo jobInfoVo)throws Exception{
        JobInfoPo jobInfoPo = new JobInfoPo();

        if (jobInfoVo != null) {

            copyProjectValue(jobInfoVo, jobInfoPo);
        }

        result = jobInfoDao.addJobInfo(result,jobInfoPo);
        return result;
    }
    
    

    /**
     * 根据子分类查询职位信息
     * 
     * @param result
     * @param categoryCid 子职位分类Id
     * @return
     */
    public Result getJobInfoByCategoryCid(Result result,Long categoryCid,Long cityId){
        result = jobInfoDao.getJobInfoByCategoryCid(result, categoryCid,cityId);
        return result;
    }




    /**
     * 复制属性
     * 
     * @param jobInfoVo
     * @param jobInfoPo
     */
    private void copyProjectValue(JobInfoVo jobInfoVo, JobInfoPo jobInfoPo) {
        if(jobInfoVo.getCode()!=null){
            jobInfoPo.setCode(jobInfoVo.getCode());
        }
        if(jobInfoVo.getCompId()!=null){
            jobInfoPo.setCompId(jobInfoVo.getCompId());
        }
        if(jobInfoVo.getJobId()!=null){
            jobInfoPo.setJobId(jobInfoVo.getJobId());
        }
        if(jobInfoVo.getJobName()!=null){
            jobInfoPo.setJobName(jobInfoVo.getJobName());
        }
        if(jobInfoVo.getSalaryMin()!=null){
            jobInfoPo.setSalaryMin(jobInfoVo.getSalaryMin());
        }
        if(jobInfoVo.getSalaryMax()!=null){
            jobInfoPo.setSalaryMax(jobInfoVo.getSalaryMax());
        }
        if(jobInfoVo.getHighligets()!=null){
            jobInfoPo.setHighligets(jobInfoVo.getHighligets());
        }
        if(jobInfoVo.getRecruitNumber()!=null){
            jobInfoPo.setRecruitNumber(jobInfoVo.getRecruitNumber());
        }
        if(jobInfoVo.getDeadline()!=null){
            jobInfoPo.setDeadline(jobInfoVo.getDeadline());
        }
        if(jobInfoVo.getProvinceId()!=null){
            jobInfoPo.setProvinceId(jobInfoVo.getProvinceId());
        }
        if(jobInfoVo.getCityId()!=null){
            jobInfoPo.setCityId(jobInfoVo.getCityId());
        }
        if(jobInfoVo.getZoneId()!=null){
            jobInfoPo.setZoneId(jobInfoVo.getZoneId());
        }
        if(jobInfoVo.getAddress()!=null){
            jobInfoPo.setAddress(jobInfoVo.getAddress());
        }
        if(jobInfoVo.getJobCategoryPid()!=null){
            jobInfoPo.setJobCategoryPid(jobInfoVo.getJobCategoryPid());
        }
        if(jobInfoVo.getJobCategoryCid()!=null){
            jobInfoPo.setJobCategoryCid(jobInfoVo.getJobCategoryCid());
        }
        if(jobInfoVo.getStatus()!=null){
            jobInfoPo.setStatus(jobInfoVo.getStatus());
        }
        if(jobInfoVo.getTshStatus()!=null){
            jobInfoPo.setTshStatus(jobInfoVo.getTshStatus());
        }
        if(jobInfoVo.getApplyNumber()!=null){
            jobInfoPo.setApplyNumber(jobInfoVo.getApplyNumber());
        }
        if(jobInfoVo.getTshApplyNumber()!=null){
            jobInfoPo.setTshApplyNumber(jobInfoVo.getTshApplyNumber());
        }
        if(jobInfoVo.getApplyNumCount()!=null){
            jobInfoPo.setApplyNumCount(jobInfoVo.getApplyNumCount());
        }
        if(jobInfoVo.getCreateTime()!=null){
            jobInfoPo.setCreateTime(jobInfoVo.getCreateTime());
        }
        if(jobInfoVo.getModifyTime()!=null){
            jobInfoPo.setModifyTime(jobInfoVo.getModifyTime());
        }
        if(jobInfoVo.getViewCount()!=null){
            jobInfoPo.setViewCount(jobInfoVo.getViewCount());
        }
        if(jobInfoVo.getPushTime()!=null){
            jobInfoPo.setPushTime(jobInfoVo.getPushTime());
        }

        if(jobInfoVo.getDownTime()!=null){
            jobInfoPo.setDownTime(jobInfoVo.getDownTime());
        }
    }




    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobInfoDetailByJobId(Result result,Long jobId){
        result = jobInfoDao.getJobInfoByJobId(result, jobId);
        JobInfoPo jobInfoPo = result.getData();
        Result jobResult = new Result();
        Result categoryResult = new Result();

        JobInfoVo jobInfoVo = new JobInfoVo();
        if(jobInfoPo != null){
            BeanUtils.copyProperties(jobInfoPo,jobInfoVo);
           setAreaName(jobResult, jobInfoPo, jobInfoVo);
           setCategory(categoryResult, jobInfoPo, jobInfoVo);
            setCompnay(jobInfoPo,jobInfoVo);
            setJobDetail(jobInfoPo, jobInfoVo);

        }
         result.setData(jobInfoVo);
         return result;
    }




    /**
     * 设置详情
     * 
     * @param result
     * @param jobInfoPo
     * @param jobInfoVo
     */
    private void setJobDetail(JobInfoPo jobInfoPo, JobInfoVo jobInfoVo) {
        Result result = new Result();
        JobDetailPo jobDetailPo = jobDetailService.getJobDetailByJobId(result, jobInfoPo.getJobId()).getData();
        JobDetailVo jobDetailVo = new JobDetailVo();
        BeanUtils.copyProperties(jobDetailPo, jobDetailVo);
        jobInfoVo.setJobDetailVo(jobDetailVo);
    }

    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return getJobInfoByJobId
     */
    public Result getJobInfoByJobId(Result result,Long jobId){
        result = jobInfoDao.getJobInfoByJobId(result, jobId);

        return result;
    }




    /**
     *  根据条件分页查询信息服务列表  （管理后台）
     *  
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobInfoList(Result result,Page page,JobInfoVo jobInfoVo){

        result = jobInfoDao.queryJobInfoList(result,page,jobInfoVo);

        Pagination pagination  = (Pagination)result.getData();
        List<JobInfoPo> lstJobPo = (List<JobInfoPo>) pagination.getRows();

        List<JobInfoVo> listVo = new ArrayList<>();
        Result jobResult = new Result();
        Result categoryResult = new Result();
        for(JobInfoPo po : lstJobPo){
            JobInfoVo job = new JobInfoVo();
            BeanUtils.copyProperties(po, job);
            BeanUtils.copyProperties(po.getCompanyPo(), job.getCompanyVo());
            //设置城市数据
            setAreaName(jobResult, po, job);
            //设置分类数据
            setCategory(categoryResult, po, job);

            listVo.add(job);

        }
        pagination.setRows(listVo);
        return result;
    }


    /**
     * 保存 或修改 招工接口对象(LLD API接口)
     * 
     * @param result
     * @param jobInfoVo job对象
     * @return
     */
    public Result saveOrUpdateJobInfo(Result result,JobInfoVo jobInfoVo) throws Exception {
        if(jobInfoVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }
        System.out.println("----job-------"+jobInfoVo.getJobId());
        result = jobInfoDao.getJobInfoByJobId(result, jobInfoVo.getJobId());
        JobInfoPo jobInfoPo  = (JobInfoPo)result.getData();

        if (jobInfoPo != null){
            logger.info(">>>>>>>> jobId:{}已经存在，进行修改操作",jobInfoPo.getJobId());

            //如果TSH 下架不做处理。如果TSH上架，LLD下架，我们做下架操作。
            if(jobInfoPo.getTshStatus() == JobConstants.JobStatus.UP){
                int status = jobInfoVo.getStatus().intValue();
                if(status == JobConstants.LLDJobStatus.CLOSE_RECRUIT
                        || status == JobConstants.LLDJobStatus.STOP_RECRUIT
                        || status == JobConstants.LLDJobStatus.DELETED){

                    jobInfoVo.setTshStatus(JobConstants.JobStatus.DOWN);
                }
            }
            copyProjectValue(jobInfoVo, jobInfoPo);
            //设置报名总数
            Long inApplyNum = jobInfoPo.getTshApplyNumber() == null ? 0 : jobInfoPo.getTshApplyNumber();
            Long outApplyNum = jobInfoPo.getApplyNumber()  == null ? 0 : jobInfoPo.getApplyNumber();
            jobInfoPo.setApplyNumCount(inApplyNum + outApplyNum);
        }
        else{
            jobInfoPo = new JobInfoPo();
            copyProjectValue(jobInfoVo, jobInfoPo);
            //第一次同步，为上架状态。
            jobInfoPo.setTshStatus(JobConstants.JobStatus.INIT);
            jobInfoPo.setCode(JobUtils.getJobCode());
            result = jobInfoDao.addJobInfo(result,jobInfoPo);
        }

        return result;
    }


    /**
     * 批量修改上下架状态
     * @param result
     * @param tshStauts 状态
     * @return
     */
    public Result bathUpdateJobInfoTshStatus(Result result,Long[] jobIds,Long tshStatus){
        if(jobIds == null){
            return result;
        }

        for(Long jobId:jobIds){
            jobInfoDao.getJobInfoByJobId(result, jobId);
            JobInfoPo jobInfoPo = result.getData();
            //判断状态是否匹配，不匹配不操作
            if((tshStatus == JobConstants.JobStatus.DOWN
                    && jobInfoPo.getTshStatus() != JobConstants.JobStatus.UP)){
                continue;
            }
            else if(tshStatus == JobConstants.JobStatus.UP
                    && (jobInfoPo.getTshStatus() != JobConstants.JobStatus.DOWN 
                    && jobInfoPo.getTshStatus() != JobConstants.JobStatus.INIT)){
                continue;
            }
            
            validateLLDStatus(jobInfoPo,tshStatus);

            updateJobInfo(result, tshStatus, jobInfoPo);
        }

        return result;
    }



    /**
     * 判断上架的状态
     * 
     * @param jobInfoPo
     */
    private void validateLLDStatus(JobInfoPo jobInfoPo,Long tshStatus) {
        if(tshStatus == JobConstants.JobStatus.UP && 
                jobInfoPo.getStatus() != JobConstants.LLDJobStatus.RECRUITTING){
            throw new BusinessRuntimeException("", "当前职位，不能上架！");
        }
    }


    /**
     * 单个修改上下架状态
     * 
     * @param result
     * @param tshStauts 状态
     * @return
     */
    public Result updateJobInfoTshStatus(Result result,Long jobId,Long tshStatus){
        if(jobId == null){
            throw new BusinessRuntimeException("", "缺少参数");
        }

        JobInfoPo jobInfoPo = getJobInfoByJobId(result, jobId).getData();
        if(jobInfoPo == null){
            throw new BusinessRuntimeException("", "找不到记录");
        }

        validateLLDStatus(jobInfoPo,tshStatus);
        
        updateJobInfo(result, tshStatus, jobInfoPo);

        return result;
    }




    /**
     * @param result
     * @param tshStatus
     * @param jobInfoPo
     */
    private void updateJobInfo(Result result, Long tshStatus, JobInfoPo jobInfoPo) {
        //修改状态
        jobInfoPo.setTshStatus(tshStatus);
        jobInfoPo.setModifyTime(new Date());
        if(tshStatus == JobConstants.JobStatus.DOWN){
            jobInfoPo.setDownTime(new Date());
        }else{
            jobInfoPo.setPushTime(new Date());
        }
        jobInfoDao.updateJobInfoTshStatus(result,jobInfoPo);

        //保存上下架日志记录
        JobInfoLogVo jobInfoLogVo = getJobLogInfo(jobInfoPo.getJobId(), tshStatus);
        jobInfoLogService.addJobInfoLog(result, jobInfoLogVo);
    }




    /**
     * @param jobId
     * @param tshStatus
     */
    private JobInfoLogVo getJobLogInfo(Long jobId, Long tshStatus) {
        String action = tshStatus == JobConstants.JobStatus.DOWN ? "下架":"上架";
        JobInfoLogVo jobInfoLogPo = new JobInfoLogVo();
        jobInfoLogPo.setAction(action);
        jobInfoLogPo.setCreateTime(new Date());
        jobInfoLogPo.setJobInfoId(jobId);
        return jobInfoLogPo;
    }



    /**
     * 设置公司
     * 
     * @param po
     * @param job
     */
    private void setCompnay(JobInfoPo po,JobInfoVo job){
        CompanyPo companyPo = po.getCompanyPo();
        CompanyVo companyVo = new CompanyVo();
        BeanUtils.copyProperties(companyPo,companyVo);
        job.setCompanyVo(companyVo);

    }


    
    /**
     * @param jobResult
     * @param po
     * @param jobInfoVo
     */
    public void setAreaName(Result jobResult, JobInfoPo po, JobInfoVo jobInfoVo) {
        areaService.getCommomAreaById(jobResult,po.getProvinceId()+"");
        CommomAreaPo commomAreaPo = jobResult.getData();
        jobInfoVo.setProviceName(commomAreaPo.getName());
        jobResult.setData(null);

        areaService.getCommomAreaById(jobResult,po.getCityId()+"");
        commomAreaPo = jobResult.getData();
        jobInfoVo.setCityName(commomAreaPo.getName());
        jobResult.setData(null);

        areaService.getCommomAreaById(jobResult,po.getZoneId()+"");
        commomAreaPo = jobResult.getData();
        jobInfoVo.setZoneName(commomAreaPo.getName());
        jobResult.setData(null);
    }



    /**
     * @param categoryResult
     * @param po
     * @param job
     */
    public void setCategory(Result categoryResult, JobInfoPo po, JobInfoVo job) {
        categoryService.getCommomCategoryById(categoryResult,po.getJobCategoryPid()+"");
        CommomCategoryPo categoryPo = categoryResult.getData();
        job.setCtNameOne(categoryPo.getName());
        categoryResult.setData(null);

        categoryService.getCommomCategoryById(categoryResult,po.getJobCategoryCid()+"");
        categoryPo = categoryResult.getData();
        job.setCtNameTwo(categoryPo.getName());
        categoryResult.setData(null);
    }
    
    
    public void test(Result result){
        jobInfoDao.updateJobInfoViewCount(result, 5L, 1);
    }
    
}
