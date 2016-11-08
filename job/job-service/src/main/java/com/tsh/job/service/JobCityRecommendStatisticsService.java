package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.JobCityRecommendStatisticsPo;
import com.tsh.job.vo.JobCityRecommendStatisticsVo;
import com.tsh.job.dao.JobCityRecommendStatisticsDao;


@Service
@SuppressWarnings("all")
public class JobCityRecommendStatisticsService {
	@Autowired
	private JobCityRecommendStatisticsDao jobCityRecommendStatisticsDao;
	
	/**
	 * 新增招工接口对象
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result addJobCityRecommendStatistics(Result result,JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo)throws Exception{
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo = new JobCityRecommendStatisticsPo();
		
		if (jobCityRecommendStatisticsVo != null) {
																			if(jobCityRecommendStatisticsVo.getRecommendCount()!=null){
						jobCityRecommendStatisticsPo.setRecommendCount(jobCityRecommendStatisticsVo.getRecommendCount());
					}
																if(jobCityRecommendStatisticsVo.getProviceId()!=null){
						jobCityRecommendStatisticsPo.setProviceId(jobCityRecommendStatisticsVo.getProviceId());
					}
																if(jobCityRecommendStatisticsVo.getProviceName()!=null){
						jobCityRecommendStatisticsPo.setProviceName(jobCityRecommendStatisticsVo.getProviceName());
					}
																if(jobCityRecommendStatisticsVo.getCityId()!=null){
						jobCityRecommendStatisticsPo.setCityId(jobCityRecommendStatisticsVo.getCityId());
					}
																if(jobCityRecommendStatisticsVo.getCityName()!=null){
						jobCityRecommendStatisticsPo.setCityName(jobCityRecommendStatisticsVo.getCityName());
					}
																if(jobCityRecommendStatisticsVo.getType()!=null){
						jobCityRecommendStatisticsPo.setType(jobCityRecommendStatisticsVo.getType());
					}
									}
		
		result = jobCityRecommendStatisticsDao.addJobCityRecommendStatistics(result,jobCityRecommendStatisticsPo);
		return result;
	}
	
	
	
	/**
	 * 保存 招工接口对象 带User对象
	 * @param result
	 * @return
	 */
	public Result saveJobCityRecommendStatistics(Result result,JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo,UserInfo user) throws Exception {
		if(jobCityRecommendStatisticsVo == null){
			result.setData("参数为空，保存失败");
			return result;
		}
		
		Long id = jobCityRecommendStatisticsVo.getId();
		result = jobCityRecommendStatisticsDao.getJobCityRecommendStatisticsById(result,id);
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo  = (JobCityRecommendStatisticsPo)result.getData();
		
		if (jobCityRecommendStatisticsPo != null) {
																			if(jobCityRecommendStatisticsVo.getRecommendCount()!=null){
						jobCityRecommendStatisticsPo.setRecommendCount(jobCityRecommendStatisticsVo.getRecommendCount());
					}
																if(jobCityRecommendStatisticsVo.getProviceId()!=null){
						jobCityRecommendStatisticsPo.setProviceId(jobCityRecommendStatisticsVo.getProviceId());
					}
																if(jobCityRecommendStatisticsVo.getProviceName()!=null){
						jobCityRecommendStatisticsPo.setProviceName(jobCityRecommendStatisticsVo.getProviceName());
					}
																if(jobCityRecommendStatisticsVo.getCityId()!=null){
						jobCityRecommendStatisticsPo.setCityId(jobCityRecommendStatisticsVo.getCityId());
					}
																if(jobCityRecommendStatisticsVo.getCityName()!=null){
						jobCityRecommendStatisticsPo.setCityName(jobCityRecommendStatisticsVo.getCityName());
					}
																if(jobCityRecommendStatisticsVo.getType()!=null){
						jobCityRecommendStatisticsPo.setType(jobCityRecommendStatisticsVo.getType());
					}
									}else{
			jobCityRecommendStatisticsPo = new JobCityRecommendStatisticsPo();
																			if(jobCityRecommendStatisticsVo.getRecommendCount()!=null){
						jobCityRecommendStatisticsPo.setRecommendCount(jobCityRecommendStatisticsVo.getRecommendCount());
					}
																if(jobCityRecommendStatisticsVo.getProviceId()!=null){
						jobCityRecommendStatisticsPo.setProviceId(jobCityRecommendStatisticsVo.getProviceId());
					}
																if(jobCityRecommendStatisticsVo.getProviceName()!=null){
						jobCityRecommendStatisticsPo.setProviceName(jobCityRecommendStatisticsVo.getProviceName());
					}
																if(jobCityRecommendStatisticsVo.getCityId()!=null){
						jobCityRecommendStatisticsPo.setCityId(jobCityRecommendStatisticsVo.getCityId());
					}
																if(jobCityRecommendStatisticsVo.getCityName()!=null){
						jobCityRecommendStatisticsPo.setCityName(jobCityRecommendStatisticsVo.getCityName());
					}
																if(jobCityRecommendStatisticsVo.getType()!=null){
						jobCityRecommendStatisticsPo.setType(jobCityRecommendStatisticsVo.getType());
					}
										result = jobCityRecommendStatisticsDao.addJobCityRecommendStatistics(result,jobCityRecommendStatisticsPo);
		}
		return result;
	}
	
	
	
	/**
	 * 保存 招工接口对象
	 * @param result
	 * @return
	 */
	public Result saveJobCityRecommendStatistics(Result result,JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo) throws Exception {
		if(jobCityRecommendStatisticsVo == null){
			result.setData("参数为空，保存失败");
			return result;
		}
		
		Long id = jobCityRecommendStatisticsVo.getId();
		result = jobCityRecommendStatisticsDao.getJobCityRecommendStatisticsById(result,id);
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo  = (JobCityRecommendStatisticsPo)result.getData();
		
		if (jobCityRecommendStatisticsPo != null) {
																			if(jobCityRecommendStatisticsVo.getRecommendCount()!=null){
						jobCityRecommendStatisticsPo.setRecommendCount(jobCityRecommendStatisticsVo.getRecommendCount());
					}
																if(jobCityRecommendStatisticsVo.getProviceId()!=null){
						jobCityRecommendStatisticsPo.setProviceId(jobCityRecommendStatisticsVo.getProviceId());
					}
																if(jobCityRecommendStatisticsVo.getProviceName()!=null){
						jobCityRecommendStatisticsPo.setProviceName(jobCityRecommendStatisticsVo.getProviceName());
					}
																if(jobCityRecommendStatisticsVo.getCityId()!=null){
						jobCityRecommendStatisticsPo.setCityId(jobCityRecommendStatisticsVo.getCityId());
					}
																if(jobCityRecommendStatisticsVo.getCityName()!=null){
						jobCityRecommendStatisticsPo.setCityName(jobCityRecommendStatisticsVo.getCityName());
					}
																if(jobCityRecommendStatisticsVo.getType()!=null){
						jobCityRecommendStatisticsPo.setType(jobCityRecommendStatisticsVo.getType());
					}
									}else{
			jobCityRecommendStatisticsPo = new JobCityRecommendStatisticsPo();
																			if(jobCityRecommendStatisticsVo.getRecommendCount()!=null){
						jobCityRecommendStatisticsPo.setRecommendCount(jobCityRecommendStatisticsVo.getRecommendCount());
					}
																if(jobCityRecommendStatisticsVo.getProviceId()!=null){
						jobCityRecommendStatisticsPo.setProviceId(jobCityRecommendStatisticsVo.getProviceId());
					}
																if(jobCityRecommendStatisticsVo.getProviceName()!=null){
						jobCityRecommendStatisticsPo.setProviceName(jobCityRecommendStatisticsVo.getProviceName());
					}
																if(jobCityRecommendStatisticsVo.getCityId()!=null){
						jobCityRecommendStatisticsPo.setCityId(jobCityRecommendStatisticsVo.getCityId());
					}
																if(jobCityRecommendStatisticsVo.getCityName()!=null){
						jobCityRecommendStatisticsPo.setCityName(jobCityRecommendStatisticsVo.getCityName());
					}
																if(jobCityRecommendStatisticsVo.getType()!=null){
						jobCityRecommendStatisticsPo.setType(jobCityRecommendStatisticsVo.getType());
					}
										result = jobCityRecommendStatisticsDao.addJobCityRecommendStatistics(result,jobCityRecommendStatisticsPo);
		}
		return result;
	}
	
	
	/**
	 * 批量新增招工接口对象
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result batchSaveJobCityRecommendStatistics(Result result, List<JobCityRecommendStatisticsVo> jobCityRecommendStatistics_list) throws Exception {
		List<JobCityRecommendStatisticsPo> list = new ArrayList<JobCityRecommendStatisticsPo>();
		result = jobCityRecommendStatisticsDao.batchSaveJobCityRecommendStatistics(result,list);
		return result;
	}
	
	/**
	 * 删除招工接口对象
	 * @param id 招工接口对象标识
	 * @return
	 */
	public Result deleteJobCityRecommendStatistics(Result result, Long id) throws Exception {
		result = jobCityRecommendStatisticsDao.deleteJobCityRecommendStatistics(result,id);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result batchDelJobCityRecommendStatistics(Result result, List<JobCityRecommendStatisticsVo> jobCityRecommendStatistics_list)throws Exception{
		List<JobCityRecommendStatisticsPo> list = new ArrayList<JobCityRecommendStatisticsPo>(); 
		jobCityRecommendStatisticsDao.batchDelete(list);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象ByIds
	 * @param result
	 * @param jobCityRecommendStatistics
	 * @return
	 */
	public Result batchDelJobCityRecommendStatisticsByIds(Result result,Long[] ids)throws Exception{
		jobCityRecommendStatisticsDao.batchDelJobCityRecommendStatisticsByIds(result,ids);
		return result;
	}
	

	/**
	 * 根据条件获取 招工接口对象列表
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryJobCityRecommendStatisticsList(Result result,Page page,JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo){
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo = new JobCityRecommendStatisticsPo();
		result = jobCityRecommendStatisticsDao.queryJobCityRecommendStatisticsList(result,page,jobCityRecommendStatisticsPo);
		return result;
	}
	

	/**
	 * 根据条件获取 招工接口对象列表 带User
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryJobCityRecommendStatisticsList(Result result,Page page,JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo,UserInfo user){
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo = new JobCityRecommendStatisticsPo();
		/**
		*自行匹配需要查询的字段及值
		**/
		result = jobCityRecommendStatisticsDao.queryJobCityRecommendStatisticsList(result,page,jobCityRecommendStatisticsPo);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象 带User对象
	 * @param result
	 * @return
	 */
	public Result getJobCityRecommendStatisticsById(Result result,Long id,UserInfo user) throws Exception{
		result = jobCityRecommendStatisticsDao.getJobCityRecommendStatisticsById(result,id);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象
	 * @param result
	 * @return
	 */
	public Result getJobCityRecommendStatisticsById(Result result,Long id) throws Exception{
		result = jobCityRecommendStatisticsDao.getJobCityRecommendStatisticsById(result,id);
		return result;
	}
	
	
	/**
	 * 更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result updateJobCityRecommendStatistics(Result result,JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo) throws Exception {
		Long id = jobCityRecommendStatisticsVo.getId();
		result = jobCityRecommendStatisticsDao.getJobCityRecommendStatisticsById(result,id);
		JobCityRecommendStatisticsPo jobCityRecommendStatisticsPo  = (JobCityRecommendStatisticsPo)result.getData();
		if (jobCityRecommendStatisticsPo != null) {
																			if(jobCityRecommendStatisticsVo.getRecommendCount()!=null){
						jobCityRecommendStatisticsPo.setRecommendCount(jobCityRecommendStatisticsVo.getRecommendCount());
					}
																if(jobCityRecommendStatisticsVo.getProviceId()!=null){
						jobCityRecommendStatisticsPo.setProviceId(jobCityRecommendStatisticsVo.getProviceId());
					}
																if(jobCityRecommendStatisticsVo.getProviceName()!=null){
						jobCityRecommendStatisticsPo.setProviceName(jobCityRecommendStatisticsVo.getProviceName());
					}
																if(jobCityRecommendStatisticsVo.getCityId()!=null){
						jobCityRecommendStatisticsPo.setCityId(jobCityRecommendStatisticsVo.getCityId());
					}
																if(jobCityRecommendStatisticsVo.getCityName()!=null){
						jobCityRecommendStatisticsPo.setCityName(jobCityRecommendStatisticsVo.getCityName());
					}
																if(jobCityRecommendStatisticsVo.getType()!=null){
						jobCityRecommendStatisticsPo.setType(jobCityRecommendStatisticsVo.getType());
					}
									}
		return result;
	}
	
	
	/**
	 * 批量更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result batchUpdateJobCityRecommendStatistics(Result result,List<JobCityRecommendStatisticsVo> jobCityRecommendStatistics_list) throws Exception {
		List<JobCityRecommendStatisticsPo> list = new ArrayList<JobCityRecommendStatisticsPo>(); 
		jobCityRecommendStatisticsDao.batchUpdateJobCityRecommendStatistics(result,list);
		return result;
	}
	
}
