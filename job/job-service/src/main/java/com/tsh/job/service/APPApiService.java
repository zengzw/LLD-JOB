/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dtds.platform.commons.utility.DateUtil;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.job.util.JobUtils;
import com.job.util.StringUtils;
import com.tsh.commons.JobConstants;
import com.tsh.commons.exceptions.BusinessException;
import com.tsh.dubbo.bis.api.AreaApi;
import com.tsh.dubbo.bis.vo.AreaInfoVO;
import com.tsh.dubbo.share.api.AddressApi;
import com.tsh.job.dao.ApplyJobDao;
import com.tsh.job.dao.ApplyUserDao;
import com.tsh.job.dao.CommomAreaDao;
import com.tsh.job.dao.CommomCategoryDao;
import com.tsh.job.dao.JobDetailDao;
import com.tsh.job.dao.JobInfoDao;
import com.tsh.job.dao.JobRecommendDao;
import com.tsh.job.po.ApplyJobPo;
import com.tsh.job.po.ApplyUserPo;
import com.tsh.job.po.CommomCategoryPo;
import com.tsh.job.po.JobDetailPo;
import com.tsh.job.po.JobInfoPo;
import com.tsh.job.po.JobRecommendPo;
import com.tsh.job.vo.AppJobInfoVo;
import com.tsh.job.vo.AppJobListVo;
import com.tsh.job.vo.AppUserApplyJobVo;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.vo.CommomCategoryVo;
import com.tsh.job.vo.JobInfoVo;
import com.tsh.share.vo.AreaVo;

/**
 *
 * APP 服务接口
 * 
 * @author zengzw
 * @date 2016年10月13日
 */
@Service
public class APPApiService {
    private static Logger LOGGER = LoggerFactory.getLogger(APPApiService.class);

    private static int LIMIT_APPLY_COUNT = 5;

    @Autowired
    private ApplyJobDao applyJobDao;


    @Autowired
    private ApplyUserDao applyUserDao;

    @Autowired
    private CommomAreaDao areaDao;

    @Autowired
    private CommomCategoryDao categoryDao;

    @Autowired
    private JobInfoDao jobInfoDao;

    @Autowired
    private JobDetailDao jobDetailDao;


    @Autowired
    private PublishService publishService;

    @Autowired
    private AreaApi areaApi;

    @Autowired
    private SyncJobService syncJobService;

    @Autowired
    private JobRecommendDao jobRecommendDao;

    @Autowired
    private AddressApi addressApi;


    /** 
     *  组装job成app端需要的数据
     *  
     * @param result
     * @param lstAppJob
     * @param job
     */
    private void assemblingAppJobList(Result result, List<AppJobListVo> lstAppJob, JobInfoPo job) {
        AppJobListVo appJobListVo = new AppJobListVo();
        appJobListVo.setApplyCount(job.getApplyNumCount());
        appJobListVo.setCompName(job.getCompanyPo().getName());
        appJobListVo.setJobId(job.getJobId());
        appJobListVo.setHighligets(job.getHighligets());
        appJobListVo.setJobName(job.getJobName());

        //获取图片，默认取第一张
        JobDetailPo jobDetailPo =  jobDetailDao.getJobDetailByJobId(result, job.getJobId()).getData();
        if(jobDetailPo!= null && jobDetailPo.getImages() != null){
            String[] images = jobDetailPo.getImages().split(",");
            appJobListVo.setImages(images[0]);
        }
        appJobListVo.setSalary("￥"+job.getSalaryMin()+"-"+job.getSalaryMax()+" /月");

        //设置职位分类信息
        CommomCategoryPo category = categoryDao.getCommomCategoryById(result, job.getJobCategoryCid()+"").getData();
        if(category != null){
            appJobListVo.setCategoryName(category.getName());
        }

        lstAppJob.add(appJobListVo);
    }




    /**
     * 组装获取job
     * 
     * @param result
     * @param listResult
     */
    private  List<JobInfoPo> assemblingJob(Result result, List<JobRecommendPo> listResult) {
        List<JobInfoPo> lstJobs = new ArrayList<>();
        if(!CollectionUtils.isEmpty(listResult)){
            //根据JobId 获取job信息,取前三条
            for(int i = 0; i<listResult.size();i++){
                if(i >2){
                    break;
                }

                JobRecommendPo rp = listResult.get(i);
                jobInfoDao.getJobInfoByJobId(result, rp.getJobInfoId());
                JobInfoPo jobInfoPo = result.getData();
                lstJobs.add(jobInfoPo);
            }
        }

        //如果本城市没有推荐，取最新上架的数据
        if(lstJobs.size()==0){
            List<JobInfoPo> lstNewJob = getNewPushJob(result);
            lstJobs.addAll(lstNewJob);
        }else{
            //如果数据小于三，再取最新发布数据，补齐为三条
            if(lstJobs.size() < 3){
                List<JobInfoPo> lstNewJob = getNewPushJob(result);
                lstJobs.addAll(lstNewJob);
            }

        }

        return lstJobs;
    }




    /**
     * 获取最新job
     * 
     * @param result
     * @return
     */
    private List<JobInfoPo> getNewPushJob(Result result) {
        List<JobInfoPo> lstNewJob = jobInfoDao.queryHotJobInfo(result).getData();
        return lstNewJob;
    }


    /**
     * 获取实时报名用户数据
     * 
     * @param result
     * @return
     */
    public Result getRealTimeApply(Result result){
        List<ApplyJobPo> lstApplyJob =  applyJobDao.getNewApplyJobBy(result).getData();

        List<AppUserApplyJobVo> lstCustomer = new ArrayList<>();
        if(!CollectionUtils.isEmpty(lstApplyJob)){
            for(ApplyJobPo applyJob:lstApplyJob){
                setUserJobProperties(result, lstCustomer,null, applyJob);
            }
        }

        result.setData(lstCustomer);
        return result;
    }


    /**
     * 查询推荐职位数据
     * 
     * @param result
     * @param tshStauts 状态
     * @return
     */
    public Result queryHotJob(Result result,UserInfo userInfo)throws Exception{
        //根据县域ID获取城市名称
        result =  areaApi.getAreaInfo(result, userInfo.getBelongId());
        AreaInfoVO areaInfoVO = result.getData();

        //根据地址名称获取地址code
        String name = areaInfoVO.getProvince()+"|"+areaInfoVO.getCity();//+"|"+areaInfoVO.getArea();
        result = addressApi.getAddressByFullName(result, name);
        AreaVo areaVo = result.getData();

        //根据地区获取职位推荐列表
        jobRecommendDao.queryRecommondJobByArea(result, areaVo.getParentId(), areaInfoVO.getId());
        List<JobRecommendPo> listResult = result.getData();
        List<JobInfoPo> lstJobs = assemblingJob(result, listResult);

        //租转成App需要的数据格式
        List<AppJobListVo> lstAppJob = new ArrayList<>();
        for(int i = 0; i<lstJobs.size(); i++){
            if(i > 2){
                break;
            }
            JobInfoPo job = lstJobs.get(i);
            assemblingAppJobList(result, lstAppJob, job);
        }

        result.setData(lstAppJob);
        return result;
    }


    /**
     * 获取职位详情
     * 
     * @param result
     * @param cityId
     * @param categoryCids
     */
    public  Result queryJobDetail(Result result,Long jobId){
        AppJobInfoVo appJobInfoVo = new AppJobInfoVo();

        //获取职位
        JobInfoPo jobInfoPo = jobInfoDao.getJobInfoByJobId(result, jobId).getData();
        BeanUtils.copyProperties(jobInfoPo,appJobInfoVo);
        appJobInfoVo.setCompName(jobInfoPo.getCompanyPo().getName());
        publishService.setAreaName(result, jobInfoPo, appJobInfoVo);
        publishService.setCategory(result, jobInfoPo, appJobInfoVo);
        appJobInfoVo.setDeadlineTime(DateUtil.date2String(jobInfoPo.getDeadline(), StringUtils.FORMAT_STRING));

        //获取职位详情
        JobDetailPo jobDetailPo =  jobDetailDao.getJobDetailByJobId(result, jobInfoPo.getJobId()).getData();
        BeanUtils.copyProperties(jobDetailPo,appJobInfoVo);

        result.setData(appJobInfoVo);
        return result;
    }


    /**
     * 获取职位列表
     * 
     * @param result
     * @param cityId
     * @param categoryCids
     */
    public  Result queryJobList(Result result,Page<JobInfoPo> page,Long cityId,Long[] categoryCids,Order order){
        JobInfoVo jobInfoVo = new JobInfoVo();
        jobInfoVo.setTshStatus(JobConstants.JobStatus.UP);
        jobInfoVo.setCityId(cityId);
        jobInfoVo.setCategoryCIds(categoryCids);
        jobInfoDao.queryAppJobInfoList(result,page,order,jobInfoVo);

        Pagination pagination = result.getData();
        List<AppJobListVo> lstAppJob = new ArrayList<>();

        if(pagination != null && !CollectionUtils.isEmpty(pagination.getRows())){
            List<JobInfoPo> lstJobInfo = (List<JobInfoPo>) pagination.getRows();
            for(JobInfoPo po:lstJobInfo){
                assemblingAppJobList(result, lstAppJob, po);
            }
        }

        result.setData(lstAppJob);
        return result;
    }


    /**
     * 获取所有分类 级联数据
     * 
     * @param result
     * @param cityId
     * @return
     */
    public Result queryListCategory(Result result,Long cityId){
        List<CommomCategoryPo> listPDate = categoryDao.queryExitListCategoryPidByCityId(result, cityId).getData();
        List<CommomCategoryVo> lstPVo = new ArrayList<>();

        if(!CollectionUtils.isEmpty(listPDate)){
            for(CommomCategoryPo parentObject:listPDate){
                CommomCategoryVo parentVO  = new CommomCategoryVo();
                BeanUtils.copyProperties(parentObject, parentVO);
                lstPVo.add(parentVO);

                List<CommomCategoryVo> lstChildData = setCategoryChildData(result, parentObject,cityId);
                parentVO.setCjob(lstChildData);
            }
        }

        result.setData(lstPVo);
        return result;
    }


    /**
     * 获取所有有职位的城市
     * 
     * @param result
     * @return
     */
    public Result queryListCity(Result result){
        return areaDao.queryListCity(result,null);
    }


    /**
     *  根据手机号码 获取用户报名数据
     * 
     * @param result
     * @param mobilePhone 手机号码
     * @return
     */
    @SuppressWarnings("unchecked")
    public Result queryListUserApplyedJob(Result result,Page page,String mobilePhone){
        List<AppUserApplyJobVo> lstCustomer = new ArrayList<>();

        //获取到用户
        ApplyUserPo user = applyUserDao.getUserByPhone(result, mobilePhone).getData();
        if(user != null){
            //查询用户报名的信息
            Pagination pagination =  applyJobDao.getListApplyJobByUserId(result,page,user.getId()).getData();
            if(pagination != null && !CollectionUtils.isEmpty(pagination.getRows())){
                List<ApplyJobPo> lstAppJob = (List<ApplyJobPo>) pagination.getRows();
                for(ApplyJobPo applyJob:lstAppJob){
                    setUserJobProperties(result, lstCustomer,null, applyJob);
                }
            }
        }
        result.setData(lstCustomer);

        return result;
    }


    /**
     * 根据用户手机号码 获取用户信息
     * 
     * @param result
     * @param phone 手机号码
     * @return
     */
    public Result queryUserByPhone(Result result,String phone){
        return applyUserDao.getUserByPhone(result, phone);
    }




    /**
     *  设置地区
     *  
     * @param result
     * @param userInfo
     * @param applyJobPo
     * @return
     * @throws Exception
     */
    private void setAreaInfo(Result result, UserInfo userInfo, ApplyJobPo applyJobPo) throws Exception {
        //获取城市、省份名
        if(userInfo != null && userInfo.getBizId() != null){
            //设置网点信息
            applyJobPo.setShopId(userInfo.getBizId());
            applyJobPo.setShopName(userInfo.getBizName());

            //设置县域信息
            applyJobPo.setCityId(userInfo.getBelongId());
            result = areaApi.getAreaInfo(result, userInfo.getBelongId());
            AreaInfoVO areaVo = result.getData();
            applyJobPo.setCityName(areaVo.getAreaName());

            //设置省份名称
            applyJobPo.setPvName(areaVo.getProvince());
        }else{
            LOGGER.info(">>>>> 获取地区信息为空");
        }
    }



    /**
     *  设置分类子节点
     *  
     * @param result
     * @param pObject
     */
    private List<CommomCategoryVo> setCategoryChildData(Result result, CommomCategoryPo pObject,Long cityId) {
        List<CommomCategoryVo> lstChildVo = new ArrayList<>();

        List<CommomCategoryPo> listCDate = categoryDao.queryExitListCategoryCidByPid(result, Long.parseLong(pObject.getId()),cityId).getData();
        for(CommomCategoryPo childData:listCDate){
            CommomCategoryVo childObject = new CommomCategoryVo();
            BeanUtils.copyProperties(childData, childObject);
            lstChildVo.add(childObject);
        }

        return lstChildVo;
    }


    /**
     * 设置用户报名信息
     * 
     * @param result
     * @param lstCustomer
     * @param applyJob
     */
    private void setUserJobProperties(Result result, List<AppUserApplyJobVo> lstCustomer,ApplyUserPo user, ApplyJobPo applyJob) {
        AppUserApplyJobVo ujob = new AppUserApplyJobVo();
        ujob.setStatus(JobConstants.getStatusValue(applyJob.getJobStatus().intValue()));
        ujob.setApplyTime(DateUtil.date2String(applyJob.getCreateTime()));

        if(user == null){
            //获取用户信息
            user = applyUserDao.get(applyJob.getApplyUserId());
        }
        
        String userName = user.getName().substring(0, user.getName().length()-1)+"*";
        ujob.setUserName(userName);
        
        String phone = user.getPhone();
        String resultPhone= phone.substring(0,4)+"***"+phone.substring(phone.length()-4);
        ujob.setPhone(resultPhone);

        //获取职位信息
        JobInfoPo jobInfoPo = jobInfoDao.getJobInfoByJobId(result, applyJob.getJobInfoId()).getData();
        if(jobInfoPo!= null){
            ujob.setCompName(jobInfoPo.getCompanyPo().getName());
        }

        //获取职位名称信息
        CommomCategoryPo commomCategoryPo = categoryDao.getCommomCategoryById(result, jobInfoPo.getJobCategoryCid().toString()).getData();
        ujob.setCategoryName(commomCategoryPo.getName());

        lstCustomer.add(ujob);
    }


    /**
     * 修改浏览数
     * 
     * @param result
     * @param tshStauts 状态
     * @return
     */
    public Result updateJobInfoViewCounts(Result result,Long jobId)throws Exception{
        if(jobId == null){
            return result;
        }

        jobInfoDao.getJobInfoByJobId(result, jobId);
        JobInfoPo jobInfoPo = result.getData();
        //修改浏览数
        int count = (jobInfoPo.getViewCount() == null ? 0 : jobInfoPo.getViewCount().intValue());
        jobInfoDao.updateJobInfoViewCount(result, jobId, ++count);

        return result;
    }


    /**
     *  用户报名
     *  
     * @param result
     * @param userApply
     * @return
     */
    public Result userApplyJob(Result result,ApplyUserVo applyUserVo,UserInfo userInfo)throws Exception{
        ApplyUserPo userApplyPo = new ApplyUserPo();
        ApplyJobPo applyJobPo = new ApplyJobPo();

        //初始化对象数据
        if (applyUserVo != null) {
            BeanUtils.copyProperties(applyUserVo, userApplyPo);

            applyJobPo.setCreateTime(new Date());
            applyJobPo.setJobInfoId(applyUserVo.getJobInfoId());
            applyJobPo.setPushState(JobConstants.PushState.INIT); //状态位未推送
            applyJobPo.setJobStatus(StringUtils.parseLong(JobConstants.ApplyStauts.applyed)); //默认状态位已报名状态
            applyJobPo.setCode(JobUtils.getApplyJobCode());
        }

        //校验用户报名信息
        validateApplyUserInfo(result, userApplyPo, applyJobPo);


        //设置TSH的区域信息
        setAreaInfo(result, userInfo, applyJobPo);


        Long userId = userApplyPo.getId();
        //保存用户入库
        ApplyUserPo user = applyUserDao.getUserByPhone(result, userApplyPo.getPhone()).getData();
        if(user == null){
            applyUserDao.addApplyUser(result, userApplyPo);
            userId = userApplyPo.getId();
        }else{
            userApplyPo.setId(user.getId());
            applyUserDao.update(userApplyPo);
            userId = user.getId();
        }

        
        
        //保存职位信息
        applyJobPo.setApplyUserId(userId);
        applyJobDao.addApplyJob(result, applyJobPo);

        
        //修改报名数
        updateUserApplyCount(applyUserVo);

        
        
        //同步数据，同步完设置 LLD用户ID.推送状态、时间
        applyJobPo = applyJobDao.getApplyJobByUserId(result, userId, applyJobPo.getJobInfoId()).getData();
        userApplyPo = applyUserDao.getApplyUserById(result, userId).getData();
        syncJobService.reqApplyUserJob(userApplyPo, applyJobPo);

        return result;
    }




    /**
     * 修改报名数
     * 
     * @param result
     * @param applyUserVo
     */
    private void updateUserApplyCount(ApplyUserVo applyUserVo) {
        Result result = new Result(); 
        JobInfoPo jobInfoPo = jobInfoDao.getJobInfoByJobId(result, applyUserVo.getJobInfoId()).getData();
        int aplly_count = jobInfoPo.getTshApplyNumber() == null ? 0:jobInfoPo.getTshApplyNumber().intValue();
        jobInfoDao.updateUserApplyCount(result, jobInfoPo.getJobId(), aplly_count+1);
    }



    /**
     * 
     *  校验用户报名信息
     *  
     *  
     * @param result
     * @param userApplyPo
     * @param applyJobPo
     * @throws BusinessException
     */
    private void validateApplyUserInfo(Result result, ApplyUserPo userApplyPo, ApplyJobPo applyJobPo)
            throws BusinessException {
        //判断是否对同个职位已经申请过。
        applyJobDao.queryUserApplayCount(result,applyJobPo.getJobInfoId(),userApplyPo.getPhone());
        Long count = result.getData();
        if(count != null && count > 0){
            result.setErrorMsg("当前职位已经申请过了！");
            throw new BusinessException("", "当前职位已经申请过了！");
        }

        //判断当前用户是否在7天内申请的职位数
        applyJobDao.queryUserApplayByDate(result, userApplyPo.getPhone());
        Long applyCount = result.getData();

        LOGGER.info(">> mobile{},7天内申请的职位数：{}",userApplyPo.getPhone(),applyCount);

        if(applyCount != null && applyCount >= LIMIT_APPLY_COUNT){
            result.setErrorMsg("您在7日内已经报完5个名额了，请过后再来报吧。");
            throw new BusinessException("", "您在7日内已经报完5个名额了，请过后再来报吧。");
        }
    }
    

}
