package com.tsh.job.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dtds.platform.data.hibernate.HibernateDao;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.po.JobInfoPo;
import com.tsh.job.po.JobRecommendPo;
import com.tsh.job.vo.JobInfoVo;

@Repository
@SuppressWarnings("all")
public class JobInfoDao extends HibernateDao<JobInfoPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param jobInfo
     * @return
     */
    public Result addJobInfo(Result result,JobInfoPo jobInfo)throws Exception{
        this.save(jobInfo);
        return result;
    }






    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobInfoById(Result result,Long id) throws Exception{
        JobInfoPo jobInfoPo = this.get(id);
        result.setData(jobInfoPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobInfoList(Result result,Page page,JobInfoVo jobInfoVo){
        Criteria criteria = this.getSession().createCriteria(JobInfoPo.class);
        if(null != jobInfoVo){
            if(StringUtils.isNotEmpty(jobInfoVo.getCode())){
                criteria.add(Restrictions.like("code", jobInfoVo.getCode().trim(),MatchMode.ANYWHERE));
            }

            if(StringUtils.isNotEmpty(jobInfoVo.getJobName())){
                criteria.add(Restrictions.like("jobName", jobInfoVo.getJobName().trim(),MatchMode.ANYWHERE));
            }

            if(jobInfoVo.getProvinceId()!=null
                    && jobInfoVo.getProvinceId() != -1){
                criteria.add(Restrictions.eq("provinceId", jobInfoVo.getProvinceId()));
            }

            if(jobInfoVo.getCityId()!=null
                    && jobInfoVo.getCityId() != -1){
                criteria.add(Restrictions.eq("cityId", jobInfoVo.getCityId()));
            }

            if(jobInfoVo.getZoneId()!=null
                    && jobInfoVo.getZoneId() != -1){
                criteria.add(Restrictions.eq("zoneId", jobInfoVo.getZoneId()));
            }


            if(jobInfoVo.getJobCategoryPid()!=null
                    && jobInfoVo.getJobCategoryPid() != -1){
                criteria.add(Restrictions.eq("jobCategoryPid", jobInfoVo.getJobCategoryPid()));
            }

            if(jobInfoVo.getJobCategoryCid()!=null
                    && jobInfoVo.getJobCategoryCid() != -1){
                criteria.add(Restrictions.eq("jobCategoryCid", jobInfoVo.getJobCategoryCid()));
            }

            if(jobInfoVo.getStatus()!=null
                    && jobInfoVo.getStatus() != -1 ){
                criteria.add(Restrictions.eq("status", jobInfoVo.getStatus()));
            }

            //上下架状态
            if(jobInfoVo.getTshStatus()!=null
                    && jobInfoVo.getTshStatus() != -1){
                criteria.add(Restrictions.eq("tshStatus", jobInfoVo.getTshStatus()));
            }

            //报名数 范围查询
            if(jobInfoVo.getMinApplyCount() != null
                    && jobInfoVo.getMaxApplyCount() != null){
                criteria.add(Restrictions.between("applyNumCount",jobInfoVo.getMinApplyCount(), jobInfoVo.getMaxApplyCount()));
            }

            Criteria criteriaCom = criteria.createCriteria("companyPo");
            //企业名称模糊查询
            if(StringUtils.isNotEmpty(jobInfoVo.getCompName())){
                criteriaCom.add(Restrictions.like("name", jobInfoVo.getCompName().trim(),MatchMode.ANYWHERE));
            }

            criteria.addOrder(Order.desc("pushTime"));  
        }

        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
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
        String hql = "from JobInfoPo where jobCategoryCid = ? and cityId=? and tshStatus=1 group by jobName";
        List<JobInfoPo> lstComps = this.find(hql, categoryCid,cityId);
        result.setData(lstComps);
        return result;
    }

    

    /**
     * 根据 供应商Id,Jobid 查找职位信息
     * @param result
     * @return
     */
    public Result getJobInfoByJobId(Result result,Long jobId){
        String hql = "from JobInfoPo where jobId = ?";
        List<JobInfoPo> lstComps = this.find(hql, jobId);
        if(lstComps != null && lstComps.size() > 0){
            result.setData(lstComps.get(0));
        }
        return result;
    }

    /** 更新点击量
     * 
     * @param result
     * @param jobId
     * @param count
     * @return
     */
    public Result updateJobInfoViewCount(Result result,Long jobId,int count){
        String sql = "UPDATE job_info set view_count = "+count +" where job_id = "+jobId;
        Session session = this.getSession();
        int updateCount = session.createSQLQuery(sql).executeUpdate();

        result.setData(count);
        return result;
    }
    
    
    /** 
     *  报名人数
     * @param result
     * @param jobId
     * @param count
     * @return
     */
    public Result updateUserApplyCount(Result result,Long jobId,int count){
        String sql = "UPDATE job_info set tsh_apply_number = "+count +",apply_num_count=apply_number+"+count+" where job_id = "+jobId;
        Session session = this.getSession();
        int updateCount = session.createSQLQuery(sql).executeUpdate();
        
        result.setData(count);
        return result;
        
    }

    /** 
     * 更新上下架状态
     * 
     * @param result
     * @param jobId
     * @param count
     * @return
     */
    public Result updateJobInfoTshStatus(Result result,JobInfoPo jobInfoPo){
        update(jobInfoPo);
        return result;
    }



    /**
     * App 获取首页展示
     * 
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryAppJobInfoList(Result result,Page page,Order order,JobInfoVo jobInfoVo){
        Criteria criteria = this.getSession().createCriteria(JobInfoPo.class);
        if(null != jobInfoVo){

            //城市搜索
            if(jobInfoVo.getCityId()!=null
                    && jobInfoVo.getCityId() != -1){
                criteria.add(Restrictions.eq("cityId", jobInfoVo.getCityId()));
            }

            //分类搜索
            if(jobInfoVo.getCategoryCIds()!=null && jobInfoVo.getCategoryCIds().length > 0){
                criteria.add(Restrictions.in("jobCategoryCid", jobInfoVo.getCategoryCIds()));
            }

            //上下架状态
            if(jobInfoVo.getTshStatus()!=null
                    && jobInfoVo.getTshStatus() != -1){
                criteria.add(Restrictions.eq("tshStatus", jobInfoVo.getTshStatus()));
            }

            if(order == null)
                criteria.addOrder(Order.desc("pushTime"));
            else
                criteria.addOrder(order);
        }

        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }


    /**
     *  获取最新上架前三条数据
     * @param result
     * @return
     */
    public Result queryHotJobInfo(Result result){
        String sql = "select * from job_info where tsh_status = 1  order by push_time desc limit 0,3";
        Session session = this.getSession();
        List listResult = session.createSQLQuery(sql).addEntity(JobInfoPo.class).list();
        result.setData(listResult);

        return result;
    }

}
