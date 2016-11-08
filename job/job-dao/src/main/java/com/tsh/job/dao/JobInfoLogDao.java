package com.tsh.job.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dtds.platform.data.hibernate.HibernateDao;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.po.JobInfoLogPo;

@Repository
@SuppressWarnings("all")
public class JobInfoLogDao extends HibernateDao<JobInfoLogPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result addJobInfoLog(Result result,JobInfoLogPo jobInfoLog){
        this.save(jobInfoLog);
        return result;
    }

    /**
     * 批量新增招工接口对象
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result batchSaveJobInfoLog(Result result, List<JobInfoLogPo> jobInfoLog_list) throws Exception {
        this.batchSave(jobInfoLog_list);
        result.setData(null);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteJobInfoLog(Result result, Long id) throws Exception {
        int count = this.updateHql("delete JobInfoLogPo where id=?",id);
        result.setData(count);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result batchDelJobInfoLog(Result result, List<JobInfoLogPo> jobInfoLog_list)throws Exception{
        this.batchDelete(jobInfoLog_list);
        return result;
    }


    /**
     * 批量删除招工接口对象ById
     * @param result
     * @param jobInfoLog
     * @return
     */
    public Result batchDelJobInfoLogByIds(Result result,Long[] ids)throws Exception{
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
    public Result clearJobInfoLog(Result result) {
        String sql = " truncate table job_info_log ";
        int count = this.getSession().createSQLQuery(sql).executeUpdate();
        result.setData(count);
        return result;
    }


    /**
     * 更新 招工接口对象
     * @param result
     * @return
     */
    public Result updateJobInfoLog(Result result,JobInfoLogPo jobInfoLogPo) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("update JobInfoLogPo set ");

        if(jobInfoLogPo.getAction()!=null){
            hql.append("action = ").append(jobInfoLogPo.getAction());
        }
        if(jobInfoLogPo.getCreateId()!=null){
            hql.append("createId = ").append(jobInfoLogPo.getCreateId());
        }
        if(jobInfoLogPo.getCreateTime()!=null){
            hql.append("createTime = ").append(jobInfoLogPo.getCreateTime());
        }
        if(jobInfoLogPo.getJobInfoId()!=null){
            hql.append("jobInfoId = ").append(jobInfoLogPo.getJobInfoId());
        }

        hql.append("where id = ?");
        int count = this.updateHql(hql.toString(),jobInfoLogPo.getId());
        result.setData(count);
        return result;
    }


    /**
     * 批量更新 招工接口对象
     * @param result
     * @return
     */
    public Result batchUpdateJobInfoLog(Result result,List<JobInfoLogPo> jobInfoLog_list) throws Exception {
        this.batchUpdate(jobInfoLog_list);
        result.setData(null);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobInfoLogById(Result result,Long id) throws Exception{
        JobInfoLogPo jobInfoLogPo = this.get(id);
        result.setData(jobInfoLogPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobInfoLogList(Result result,Page page,JobInfoLogPo jobInfoLogPo){
        Criteria criteria = this.getSession().createCriteria(JobInfoLogPo.class);
        if(null != jobInfoLogPo){
            if(jobInfoLogPo.getAction()!=null){
                criteria.add(Restrictions.eq("action", jobInfoLogPo.getAction()));
            }
            if(jobInfoLogPo.getCreateId()!=null){
                criteria.add(Restrictions.eq("createId", jobInfoLogPo.getCreateId()));
            }
            if(jobInfoLogPo.getCreateTime()!=null){
                criteria.add(Restrictions.eq("createTime", jobInfoLogPo.getCreateTime()));
            }
            if(jobInfoLogPo.getJobInfoId()!=null){
                criteria.add(Restrictions.eq("jobInfoId", jobInfoLogPo.getJobInfoId()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }

}
