package com.tsh.job.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Criteria;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.sun.tools.corba.se.idl.constExpr.And;

import org.hibernate.criterion.Restrictions;
import com.dtds.platform.util.bean.Pagination;
import org.springframework.stereotype.Repository;
import com.dtds.platform.data.hibernate.HibernateDao;
import com.tsh.job.po.ApplyUserPo;
import com.tsh.job.po.CompanyPo;

@Repository
@SuppressWarnings("all")
public class ApplyUserDao extends HibernateDao<ApplyUserPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
    public Result addApplyUser(Result result,ApplyUserPo applyUser)throws Exception{
        this.save(applyUser);
        result.setData(applyUser);
        return result;
    }

    /**
     * 批量新增招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
    public Result batchSaveApplyUser(Result result, List<ApplyUserPo> applyUser_list) throws Exception {
        this.batchSave(applyUser_list);
        result.setData(null);
        return result;
    }

    /**
     * 删除招工接口对象
     * @param id 招工接口对象标识
     * @return
     */
    public Result deleteApplyUser(Result result, Long id) throws Exception {
        int count = this.updateHql("delete ApplyUserPo where id=?",id);
        result.setData(count);
        return result;
    }


    /**
     * 批量删除招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
    public Result batchDelApplyUser(Result result, List<ApplyUserPo> applyUser_list)throws Exception{
        this.batchDelete(applyUser_list);
        return result;
    }


    /**
     * 批量删除招工接口对象ById
     * @param result
     * @param applyUser
     * @return
     */
    public Result batchDelApplyUserByIds(Result result,Long[] ids)throws Exception{
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
    public Result clearApplyUser(Result result) {
        String sql = " truncate table apply_user ";
        int count = this.getSession().createSQLQuery(sql).executeUpdate();
        result.setData(count);
        return result;
    }



    /**
     * 批量更新 招工接口对象
     * @param result
     * @return
     */
    public Result batchUpdateApplyUser(Result result,List<ApplyUserPo> applyUser_list) throws Exception {
        this.batchUpdate(applyUser_list);
        result.setData(null);
        return result;
    }


    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getApplyUserById(Result result,Long id) {
        ApplyUserPo applyUserPo = this.get(id);
        result.setData(applyUserPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryApplyUserList(Result result,Page page,ApplyUserPo applyUserPo){
        Criteria criteria = this.getSession().createCriteria(ApplyUserPo.class);
        if(null != applyUserPo){
            if(applyUserPo.getUserId()!=null){
                criteria.add(Restrictions.eq("userId", applyUserPo.getUserId()));
            }
            if(applyUserPo.getSex()!=null){
                criteria.add(Restrictions.eq("sex", applyUserPo.getSex()));
            }
            if(applyUserPo.getName()!=null){
                criteria.add(Restrictions.eq("name", applyUserPo.getName().trim()));
            }
            if(applyUserPo.getPhone()!=null){
                criteria.add(Restrictions.eq("phone", applyUserPo.getPhone().trim()));
            }
            if(applyUserPo.getIdCard()!=null){
                criteria.add(Restrictions.eq("idCard", applyUserPo.getIdCard()));
            }
            if(applyUserPo.getStatus()!=null){
                criteria.add(Restrictions.eq("status", applyUserPo.getStatus()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }


    /**
     * 根据 供应商Id 用户对象
     * @param result
     * @return
     */
    public Result getUserByUserId(Result result,Long userId){
        String hql = "from ApplyUserPo where userId ="+userId;
        List<ApplyUserPo> lstComps = this.find(hql, new ArrayList<>());
        if(lstComps != null && lstComps.size() > 0){
            result.setData(lstComps.get(0));
        }
        return result;
    }

    /**
     * 根据手机号码 查询 用户信息
     * @param result
     * @return
     */
    public Result getUserByPhone(Result result,String phone){
        String hql = "from ApplyUserPo where phone = ?";
        List<ApplyUserPo> lstComps = this.find(hql, phone);
        if(lstComps != null && lstComps.size() > 0){
            result.setData(lstComps.get(0));
        }
        return result;
    }

    /**
     * 根据手机号码 查询 用户信息
     * @param result
     * @return
     */
    public Result getUserByPhoneAIdCard(Result result,String phone,String idCard){
        String hql = "from ApplyUserPo where phone = ? and idCard = ?";
        List<ApplyUserPo> lstComps = this.find(hql, phone,idCard);
        if(lstComps != null && lstComps.size() > 0){
            result.setData(lstComps.get(0));
        }
        return result;
    }


    /**
     * 根据手机号码 查询 用户信息
     * @param result
     * @return
     */
    public Result test(Result result){
        String hql = "select new com.tsh.job.vo.CustomUserApplyJobVo(u.name,g.applyAddress)"
                + " from ApplyUserPo u, ApplyJobPo g where u.userId=g.applyUserId";
        List<Object> lst = new ArrayList<>();

        List lstComps = this.find(hql, lst);
        result.setData(lstComps);
        return result;
    }




}
