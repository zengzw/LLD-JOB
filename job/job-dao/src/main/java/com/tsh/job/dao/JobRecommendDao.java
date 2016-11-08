package com.tsh.job.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import org.hibernate.criterion.Restrictions;
import com.dtds.platform.util.bean.Pagination;
import org.springframework.stereotype.Repository;

import com.dtds.platform.commons.utility.DateUtil;
import com.dtds.platform.data.hibernate.HibernateDao;
import com.tsh.job.po.JobInfoPo;
import com.tsh.job.po.JobRecommendPo;
import com.tsh.job.vo.ApplyJobQueryVo;
import com.tsh.job.vo.JobRecommendVo;
import com.tsh.job.vo.RecommendQueryVo;

@Repository
@SuppressWarnings("all")
public class JobRecommendDao extends HibernateDao<JobRecommendPo, Long> {
    /**
     * 新增招工接口对象
     * @param result
     * @param jobRecommend
     * @return
     */
    public Result addJobRecommend(Result result,JobRecommendPo jobRecommend)throws Exception{
        this.save(jobRecommend);
        result.setData(jobRecommend);
        return result;
    }




    /**
     * 根据ID获取 招工接口对象
     * @param result
     * @return
     */
    public Result getJobRecommendById(Result result,Long id) throws Exception{
        JobRecommendPo jobRecommendPo = this.get(id);
        result.setData(jobRecommendPo);
        return result;
    }


    /**
     * 根据条件获取 招工接口对象列表
     * @param result
     * @param page
     * @param screenAdvertisementQuery
     * @return
     */
    public Result queryJobRecommendList(Result result,Page page,JobRecommendPo jobRecommendPo){
        Criteria criteria = this.getSession().createCriteria(JobRecommendPo.class);
        if(null != jobRecommendPo){
            if(jobRecommendPo.getJobInfoId()!=null){
                criteria.add(Restrictions.eq("jobInfoId", jobRecommendPo.getJobInfoId()));
            }
            if(jobRecommendPo.getCountry()!=null){
                criteria.add(Restrictions.eq("country", jobRecommendPo.getCountry()));
            }
            if(jobRecommendPo.getProvinceId()!=null){
                criteria.add(Restrictions.eq("provinceId", jobRecommendPo.getProvinceId()));
            }
            if(jobRecommendPo.getProvinceName()!=null){
                criteria.add(Restrictions.eq("provinceName", jobRecommendPo.getProvinceName()));
            }
            if(jobRecommendPo.getCityId()!=null){
                criteria.add(Restrictions.eq("cityId", jobRecommendPo.getCityId()));
            }
            if(jobRecommendPo.getCityName()!=null){
                criteria.add(Restrictions.eq("cityName", jobRecommendPo.getCityName()));
            }
            if(jobRecommendPo.getStatus()!=null){
                criteria.add(Restrictions.eq("status", jobRecommendPo.getStatus()));
            }
            if(jobRecommendPo.getCreateTime()!=null){
                criteria.add(Restrictions.eq("createTime", jobRecommendPo.getCreateTime()));
            }
            if(jobRecommendPo.getCreateId()!=null){
                criteria.add(Restrictions.eq("createId", jobRecommendPo.getCreateId()));
            }
            if(jobRecommendPo.getType()!=null){
                criteria.add(Restrictions.eq("type", jobRecommendPo.getType()));
            }
        }
        Pagination pagination = this.findPagination(page, criteria);
        result.setData(pagination);
        return result;
    }

    /**
     * 查询城市推荐数据
     * 
     * @param result
     * @param categoryCid 子职位分类Id
     * @return
     */
    public Result checkExistsJob(Result result,JobRecommendVo jobRecommendVo){
        String hql = "select count(*) from JobRecommendPo where status = "+jobRecommendVo.getStatus();
        if(jobRecommendVo.getJobInfoId()!=null){
            hql += " and jobInfoId="+jobRecommendVo.getJobInfoId();
        }
      
        if(jobRecommendVo.getCountry() != null){
            hql += " and country="+jobRecommendVo.getCountry();
        }
        
        if(jobRecommendVo.getProvinceId()!=null){
            hql += " and provinceId="+jobRecommendVo.getProvinceId();
        }
        
        if(jobRecommendVo.getCityId()!=null){
            hql += " and cityId="+jobRecommendVo.getCityId();
        }
       
        Session session = this.getSession();
        Long count =  ((Long)session.createQuery(hql).uniqueResult());

        result.setData(count);
        return result;
    }
    /**
     * 根据城市查询 
     * 
     * @param result
     * @param proviceId
     * @param cityId
     * @return
     */
    public Result queryRecommondJobByArea(Result result,Integer proviceId,Long cityId){
        String sql = "select *,0 as idx from job_recommend a,job_info b where a.job_info_id=b.job_id and b.tsh_status=1 and a.status=1 and  a.city_id="+cityId+" limit 0,3"+
                " UNION all  select *,1 as idx from job_recommend a,job_info b where a.job_info_id=b.job_id and b.tsh_status=1 and a.status=1 and a.province_id="+proviceId+" and a.city_id is NULL limit 0,3"+
                " UNION all select *,2 as idx from job_recommend a,job_info b where a.job_info_id=b.job_id and b.tsh_status=1 and a.status=1 and  a.country=1 order by idx asc  limit 0,3";
        Session session = this.getSession();
        List listResult = session.createSQLQuery(sql).addEntity(JobRecommendPo.class).list();
        result.setData(listResult);
        
        return result;
    }
    
    

    /**
     * 查询城市推荐数据
     * 
     * @param result
     * @param categoryCid 子职位分类Id
     * @return
     */
    public Result getRecommendCountByCityId(Result result,Long cityId){
        String hql = "select count(*) from JobRecommendPo where status =1 and cityId = "+cityId;
        Session session = this.getSession();
        Long count =  ((Long)session.createQuery(hql).uniqueResult());

        result.setData(count);
        return result;
    }
    
    
    /**
     * 查询省份的数据
     * 
     * @param result
     * @param categoryCid 子职位分类Id
     * @return
     */
    public Result getRecommendCountByProvinceId(Result result,Long provinceId){
        String hql = "select count(*) from JobRecommendPo where status =1 and provinceId = "+provinceId;
        Session session = this.getSession();
        Long count =  ((Long)session.createQuery(hql).uniqueResult());

        result.setData(count);
        return result;
    }
    
    
    
    /**
     * 查询country的推荐数据
     * 
     * @param result
     * @param categoryCid 子职位分类Id
     * @return
     */
    public Result getRecommendCountByCoutry(Result result){
        String hql = "select count(*) from JobRecommendPo where status =1 and country=1";
        Session session = this.getSession();
        Long count =  ((Long)session.createQuery(hql).uniqueResult());

        result.setData(count);
        return result;
    }
    
    
    /**
     * 查询country的推荐数据
     * 
     * @param result
     * @param categoryCid 子职位分类Id
     * @return
     */
    public Result update(Result result,Long id,Long status){
        String sql = "update job_recommend set status="+status;

       /* if(status == 1){
            sql += " , create_time=now()";
        }*/
        sql +=" where id="+id;
        
        Session session = this.getSession();
        int updateCount = session.createSQLQuery(sql).executeUpdate();

        result.setData(updateCount);
        return result;
    }

    
    /**
    * 获取推荐列表
    * 
    * @param result
    * @return
    */
   public Result queryListRecommendInfo(Result result,Page page,RecommendQueryVo q){
       String hql = "select new com.tsh.job.vo.CustomerJobRecommendListVo"
               + "(j.code,r.country,r.provinceName,r.cityName,"
               + "j.zoneId,j.jobName,j.companyPo.name,j.jobCategoryPid,"
               + "j.jobCategoryCid,j.applyNumCount,j.pushTime,j.tshStatus,j.jobId,r.id,r.status)"
               + " from  JobRecommendPo r ,JobInfoPo j where r.jobInfoId=j.jobId";
  
       if(StringUtils.isNotBlank(q.getCode())){
           hql += " and j.code like '%" +q.getCode().trim()+"%'";
       }
       
       if(q.getStatus() != null 
               && q.getStatus()!= -1){
           hql += " and j.tshStatus=" +q.getStatus();
       }
       
       if(StringUtils.isNotBlank(q.getCompName())){
           hql += " and j.companyPo.name like '%" +q.getCompName().trim()+"%'";
       }

       //职位省份查询
       if(q.getJProvince() != null
               && q.getJProvince() !=-1){
           hql += " and j.provinceId="+q.getJProvince();;
       }
       
       if(q.getJCity() != null
               
               && q.getJCity() !=-1){
           hql += " and j.cityId="+q.getJCity();
       }
       
       //职位分类查询
       if(q.getCPid() != null
               && q.getCPid() !=-1){
           hql += " and j.jobCategoryPid="+q.getCPid();
       }
       if(q.getCCid() != null
               && q.getCCid() !=-1){
           hql += " and j.jobCategoryCid="+q.getCCid();
       }
           
       
       String areaSql = "";
       //查询推荐职位地区
       if(q.getRCountry() != null
               && q.getRCountry() != -1){
           areaSql = " and r.country="+q.getRCountry();
       }
       
       if(q.getRProvince() != null
               && q.getRProvince() !=-1){
           areaSql = " and r.provinceId="+q.getRProvince() +" and r.cityId is null";
       }
       
       if(q.getRCity() != null
               && q.getRCity() !=-1){
           areaSql = " and r.cityId="+q.getRCity();
       }
       
       hql += areaSql;
       
       
       hql += " order by r.createTime desc";
       
       List<Object> lst = new ArrayList<>();
       Pagination pagination = this.findPagination(page, hql, null);
       result.setData(pagination);
       return result;
   }

}
