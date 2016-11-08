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
import com.tsh.job.po.JobCityRecommendStatisticsPo;

@Repository
@SuppressWarnings("all")
public class JobCityRecommendStatisticsDao extends HibernateDao<JobCityRecommendStatisticsPo, Long> {
	/**
	 * 新增招工接口对象
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result addJobCityRecommendStatistics(Result result,JobCityRecommendStatisticsPo jobCityRecommendStatistics)throws Exception{
		this.save(jobCityRecommendStatistics);
		return result;
	}
	
	/**
	 * 批量新增招工接口对象
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result batchSaveJobCityRecommendStatistics(Result result, List<JobCityRecommendStatisticsPo> jobCityRecommendStatistics_list) throws Exception {
		this.batchSave(jobCityRecommendStatistics_list);
		result.setData(null);
		return result;
	}
	
	/**
	 * 删除招工接口对象
	 * @param id 招工接口对象标识
	 * @return
	 */
	public Result deleteJobCityRecommendStatistics(Result result, Long id) throws Exception {
		int count = this.updateHql("delete JobCityRecommendStatisticsPo where id=?",id);
		result.setData(count);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result batchDelJobCityRecommendStatistics(Result result, List<JobCityRecommendStatisticsPo> jobCityRecommendStatistics_list)throws Exception{
		this.batchDelete(jobCityRecommendStatistics_list);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象ById
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result batchDelJobCityRecommendStatisticsByIds(Result result,Long[] ids)throws Exception{
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
	public Result clearJobCityRecommendStatistics(Result result) {
		String sql = " truncate table job_city_recommend_statistics ";
		int count = this.getSession().createSQLQuery(sql).executeUpdate();
		result.setData(count);
		return result;
	}
	

	/**
	 * 更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result updateJobCityRecommendStatistics(Result result,JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo) throws Exception {
		StringBuffer hql = new StringBuffer();
		hql.append("update JobCityRecommendStatisticsPo set ");
		
													if(jobCityRecommendStatisticsPo.getRecommendCount()!=null){
				hql.append("recommendCount = ").append(jobCityRecommendStatisticsPo.getRecommendCount());
			}
											if(jobCityRecommendStatisticsPo.getProviceId()!=null){
				hql.append("proviceId = ").append(jobCityRecommendStatisticsPo.getProviceId());
			}
											if(jobCityRecommendStatisticsPo.getProviceName()!=null){
				hql.append("proviceName = ").append(jobCityRecommendStatisticsPo.getProviceName());
			}
											if(jobCityRecommendStatisticsPo.getCityId()!=null){
				hql.append("cityId = ").append(jobCityRecommendStatisticsPo.getCityId());
			}
											if(jobCityRecommendStatisticsPo.getCityName()!=null){
				hql.append("cityName = ").append(jobCityRecommendStatisticsPo.getCityName());
			}
											if(jobCityRecommendStatisticsPo.getType()!=null){
				hql.append("type = ").append(jobCityRecommendStatisticsPo.getType());
			}
							
		hql.append("where id = ?");
		int count = this.updateHql(hql.toString(),jobCityRecommendStatisticsPo.getId());
		result.setData(count);
		return result;
	}
	
	
	/**
	 * 批量更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result batchUpdateJobCityRecommendStatistics(Result result,List<JobCityRecommendStatisticsPo> jobCityRecommendStatistics_list) throws Exception {
		this.batchUpdate(jobCityRecommendStatistics_list);
		result.setData(null);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象
	 * @param result
	 * @return
	 */
	public Result getJobCityRecommendStatisticsById(Result result,Long id) throws Exception{
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo = this.get(id);
		result.setData(jobCityRecommendStatisticsPo);
		return result;
	}
	
	
	/**
	 * 根据条件获取 招工接口对象列表
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryJobCityRecommendStatisticsList(Result result,Page page,JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo){
		Criteria criteria = this.getSession().createCriteria(JobCityRecommendStatisticsPo.class);
		if(null != jobCityRecommendStatisticsPo){
																		if(jobCityRecommendStatisticsPo.getRecommendCount()!=null){
					criteria.add(Restrictions.eq("recommendCount", jobCityRecommendStatisticsPo.getRecommendCount()));
				}
															if(jobCityRecommendStatisticsPo.getProviceId()!=null){
					criteria.add(Restrictions.eq("proviceId", jobCityRecommendStatisticsPo.getProviceId()));
				}
															if(jobCityRecommendStatisticsPo.getProviceName()!=null){
					criteria.add(Restrictions.eq("proviceName", jobCityRecommendStatisticsPo.getProviceName()));
				}
															if(jobCityRecommendStatisticsPo.getCityId()!=null){
					criteria.add(Restrictions.eq("cityId", jobCityRecommendStatisticsPo.getCityId()));
				}
															if(jobCityRecommendStatisticsPo.getCityName()!=null){
					criteria.add(Restrictions.eq("cityName", jobCityRecommendStatisticsPo.getCityName()));
				}
															if(jobCityRecommendStatisticsPo.getType()!=null){
					criteria.add(Restrictions.eq("type", jobCityRecommendStatisticsPo.getType()));
				}
									}
		Pagination pagination = this.findPagination(page, criteria);
		result.setData(pagination);
		return result;
	}
	
}
