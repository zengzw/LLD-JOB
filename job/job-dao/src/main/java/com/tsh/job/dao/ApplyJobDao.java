package com.tsh.job.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.bcel.generic.IFEQ;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dtds.platform.commons.utility.DateUtil;
import com.dtds.platform.data.hibernate.HibernateDao;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.po.ApplyJobPo;
import com.tsh.job.vo.ApplyJobQueryVo;

@Repository
@SuppressWarnings("all")
public class ApplyJobDao extends HibernateDao<ApplyJobPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param applyJob
     * @return
     */
    public Result addApplyJob(Result result,ApplyJobPo applyJob)throws Exception{
        this.save(applyJob);
        result.setData(applyJob);
        return result;
    }

    /**
     * 批量新增招工接口对象
     * @param result
     * @param applyJob
     * @return
     */
    public Result batchSaveApplyJob(Result result, List<ApplyJobPo> applyJob_list) throws Exception {
        this.batchSave(applyJob_list);
        result.setData(null);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteApplyJob(Result result, Long id) throws Exception {
        int count = this.updateHql("delete ApplyJobPo where id=?",id);
        result.setData(count);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param applyJob
     * @return
     */
    public Result batchDelApplyJob(Result result, List<ApplyJobPo> applyJob_list)throws Exception{
        this.batchDelete(applyJob_list);
        return result;
    }


    /**
     * 批量删除招工接口对象ById
     * @param result
     * @param applyJob
     * @return
     */
    public Result batchDelApplyJobByIds(Result result,Long[] ids)throws Exception{
        int count = 0;
        for(Long id : ids){
            this.delete(id);
            count ++;
        }
        result.setData(count);
        return result;
    }



    /**
     * 清空表 招工接口对象
     * @param result
     * @return
     */
    public Result clearApplyJob(Result result) {
        String sql = " truncate table apply_job ";
        int count = this.getSession().createSQLQuery(sql).executeUpdate();
        result.setData(count);
        return result;
    }




    /**
     * 批量更新 招工接口对象
     * @param result
     * @return
     */
    public Result batchUpdateApplyJob(Result result,List<ApplyJobPo> applyJob_list) throws Exception {
        this.batchUpdate(applyJob_list);
        result.setData(null);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getApplyJobById(Result result,Long id) throws Exception{
        ApplyJobPo applyJobPo = this.get(id);
        result.setData(applyJobPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyJobList(Result result,Page page,ApplyJobPo applyJobPo){
        Criteria criteria = this.getSession().createCriteria(ApplyJobPo.class);
        if(null != applyJobPo){
            if(applyJobPo.getApplyUserId()!=null){
                criteria.add(Restrictions.eq("applyUserId", applyJobPo.getApplyUserId()));
            }

            if(applyJobPo.getJobInfoId()!=null){
                criteria.add(Restrictions.eq("jobInfoId", applyJobPo.getJobInfoId()));
            }
            if(applyJobPo.getJobStatus()!=null){
                criteria.add(Restrictions.eq("jobStatus", applyJobPo.getJobStatus()));
            }
            if(applyJobPo.getApplyAddress()!=null){
                criteria.add(Restrictions.eq("applyAddress", applyJobPo.getApplyAddress()));
            }

            if(applyJobPo.getCode()!=null){
                criteria.add(Restrictions.eq("code", applyJobPo.getCode()));
            }

            if(applyJobPo.getCreateTime()!=null){
                criteria.add(Restrictions.eq("createTime", applyJobPo.getCreateTime()));
            }
            if(applyJobPo.getShopId()!=null){
                criteria.add(Restrictions.eq("shopId", applyJobPo.getShopId()));
            }
            if(applyJobPo.getShopName()!=null){
                criteria.add(Restrictions.eq("shopName", applyJobPo.getShopName()));
            }
            if(applyJobPo.getCityId()!=null){
                criteria.add(Restrictions.eq("cityId", applyJobPo.getCityId()));
            }
            if(applyJobPo.getCityName()!=null){
                criteria.add(Restrictions.eq("cityName", applyJobPo.getCityName()));
            }
            if(applyJobPo.getPvId()!=null){
                criteria.add(Restrictions.eq("pvId", applyJobPo.getPvId()));
            }
            if(applyJobPo.getPvName()!=null){
                criteria.add(Restrictions.eq("pvName", applyJobPo.getPvName()));
            }
            if(applyJobPo.getApplyTime()!=null){
                criteria.add(Restrictions.eq("applyTime", applyJobPo.getApplyTime()));
            }
            if(applyJobPo.getInterviewTime()!=null){
                criteria.add(Restrictions.eq("interviewTime", applyJobPo.getInterviewTime()));
            }
            if(applyJobPo.getEntryTime()!=null){
                criteria.add(Restrictions.eq("entryTime", applyJobPo.getEntryTime()));
            }
            if(applyJobPo.getLeaveTime()!=null){
                criteria.add(Restrictions.eq("leaveTime", applyJobPo.getLeaveTime()));
            }
            if(applyJobPo.getRemark()!=null){
                criteria.add(Restrictions.eq("remark", applyJobPo.getRemark()));
            }
            if(applyJobPo.getIsFinished()!=null){
                criteria.add(Restrictions.eq("isFinished", applyJobPo.getIsFinished()));
            }
            if(applyJobPo.getPushState()!=null){
                criteria.add(Restrictions.eq("pushState", applyJobPo.getPushState()));
            }
            if(applyJobPo.getPushTime()!=null){
                criteria.add(Restrictions.eq("pushTime", applyJobPo.getPushTime()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }


    /**
     * 根据用户ID + 职位ID 更新用户信息
     * @param result
     * @return
     */
    public Result getNoPushListApplyJob(Result result){
        String hql = "from ApplyJobPo where pushState=0 or pushState=2";
        List<ApplyJobPo> lstJobs = this.find(hql,new ArrayList<>());

        result.setData(lstJobs);
        return result;
    }


    /**
     * 根据用户ID + 职位ID 更新用户信息
     * @param result
     * @return
     */
    public Result getApplyJobByUserId(Result result,Long userId,Long jobId){
        String hql = "from ApplyJobPo where applyUserId ="+userId+" and jobInfoId="+jobId;
        List<ApplyJobPo> lstJobs = this.find(hql,new ArrayList<>());
        if(lstJobs != null && lstJobs.size() > 0){
            result.setData(lstJobs.get(0));
        }
        return result;
    }



    /**
     * 根据用户ID 查找所有报名信息
     * @param result
     * @return
     */
    public Result getListApplyJobByUserId(Result result,Page<ApplyJobPo> page,Long userId){
        String hql = "from ApplyJobPo where applyUserId = ? ";
        Pagination pagination = this.findPagination(page, hql, userId);
        result.setData(pagination);
        return result;
    }




    /**
     * 根据用户ID + 职位ID 更新用户信息
     * @param result
     * @return
     */
    public Result getNewApplyJobBy(Result result){
        String hql = "from ApplyJobPo order by createTime desc";
        Pagination pagination = this.findPagination(new Page<ApplyJobPo>(),hql, null);
        result.setData(pagination.getRows());
        return result;
    }


    /** 查询用户是否已经申请职位
     * 
     * @param result
     * @param cityInfoId
     * @param mobile
     * @return
     */
    public Result queryUserApplayCount(Result result,Long jobInfoId,String mobile){
        String hql = "select count(*) from ApplyUserPo u,ApplyJobPo j "
                + "where u.id = j.applyUserId and j.jobInfoId="+jobInfoId +" and u.phone='"+mobile+"'";
        Session session = this.getSession();
        Long count =  ((Long)session.createQuery(hql).uniqueResult());

        result.setData(count);
        return result;
    }




    /**
     * 查询用户7天内是否申请的职位数
     * 
     * @param result
     * @param mobile
     * @return
     */
    public Result queryUserApplayByDate(Result result,String mobile){
        String hql = "select count(*) from apply_user a left join apply_job  b on a.id = b.apply_user_id "
                + "where  a.phone='"+mobile+"' and  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(b.create_time);";
        Session session = this.getSession();
        Long count =  ((BigInteger)session.createSQLQuery(hql).uniqueResult()).longValue();
        result.setData(count);
        return result;
    }
    /* public CustomerApplyJobVo(String code,String name,Long sex,String phone,String idCard
            ,Date createTime,Long provinceId,Long cityId,Long zoneId,String compName,Long categoryPid
            ,Long categoryCid,Long status,Long jobId,Long userId){

     *//**
     * 获取用户报名职位信息列表
     * 
     * @param result
     * @return
     */
    public Result queryApplyUserJob(Result result,Page page,ApplyJobQueryVo q){
        String hql = "select new com.tsh.job.vo.CustomerApplyJobVo(g.code,u.name,u.sex,u.phone,u.idCard,"
                + "g.createTime,j.provinceId,j.cityId,j.zoneId,j.companyPo.name,j.jobCategoryPid,j.jobCategoryCid,"
                + "g.jobStatus,g.jobInfoId,u.id,g.pvName,g.cityName,g.shopName,j.jobName)"
                + " from  ApplyJobPo g ,ApplyUserPo u,JobInfoPo j where u.id=g.applyUserId and g.jobInfoId=j.jobId";

        if(StringUtils.isNotBlank(q.getCode())){
            hql += " and g.code like '%" +q.getCode().trim()+"%'";
        }

        if(StringUtils.isNotBlank(q.getName())){
            hql += " and u.name like '%" +q.getName().trim()+"%'";
        }
        if(StringUtils.isNotBlank(q.getPhone())){
            hql += " and u.phone like '%" +q.getPhone().trim()+"%'";
        }

        if(q.getSex() != null  && q.getSex()!=-1){
            hql += " and u.sex=" +q.getSex();
        }

        if(StringUtils.isNotBlank(q.getCompName())){
            hql += " and j.companyPo.name like '%" +q.getCompName().trim()+"%'";
        }

        if(q.getJobStatus() != null 
                && q.getJobStatus()!= -100){
            hql += " and g.jobStatus=" +q.getJobStatus();
        }

        //职位省份查询
        if(q.getProvinceId() != null&& q.getProvinceId() != -1){
            hql += " and j.provinceId="+q.getProvinceId();;
        }

        if(q.getCityId() != null
                && q.getCityId() != -1){
            hql += " and j.cityId="+q.getCityId();
        }



        //网点、县域查询
        /*  if(q.getContactProvince() != null){
            hql += " and g.pvId="+q.getContactProvince();
        }

        if(q.getContactCity() != null){
            hql += " and g.cityId="+q.getContactCity();
        }*/
        
        //县域登录，默认搜索展示当前县域的信息
        if(q.getUserBlongBizId() != null
                && q.getUserBlongBizId() !=-1 ){
            hql += " and g.cityId="+q.getUserBlongBizId();
        }
        
        //页面网点搜索
        if(q.getShopId() != null && q.getShopId() !=-1){
            hql += " and g.shopId="+q.getShopId();
        }
        
        //平台、页面县域搜索
        if(q.getContactArea() != null
                && q.getContactArea() !=-1 ){
            hql += " and g.cityId="+q.getContactArea();
        }



        if(q.getCategoryPid() != null
                && q.getCategoryPid() !=-1){
            hql += " and j.jobCategoryPid="+q.getCategoryPid();
        }

        if(q.getCategoryCid() != null
                && q.getCategoryCid() !=-1){
            hql += " and j.jobCategoryCid="+q.getCategoryCid();
        }

        if(q.getBeginCreateTime() != null && q.getEndCreateTime() != null){
            hql += " and g.createTime >='"+DateUtil.date2String(q.getBeginCreateTime())+"'";
            hql += " and  g.createTime <='"+DateUtil.date2String(q.getEndCreateTime())+"'";
        }

        hql += " order by g.createTime desc";

        List<Object> lst = new ArrayList<>();
        Pagination pagination = this.findPagination(page, hql, null);
        result.setData(pagination);
        return result;
    }



}
