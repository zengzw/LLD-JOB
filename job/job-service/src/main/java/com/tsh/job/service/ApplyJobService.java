package com.tsh.job.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.github.ltsopensource.core.domain.Job;
import com.job.util.JobUtils;
import com.tsh.dubbo.bis.vo.CompanyVO;
import com.tsh.job.dao.ApplyJobDao;
import com.tsh.job.po.ApplyJobPo;
import com.tsh.job.po.ApplyUserPo;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.po.CommomCategoryPo;
import com.tsh.job.po.JobInfoPo;
import com.tsh.job.vo.ApplyJobQueryVo;
import com.tsh.job.vo.ApplyJobVo;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.vo.CompanyVo;
import com.tsh.job.vo.CustomerApplyJobVo;
import com.tsh.job.vo.JobInfoVo;


@Service
@SuppressWarnings("all")
public class ApplyJobService {


    private Logger LOGGER = LoggerFactory.getLogger(ApplyJobService.class);


    @Autowired
    private ApplyJobDao applyJobDao;
    
    @Autowired
    private JobInfoService jobService;
    
    @Autowired
    private ApplyUserService userService;
    
    @Autowired
    private CommomAreaService areaService;

    @Autowired
    private CommomCategoryService categoryService;

    /**
     * 新增招工接口对象
     * @param result
     * @param applyJob
     * @return
     */
    public Result addApplyJob(Result result,ApplyJobVo applyJobVo)throws Exception{
        ApplyJobPo applyJobPo = new ApplyJobPo();

        if (applyJobVo != null) {
            copyProperties(applyJobVo, applyJobPo);
        }

        result = applyJobDao.addApplyJob(result,applyJobPo);
        return result;
    }



    /**
     * 保存 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result updateApplyJob(Result result,ApplyJobVo applyJobVo) throws Exception {
        if(applyJobVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        result = applyJobDao.getApplyJobByUserId(result,applyJobVo.getApplyUserId(),applyJobVo.getJobInfoId());
        ApplyJobPo applyJobPo  = (ApplyJobPo)result.getData();

        if (applyJobPo != null) {
            copyProperties(applyJobVo, applyJobPo);
        }else{
            LOGGER.info(">>>>> 没有找到数据,uerId:{},jobId:{}",applyJobVo.getApplyUserId(),applyJobVo.getJobInfoId());
        }

        return result;
    }



    /**
     * 保存 招工接口对象
     * @param result
     * @return
     */
    public Result saveApplyJob(Result result,ApplyJobVo applyJobVo) throws Exception {
        if(applyJobVo == null){
            result.setData("参数为空，保存失败");
            return result;
        }

        Long id = applyJobVo.getId();
        result = applyJobDao.getApplyJobById(result,id);
        ApplyJobPo applyJobPo  = (ApplyJobPo)result.getData();

        if (applyJobPo != null) {
            copyProperties(applyJobVo, applyJobPo);
        }else{
            applyJobPo = new ApplyJobPo();
            copyProperties(applyJobVo, applyJobPo);
            result = applyJobDao.addApplyJob(result,applyJobPo);
        }
        return result;
    }




    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyJobList(Result result,Page page,ApplyJobVo applyJobVo){
        ApplyJobPo applyJobPo = new ApplyJobPo();
        result = applyJobDao.queryApplyJobList(result,page,applyJobPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表 带User
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyJobList(Result result,Page page,ApplyJobVo applyJobVo,UserInfo user){
        ApplyJobPo applyJobPo = new ApplyJobPo();
        /**
         *自行匹配需要查询的字段及值
         **/
        result = applyJobDao.queryApplyJobList(result,page,applyJobPo);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象 带User对象
     * @param result
     * @return
     */
    public Result getApplyJobById(Result result,Long id,UserInfo user) throws Exception{
        result = applyJobDao.getApplyJobById(result,id);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getApplyJobById(Result result,Long id) throws Exception{
        result = applyJobDao.getApplyJobById(result,id);
        return result;
    }



    /**
     * @param applyJobVo
     * @param applyJobPo
     */
    private void copyProperties(ApplyJobVo applyJobVo, ApplyJobPo applyJobPo) {
        if(applyJobVo.getApplyUserId()!=null){
            applyJobPo.setApplyUserId(applyJobVo.getApplyUserId());
        }
        if(applyJobVo.getJobInfoId()!=null){
            applyJobPo.setJobInfoId(applyJobVo.getJobInfoId());
        }
        if(applyJobVo.getJobStatus()!=null){
            applyJobPo.setJobStatus(applyJobVo.getJobStatus());
        }
        if(applyJobVo.getApplyAddress()!=null){
            applyJobPo.setApplyAddress(applyJobVo.getApplyAddress());
        }
        if(applyJobVo.getCreateTime()!=null){
            applyJobPo.setCreateTime(applyJobVo.getCreateTime());
        }
        if(applyJobVo.getShopId()!=null){
            applyJobPo.setShopId(applyJobVo.getShopId());
        }
        if(applyJobVo.getShopName()!=null){
            applyJobPo.setShopName(applyJobVo.getShopName());
        }
        if(applyJobVo.getCityId()!=null){
            applyJobPo.setCityId(applyJobVo.getCityId());
        }
        if(applyJobVo.getCityName()!=null){
            applyJobPo.setCityName(applyJobVo.getCityName());
        }
        if(applyJobVo.getPvId()!=null){
            applyJobPo.setPvId(applyJobVo.getPvId());
        }
        if(applyJobVo.getPvName()!=null){
            applyJobPo.setPvName(applyJobVo.getPvName());
        }
        if(applyJobVo.getApplyTime()!=null){
            applyJobPo.setApplyTime(applyJobVo.getApplyTime());
        }
        if(applyJobVo.getInterviewTime()!=null){
            applyJobPo.setInterviewTime(applyJobVo.getInterviewTime());
        }
        if(applyJobVo.getEntryTime()!=null){
            applyJobPo.setEntryTime(applyJobVo.getEntryTime());
        }
        if(applyJobVo.getLeaveTime()!=null){
            applyJobPo.setLeaveTime(applyJobVo.getLeaveTime());
        }
        if(applyJobVo.getRemark()!=null){
            applyJobPo.setRemark(applyJobVo.getRemark());
        }
        if(applyJobVo.getIsFinished()!=null){
            applyJobPo.setIsFinished(applyJobVo.getIsFinished());
        }
        if(applyJobVo.getPushState()!=null){
            applyJobPo.setPushState(applyJobVo.getPushState());
        }
        if(applyJobVo.getPushTime()!=null){
            applyJobPo.setPushTime(applyJobVo.getPushTime());
        }
    }

    /**
     * 获取所有未推送的数据
     * 
     * @return
     */
    public Result getNoPushListApplyJob(Result result){
         return applyJobDao.getNoPushListApplyJob(result);
    }
    
    /**
     * 根据JobId,用户Id获取用已报名详细信息
     * 
     * @return
     */
    public Result getApplyJobDetailByJobId(Result result,Long jobId,Long userId){
        ApplyJobVo applyJobVo = new ApplyJobVo();
        ApplyJobPo applyJobPo =  applyJobDao.getApplyJobByUserId(result, userId, jobId).getData();
        if(applyJobPo != null){
            BeanUtils.copyProperties(applyJobPo, applyJobVo);
            
            //获取职位信息
            JobInfoPo jobInfoPo = jobService.getJobInfoByJobId(result, applyJobPo.getJobInfoId()).getData();
            JobInfoVo jobInfoVo = new JobInfoVo();
            BeanUtils.copyProperties(jobInfoPo,jobInfoVo);
            setAreaName(jobInfoPo,jobInfoVo);
            setCategory(jobInfoPo,jobInfoVo);
            
            CompanyVo companyVO = new CompanyVo();
            BeanUtils.copyProperties(jobInfoPo.getCompanyPo(),companyVO);
            jobInfoVo.setCompanyVo(companyVO);
            applyJobVo.setJobInfoVo(jobInfoVo);
            
            //获取用户信息
            ApplyUserPo userPo = userService.getApplyUserById(result, applyJobPo.getApplyUserId()).getData();
            ApplyUserVo userVo = new ApplyUserVo();
            BeanUtils.copyProperties(userPo,userVo);
            applyJobVo.setApplyUserVo(userVo);
            
        }
        
        result.setData(applyJobVo);
        return result;
    }

    
    

    /**
     * @param categoryResult
     * @param po
     * @param job
     */
    public void setCategory(JobInfoPo po, JobInfoVo job) {
        Result categoryResult = new Result();
        categoryService.getCommomCategoryById(categoryResult,po.getJobCategoryPid()+"");
        CommomCategoryPo categoryPo = categoryResult.getData();
        job.setCtNameOne(categoryPo.getName());
        categoryResult.setData(null);

        categoryService.getCommomCategoryById(categoryResult,po.getJobCategoryCid()+"");
        categoryPo = categoryResult.getData();
        job.setCtNameTwo(categoryPo.getName());
        categoryResult.setData(null);
    }
    
    /**
     * @param jobResult
     * @param po
     * @param jobInfoVo
     */
    public void setAreaName(JobInfoPo po, JobInfoVo jobInfoVo) {
        Result jobResult = new Result();
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
     *  获取已报名列表
     *  
     * @param result
     * @param page
     * @param q
     * @return
     */
    public Result queryListApplyUserJob(Result result,Page page,ApplyJobQueryVo q){
        //格式化时间
        if(q.getBeginCreateTime() != null){
            Date date = JobUtils.parseSelectCondition(q.getBeginCreateTime() , 1);
            q.setBeginCreateTime(date);
        }

        if(q.getEndCreateTime() != null){
            Date date = JobUtils.parseSelectCondition(q.getEndCreateTime(), 2);
            q.setEndCreateTime(date);
        }
        Pagination pagination =  applyJobDao.queryApplyUserJob(result, page, q).getData();
        if(pagination != null && pagination.getRows() != null){
            List<CustomerApplyJobVo> list = (List<CustomerApplyJobVo>) pagination.getRows();
            for(CustomerApplyJobVo job:list){
                setAreaName(job);
                setCategory(job);
                String idCard = job.getIdCard().substring(0,job.getIdCard().length()-4)+"****";
                job.setIdCard(idCard);
            }
            
            
            pagination.setRows(list);
        }
        
        result.setData(pagination);
        return result;
    }

    public static void main(String[] args) {
        String idCard = "000222223349876";
        System.out.println(idCard.substring(0,idCard.length()-4)+"****");
    }
    
    /**
     * @param jobResult
     * @param po
     * @param jobInfoVo
     */
    public void setAreaName(CustomerApplyJobVo job) {
        Result jobResult = new Result();
        areaService.getCommomAreaById(jobResult,job.getContactProvince()+"");
        CommomAreaPo commomAreaPo = jobResult.getData();
        job.setProviceName(commomAreaPo.getName());
        jobResult.setData(null);

        areaService.getCommomAreaById(jobResult,job.getContactCity()+"");
        commomAreaPo = jobResult.getData();
        job.setCityName(commomAreaPo.getName());
        jobResult.setData(null);

        areaService.getCommomAreaById(jobResult,job.getContactArea()+"");
        commomAreaPo = jobResult.getData();
        job.setZoneName(commomAreaPo.getName());
        jobResult.setData(null);
    }



    /**
     * @param categoryResult
     * @param po
     * @param job
     */
    public void setCategory(CustomerApplyJobVo job) {
        Result categoryResult = new Result();
        categoryService.getCommomCategoryById(categoryResult,job.getCategoryPid()+"");
        CommomCategoryPo categoryPo = categoryResult.getData();
        job.setCtNameOne(categoryPo.getName());
        categoryResult.setData(null);

        categoryService.getCommomCategoryById(categoryResult,job.getCategoryCid()+"");
        categoryPo = categoryResult.getData();
        job.setCtNameTwo(categoryPo.getName());
        categoryResult.setData(null);
    }

}
