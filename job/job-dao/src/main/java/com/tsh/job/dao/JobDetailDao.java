package com.tsh.job.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import org.hibernate.criterion.Restrictions;
import com.dtds.platform.util.bean.Pagination;
import org.springframework.stereotype.Repository;
import com.dtds.platform.data.hibernate.HibernateDao;
import com.tsh.job.po.CompanyPo;
import com.tsh.job.po.JobDetailPo;

@Repository
@SuppressWarnings("all")
public class JobDetailDao extends HibernateDao<JobDetailPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param jobDetail
     * @return
     */
    public Result addJobDetail(Result result,JobDetailPo jobDetail)throws Exception{
        this.save(jobDetail);
        return result;
    }

    /**
     * 批量新增招工接口对象
     * @param result
     * @param jobDetail
     * @return
     */
    public Result batchSaveJobDetail(Result result, List<JobDetailPo> jobDetail_list) throws Exception {
        this.batchSave(jobDetail_list);
        result.setData(null);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteJobDetail(Result result, Long id) throws Exception {
        int count = this.updateHql("delete JobDetailPo where id=?",id);
        result.setData(count);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param jobDetail
     * @return
     */
    public Result batchDelJobDetail(Result result, List<JobDetailPo> jobDetail_list)throws Exception{
        this.batchDelete(jobDetail_list);
        return result;
    }


    /**
     * 批量删除招工接口对象ById
     * @param result
     * @param jobDetail
     * @return
     */
    public Result batchDelJobDetailByIds(Result result,Long[] ids)throws Exception{
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
    public Result clearJobDetail(Result result) {
        String sql = " truncate table job_detail ";
        int count = this.getSession().createSQLQuery(sql).executeUpdate();
        result.setData(count);
        return result;
    }


    /**
     * 更新 招工接口对象
     * @param result
     * @return
     */
    public Result updateJobDetail(Result result,JobDetailPo jobDetailPo) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("update JobDetailPo set ");

        if(jobDetailPo.getJobInfoId()!=null){
            hql.append("jobInfoId = ").append(jobDetailPo.getJobInfoId());
        }
        if(jobDetailPo.getEntryAward()!=null){
            hql.append("entryAward = ").append(jobDetailPo.getEntryAward());
        }
        if(jobDetailPo.getSalaryDesc()!=null){
            hql.append("salaryDesc = ").append(jobDetailPo.getSalaryDesc());
        }
        if(jobDetailPo.getWorkContent()!=null){
            hql.append("workContent = ").append(jobDetailPo.getWorkContent());
        }
        if(jobDetailPo.getEnvironment()!=null){
            hql.append("environment = ").append(jobDetailPo.getEnvironment());
        }
        if(jobDetailPo.getRequirements()!=null){
            hql.append("requirements = ").append(jobDetailPo.getRequirements());
        }
        if(jobDetailPo.getBenefit()!=null){
            hql.append("benefit = ").append(jobDetailPo.getBenefit());
        }
        if(jobDetailPo.getIntroduction()!=null){
            hql.append("introduction = ").append(jobDetailPo.getIntroduction());
        }
        if(jobDetailPo.getImages()!=null){
            hql.append("images = ").append(jobDetailPo.getImages());
        }

        hql.append("where id = ?");
        int count = this.updateHql(hql.toString(),jobDetailPo.getId());
        result.setData(count);
        return result;
    }


    /**
     * 批量更新 招工接口对象
     * @param result
     * @return
     */
    public Result batchUpdateJobDetail(Result result,List<JobDetailPo> jobDetail_list) throws Exception {
        this.batchUpdate(jobDetail_list);
        result.setData(null);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobDetailById(Result result,Long id) throws Exception{
        JobDetailPo jobDetailPo = this.get(id);
        result.setData(jobDetailPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobDetailList(Result result,Page page,JobDetailPo jobDetailPo){
        Criteria criteria = this.getSession().createCriteria(JobDetailPo.class);
        if(null != jobDetailPo){
            if(jobDetailPo.getJobInfoId()!=null){
                criteria.add(Restrictions.eq("jobInfoId", jobDetailPo.getJobInfoId()));
            }
            if(jobDetailPo.getEntryAward()!=null){
                criteria.add(Restrictions.eq("entryAward", jobDetailPo.getEntryAward()));
            }
            if(jobDetailPo.getSalaryDesc()!=null){
                criteria.add(Restrictions.eq("salaryDesc", jobDetailPo.getSalaryDesc()));
            }
            if(jobDetailPo.getWorkContent()!=null){
                criteria.add(Restrictions.eq("workContent", jobDetailPo.getWorkContent()));
            }
            if(jobDetailPo.getEnvironment()!=null){
                criteria.add(Restrictions.eq("environment", jobDetailPo.getEnvironment()));
            }
            if(jobDetailPo.getRequirements()!=null){
                criteria.add(Restrictions.eq("requirements", jobDetailPo.getRequirements()));
            }
            if(jobDetailPo.getBenefit()!=null){
                criteria.add(Restrictions.eq("benefit", jobDetailPo.getBenefit()));
            }
            if(jobDetailPo.getIntroduction()!=null){
                criteria.add(Restrictions.eq("introduction", jobDetailPo.getIntroduction()));
            }
            if(jobDetailPo.getImages()!=null){
                criteria.add(Restrictions.eq("images", jobDetailPo.getImages()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }


    /**
     * 根据 供应商Id,Jobid 查找职位信息
     * @param result
     * @return
     */
    public Result getJobDetailByJobId(Result result,Long jobId){
        String hql = "from JobDetailPo where jobInfoId = ?";
        List<CompanyPo> lstComps = this.find(hql, jobId);
        if(lstComps != null && lstComps.size() > 0){
            result.setData(lstComps.get(0));
        }
        
        return result;
    }

    
    
}
