package com.tsh.job.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import org.hibernate.criterion.Restrictions;
import com.dtds.platform.util.bean.Pagination;
import org.springframework.stereotype.Repository;
import com.dtds.platform.data.hibernate.HibernateDao;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.po.CommomCategoryPo;
import com.tsh.job.po.CompanyPo;

@Repository
@SuppressWarnings("all")
public class CommomCategoryDao extends HibernateDao<CommomCategoryPo, String> {


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getCommomCategoryById(Result result,String id){
        CommomCategoryPo commomCategoryPo = this.get(id);
        result.setData(commomCategoryPo);
        return result;
    }


    /**
     * 根据父Id获取职位分类Id
     * 
     * @param result
     * @return
     */
    public Result getListCommomCategoryByPid(Result result,String pid) throws Exception{
        String hql = "from CommomCategoryPo where pid = ? order by sorting asc";
        List<CommomCategoryPo> lstComps = this.find(hql, pid);
        result.setData(lstComps);
        return result;
    }
    
    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCommomCategoryList(Result result,Page page,CommomCategoryPo commomCategoryPo){
        Criteria criteria = this.getSession().createCriteria(CommomCategoryPo.class);
        if(null != commomCategoryPo){
            if(commomCategoryPo.getPid()!=null){
                criteria.add(Restrictions.eq("pid", commomCategoryPo.getPid()));
            }
            if(commomCategoryPo.getName()!=null){
                criteria.add(Restrictions.eq("name", commomCategoryPo.getName()));
            }
            if(commomCategoryPo.getGrade()!=null){
                criteria.add(Restrictions.eq("grade", commomCategoryPo.getGrade()));
            }
            if(commomCategoryPo.getSorting()!=null){
                criteria.add(Restrictions.eq("sorting", commomCategoryPo.getSorting()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }
    
    
    /**
     * 查询所有有数据的职位信息，第一级
     * 
     * @param result
     * @return
     */
    public Result queryExitListCategoryPidByCityId(Result result,Long cityId){
        String sql = "select a.* from commom_category a inner join job_info b "
                + "on a.id = b.job_category_pid and b.tsh_status=1 and b.city_id="+cityId+" group by b.job_category_pid order by a.sorting asc";
        Session session = this.getSession();
        SQLQuery sqlQuery = (SQLQuery)session.createSQLQuery(sql).addEntity(CommomCategoryPo.class);
        List<CommomCategoryPo> area = (List<CommomCategoryPo>)sqlQuery.list();
        result.setData(area);
        return result;
    }
    
    /**
     * 查询所有有数据的职位信息,第二级
     * 
     * @param result
     * @return
     */
    public Result queryExitListCategoryCidByPid(Result result,Long pid,Long cityId){
        String sql = "select a.* from commom_category a inner join job_info b "
                + "on a.id = b.job_category_cid and b.tsh_status=1 and job_category_pid="+pid+" and b.city_id="+cityId+" group by b.job_category_cid order by a.sorting asc";
        Session session = this.getSession();
        SQLQuery sqlQuery = (SQLQuery)session.createSQLQuery(sql).addEntity(CommomCategoryPo.class);
        List<CommomCategoryPo> area = (List<CommomCategoryPo>)sqlQuery.list();
        result.setData(area);
        return result;
    }


}
