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
import com.tsh.job.po.ApplyJobLogPo;

@Repository
@SuppressWarnings("all")
public class ApplyJobLogDao extends HibernateDao<ApplyJobLogPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param applyJobLog
     * @return
     */
    public Result addApplyJobLog(Result result,ApplyJobLogPo applyJobLog){
        this.save(applyJobLog);
        return result;
    }

    /**
     * 批量新增招工接口对象
     * @param result
     * @param applyJobLog
     * @return
     */
    public Result batchSaveApplyJobLog(Result result, List<ApplyJobLogPo> applyJobLog_list) throws Exception {
        this.batchSave(applyJobLog_list);
        result.setData(null);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteApplyJobLog(Result result, Long id) throws Exception {
        int count = this.updateHql("delete ApplyJobLogPo where id=?",id);
        result.setData(count);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param applyJobLog
     * @return
     */
    public Result batchDelApplyJobLog(Result result, List<ApplyJobLogPo> applyJobLog_list)throws Exception{
        this.batchDelete(applyJobLog_list);
        return result;
    }


    /**
     * 批量删除招工接口对象ById
     * @param result
     * @param applyJobLog
     * @return
     */
    public Result batchDelApplyJobLogByIds(Result result,Long[] ids)throws Exception{
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
    public Result clearApplyJobLog(Result result) {
        String sql = " truncate table apply_job_log ";
        int count = this.getSession().createSQLQuery(sql).executeUpdate();
        result.setData(count);
        return result;
    }


    /**
     * 更新 招工接口对象
     * @param result
     * @return
     */
    public Result updateApplyJobLog(Result result,ApplyJobLogPo applyJobLogPo) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("update ApplyJobLogPo set ");

        if(applyJobLogPo.getParams()!=null){
            hql.append("params = ").append(applyJobLogPo.getParams());
        }
        if(applyJobLogPo.getCreateTime()!=null){
            hql.append("createTime = ").append(applyJobLogPo.getCreateTime());
        }
        if(applyJobLogPo.getState()!=null){
            hql.append("state = ").append(applyJobLogPo.getState());
        }
        if(applyJobLogPo.getAppJobId()!=null){
            hql.append("appJobId = ").append(applyJobLogPo.getAppJobId());
        }

        hql.append("where id = ?");
        int count = this.updateHql(hql.toString(),applyJobLogPo.getId());
        result.setData(count);
        return result;
    }


    /**
     * 批量更新 招工接口对象
     * @param result
     * @return
     */
    public Result batchUpdateApplyJobLog(Result result,List<ApplyJobLogPo> applyJobLog_list) throws Exception {
        this.batchUpdate(applyJobLog_list);
        result.setData(null);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getApplyJobLogById(Result result,Long id) throws Exception{
        ApplyJobLogPo applyJobLogPo = this.get(id);
        result.setData(applyJobLogPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyJobLogList(Result result,Page page,ApplyJobLogPo applyJobLogPo){
        Criteria criteria = this.getSession().createCriteria(ApplyJobLogPo.class);
        if(null != applyJobLogPo){
            if(applyJobLogPo.getParams()!=null){
                criteria.add(Restrictions.eq("params", applyJobLogPo.getParams()));
            }
            if(applyJobLogPo.getCreateTime()!=null){
                criteria.add(Restrictions.eq("createTime", applyJobLogPo.getCreateTime()));
            }
            if(applyJobLogPo.getState()!=null){
                criteria.add(Restrictions.eq("state", applyJobLogPo.getState()));
            }
            if(applyJobLogPo.getAppJobId()!=null){
                criteria.add(Restrictions.eq("appJobId", applyJobLogPo.getAppJobId()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }

}
