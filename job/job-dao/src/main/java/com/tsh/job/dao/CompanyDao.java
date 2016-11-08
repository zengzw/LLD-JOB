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

@Repository
@SuppressWarnings("all")
public class CompanyDao extends HibernateDao<CompanyPo, Long> {
    /**
     * 新增企业接口对象
     * @param result
     * @param company
     * @return
     */
    public Result addCompany(Result result,CompanyPo company){
        this.save(company);
        
        result.setData(company.getCompId());
        return result;
    }

    /**
     * 批量新增企业接口对象
     * @param result
     * @param company
     * @return
     */
    public Result batchSaveCompany(Result result, List<CompanyPo> company_list) throws Exception {
        this.batchSave(company_list);
        result.setData(null);
        return result;
    }

    /**
     * 删除企业接口对象
     * @param id 企业接口对象标识
     * @return
     */
    public Result deleteCompany(Result result, Long id) throws Exception {
        int count = this.updateHql("delete CompanyPo where id=?",id);
        result.setData(count);
        return result;
    }


    /**
     * 批量删除企业接口对象
     * @param result
     * @param company
     * @return
     */
    public Result batchDelCompany(Result result, List<CompanyPo> company_list)throws Exception{
        this.batchDelete(company_list);
        return result;
    }


    /**
     * 批量删除企业接口对象ById
     * @param result
     * @param company
     * @return
     */
    public Result batchDelCompanyByIds(Result result,Long[] ids)throws Exception{
        int count = 0;
        for(Long id : ids){
            this.delete(id);
            count ++;
        }
        result.setData(count);
        return result;
    }



    /**
     * 清空表 企业接口对象
     * @param result
     * @return
     */
    public Result clearCompany(Result result) {
        String sql = " truncate table company ";
        int count = this.getSession().createSQLQuery(sql).executeUpdate();
        result.setData(count);
        return result;
    }


    /**
     * 更新 企业接口对象
     * @param result
     * @return
     */
    public Result updateCompany(Result result,CompanyPo companyPo) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("update CompanyPo set ");

        if(companyPo.getName()!=null){
            hql.append("name = ").append(companyPo.getName());
        }
        if(companyPo.getCompId()!=null){
            hql.append("compId = ").append(companyPo.getCompId());
        }

        hql.append("where compId = ?");
        int count = this.updateHql(hql.toString(),companyPo.getCompId());
        result.setData(count);
        return result;
    }


    /**
     * 根据ID获取 企业接口对象
     * @param result
     * @return
     */
    public Result getCompanyById(Result result,Long id) throws Exception{
        CompanyPo companyPo = this.get(id);
        result.setData(companyPo);
        return result;
    }


    /**
     * 根据条件获取 企业接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryCompanyList(Result result,Page page,CompanyPo companyPo){
        Criteria criteria = this.getSession().createCriteria(CompanyPo.class);
        if(null != companyPo){
            if(companyPo.getName()!=null){
                criteria.add(Restrictions.eq("name", companyPo.getName()));
            }
            if(companyPo.getCompId()!=null){
                criteria.add(Restrictions.eq("compId", companyPo.getCompId()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }

    
    

    /**
     * 根据 供应商Id 查找企业对象
     * @param result
     * @return
     */
    public Result getCompanyByCompId(Result result,Long compId){
        String hql = "from CompanyPo where compId = ?";
        List<CompanyPo> lstComps = this.find(hql, compId);
        if(lstComps != null && lstComps.size() > 0){
            result.setData(lstComps.get(0));
        }
        return result;
    }

    
    
}
