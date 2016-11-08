package com.tsh.job.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dtds.platform.data.hibernate.HibernateDao;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.job.util.StringUtils;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.po.CompanyPo;

@Repository
@SuppressWarnings("all")
public class CommomAreaDao extends HibernateDao<CommomAreaPo, String> {


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getCommomAreaById(Result result,String id){
        CommomAreaPo commomAreaPo = this.get(id);
        result.setData(commomAreaPo);
        return result;
    }

    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getListCommomAreaByPid(Result result,String pid) throws Exception{
        String hql = "from CommomAreaPo where pid = ? order by sorting asc";
        List<CommomAreaPo> lstComps = this.find(hql, pid);
        result.setData(lstComps);
        return result;
    }

    /**
     * 根据级别获取城市信息
     * 
     * 
     * @param result
     * @return
     */
    public Result getListCommomAreaByLeave(Result result,int leave) throws Exception{
        String hql = "from CommomAreaPo where grade = ? order by sorting asc";
        List<CommomAreaPo> lstComps = this.find(hql, leave);
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
    public Result queryCommomAreaList(Result result,Page page,CommomAreaPo commomAreaPo){
        Criteria criteria = this.getSession().createCriteria(CommomAreaPo.class);
        if(null != commomAreaPo){
            if(commomAreaPo.getPid()!=null){
                criteria.add(Restrictions.eq("pid", commomAreaPo.getPid()));
            }
            if(commomAreaPo.getName()!=null){
                criteria.add(Restrictions.eq("name", commomAreaPo.getName()));
            }
            if(commomAreaPo.getGrade()!=null){
                criteria.add(Restrictions.eq("grade", commomAreaPo.getGrade()));
            }
            if(commomAreaPo.getSorting()!=null){
                criteria.add(Restrictions.eq("sorting", commomAreaPo.getSorting()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }



    /**
     * 查询有数据 省份有数据的城市
     * 
     * @param result
     * @return
     */
    public Result queryListProvice(Result result){
        String sql = "select a.* from commom_area a inner join job_info b "
                + "on a.id = b.province_id and b.tsh_status=1  group by b.province_id order by a.sorting asc";
        Session session = this.getSession();
        SQLQuery sqlQuery = (SQLQuery)session.createSQLQuery(sql).addEntity(CommomAreaPo.class);
        List<CommomAreaPo> area = (List<CommomAreaPo>)sqlQuery.list();
        result.setData(area);
        return result;
    }



    /**
     * 查询 有数据的城市
     * 
     * @param result
     * @return
     */
    public Result queryListCity(Result result,Long proviceId){
        String sql = "select a.* from commom_area a inner join job_info b "
                + "on a.id = b.city_id and b.tsh_status=1 ";
        if(proviceId != null){
            sql += " and b.province_id="+proviceId;
        }
        sql += " group by b.city_id order by a.sorting asc";

        Session session = this.getSession();
        SQLQuery sqlQuery = (SQLQuery)session.createSQLQuery(sql).addEntity(CommomAreaPo.class);
        List<CommomAreaPo> area = (List<CommomAreaPo>)sqlQuery.list();
        result.setData(area);
        return result;
    }


}
