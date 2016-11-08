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
import com.tsh.job.po.JobRecommendStatisticsPo;

@Repository
@SuppressWarnings("all")
public class JobRecommendStatisticsDao extends HibernateDao<JobRecommendStatisticsPo, Long> {
	/**
	 * 新增招工接口对象
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result addJobRecommendStatistics(Result result,JobRecommendStatisticsPo jobRecommendStatistics)throws Exception{
		this.save(jobRecommendStatistics);
		return result;
	}
	
	/**
	 * 批量新增招工接口对象
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result batchSaveJobRecommendStatistics(Result result, List<JobRecommendStatisticsPo> jobRecommendStatistics_list) throws Exception {
		this.batchSave(jobRecommendStatistics_list);
		result.setData(null);
		return result;
	}
	
	/**
	 * 删除招工接口对象
	 * @param id 招工接口对象标识
	 * @return
	 */
	public Result deleteJobRecommendStatistics(Result result, Long id) throws Exception {
		int count = this.updateHql("delete JobRecommendStatisticsPo where id=?",id);
		result.setData(count);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result batchDelJobRecommendStatistics(Result result, List<JobRecommendStatisticsPo> jobRecommendStatistics_list)throws Exception{
		this.batchDelete(jobRecommendStatistics_list);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象ById
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result batchDelJobRecommendStatisticsByIds(Result result,Long[] ids)throws Exception{
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
	public Result clearJobRecommendStatistics(Result result) {
		String sql = " truncate table job_recommend_statistics ";
		int count = this.getSession().createSQLQuery(sql).executeUpdate();
		result.setData(count);
		return result;
	}
	

	/**
	 * 更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result updateJobRecommendStatistics(Result result,JobRecommendStatisticsPo jobRecommendStatisticsPo) throws Exception {
		StringBuffer hql = new StringBuffer();
		hql.append("update JobRecommendStatisticsPo set ");
		
													if(jobRecommendStatisticsPo.getCode()!=null){
				hql.append("code = ").append(jobRecommendStatisticsPo.getCode());
			}
											if(jobRecommendStatisticsPo.getRecommendCount()!=null){
				hql.append("recommendCount = ").append(jobRecommendStatisticsPo.getRecommendCount());
			}
											if(jobRecommendStatisticsPo.getDownCount()!=null){
				hql.append("downCount = ").append(jobRecommendStatisticsPo.getDownCount());
			}
							
		hql.append("where id = ?");
		int count = this.updateHql(hql.toString(),jobRecommendStatisticsPo.getId());
		result.setData(count);
		return result;
	}
	
	
	/**
	 * 批量更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result batchUpdateJobRecommendStatistics(Result result,List<JobRecommendStatisticsPo> jobRecommendStatistics_list) throws Exception {
		this.batchUpdate(jobRecommendStatistics_list);
		result.setData(null);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象
	 * @param result
	 * @return
	 */
	public Result getJobRecommendStatisticsById(Result result,Long id) throws Exception{
		JobRecommendStatisticsPo jobRecommendStatisticsPo = this.get(id);
		result.setData(jobRecommendStatisticsPo);
		return result;
	}
	
	
	/**
	 * 根据条件获取 招工接口对象列表
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryJobRecommendStatisticsList(Result result,Page page,JobRecommendStatisticsPo jobRecommendStatisticsPo){
		Criteria criteria = this.getSession().createCriteria(JobRecommendStatisticsPo.class);
		if(null != jobRecommendStatisticsPo){
																		if(jobRecommendStatisticsPo.getCode()!=null){
					criteria.add(Restrictions.eq("code", jobRecommendStatisticsPo.getCode()));
				}
															if(jobRecommendStatisticsPo.getRecommendCount()!=null){
					criteria.add(Restrictions.eq("recommendCount", jobRecommendStatisticsPo.getRecommendCount()));
				}
															if(jobRecommendStatisticsPo.getDownCount()!=null){
					criteria.add(Restrictions.eq("downCount", jobRecommendStatisticsPo.getDownCount()));
				}
									}
		Pagination pagination = this.findPagination(page, criteria);
		result.setData(pagination);
		return result;
	}
	
}
