package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.JobRecommendStatisticsPo;
import com.tsh.job.vo.JobRecommendStatisticsVo;
import com.tsh.job.dao.JobRecommendStatisticsDao;


@Service
@SuppressWarnings("all")
public class JobRecommendStatisticsService {
	@Autowired
	private JobRecommendStatisticsDao jobRecommendStatisticsDao;
	
	/**
	 * 新增招工接口对象
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result addJobRecommendStatistics(Result result,JobRecommendStatisticsVo jobRecommendStatisticsVo)throws Exception{
		JobRecommendStatisticsPo jobRecommendStatisticsPo = new JobRecommendStatisticsPo();
		
		if (jobRecommendStatisticsVo != null) {
																			if(jobRecommendStatisticsVo.getCode()!=null){
						jobRecommendStatisticsPo.setCode(jobRecommendStatisticsVo.getCode());
					}
																if(jobRecommendStatisticsVo.getRecommendCount()!=null){
						jobRecommendStatisticsPo.setRecommendCount(jobRecommendStatisticsVo.getRecommendCount());
					}
																if(jobRecommendStatisticsVo.getDownCount()!=null){
						jobRecommendStatisticsPo.setDownCount(jobRecommendStatisticsVo.getDownCount());
					}
									}
		
		result = jobRecommendStatisticsDao.addJobRecommendStatistics(result,jobRecommendStatisticsPo);
		return result;
	}
	
	
	
	/**
	 * 保存 招工接口对象 带User对象
	 * @param result
	 * @return
	 */
	public Result saveJobRecommendStatistics(Result result,JobRecommendStatisticsVo jobRecommendStatisticsVo,UserInfo user) throws Exception {
		if(jobRecommendStatisticsVo == null){
			result.setData("参数为空，保存失败");
			return result;
		}
		
		Long id = jobRecommendStatisticsVo.getId();
		result = jobRecommendStatisticsDao.getJobRecommendStatisticsById(result,id);
		JobRecommendStatisticsPo jobRecommendStatisticsPo  = (JobRecommendStatisticsPo)result.getData();
		
		if (jobRecommendStatisticsPo != null) {
																			if(jobRecommendStatisticsVo.getCode()!=null){
						jobRecommendStatisticsPo.setCode(jobRecommendStatisticsVo.getCode());
					}
																if(jobRecommendStatisticsVo.getRecommendCount()!=null){
						jobRecommendStatisticsPo.setRecommendCount(jobRecommendStatisticsVo.getRecommendCount());
					}
																if(jobRecommendStatisticsVo.getDownCount()!=null){
						jobRecommendStatisticsPo.setDownCount(jobRecommendStatisticsVo.getDownCount());
					}
									}else{
			jobRecommendStatisticsPo = new JobRecommendStatisticsPo();
																			if(jobRecommendStatisticsVo.getCode()!=null){
						jobRecommendStatisticsPo.setCode(jobRecommendStatisticsVo.getCode());
					}
																if(jobRecommendStatisticsVo.getRecommendCount()!=null){
						jobRecommendStatisticsPo.setRecommendCount(jobRecommendStatisticsVo.getRecommendCount());
					}
																if(jobRecommendStatisticsVo.getDownCount()!=null){
						jobRecommendStatisticsPo.setDownCount(jobRecommendStatisticsVo.getDownCount());
					}
										result = jobRecommendStatisticsDao.addJobRecommendStatistics(result,jobRecommendStatisticsPo);
		}
		return result;
	}
	
	
	
	/**
	 * 保存 招工接口对象
	 * @param result
	 * @return
	 */
	public Result saveJobRecommendStatistics(Result result,JobRecommendStatisticsVo jobRecommendStatisticsVo) throws Exception {
		if(jobRecommendStatisticsVo == null){
			result.setData("参数为空，保存失败");
			return result;
		}
		
		Long id = jobRecommendStatisticsVo.getId();
		result = jobRecommendStatisticsDao.getJobRecommendStatisticsById(result,id);
		JobRecommendStatisticsPo jobRecommendStatisticsPo  = (JobRecommendStatisticsPo)result.getData();
		
		if (jobRecommendStatisticsPo != null) {
																			if(jobRecommendStatisticsVo.getCode()!=null){
						jobRecommendStatisticsPo.setCode(jobRecommendStatisticsVo.getCode());
					}
																if(jobRecommendStatisticsVo.getRecommendCount()!=null){
						jobRecommendStatisticsPo.setRecommendCount(jobRecommendStatisticsVo.getRecommendCount());
					}
																if(jobRecommendStatisticsVo.getDownCount()!=null){
						jobRecommendStatisticsPo.setDownCount(jobRecommendStatisticsVo.getDownCount());
					}
									}else{
			jobRecommendStatisticsPo = new JobRecommendStatisticsPo();
																			if(jobRecommendStatisticsVo.getCode()!=null){
						jobRecommendStatisticsPo.setCode(jobRecommendStatisticsVo.getCode());
					}
																if(jobRecommendStatisticsVo.getRecommendCount()!=null){
						jobRecommendStatisticsPo.setRecommendCount(jobRecommendStatisticsVo.getRecommendCount());
					}
																if(jobRecommendStatisticsVo.getDownCount()!=null){
						jobRecommendStatisticsPo.setDownCount(jobRecommendStatisticsVo.getDownCount());
					}
										result = jobRecommendStatisticsDao.addJobRecommendStatistics(result,jobRecommendStatisticsPo);
		}
		return result;
	}
	
	
	/**
	 * 批量新增招工接口对象
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result batchSaveJobRecommendStatistics(Result result, List<JobRecommendStatisticsVo> jobRecommendStatistics_list) throws Exception {
		List<JobRecommendStatisticsPo> list = new ArrayList<JobRecommendStatisticsPo>();
		result = jobRecommendStatisticsDao.batchSaveJobRecommendStatistics(result,list);
		return result;
	}
	
	/**
	 * 删除招工接口对象
	 * @param id 招工接口对象标识
	 * @return
	 */
	public Result deleteJobRecommendStatistics(Result result, Long id) throws Exception {
		result = jobRecommendStatisticsDao.deleteJobRecommendStatistics(result,id);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result batchDelJobRecommendStatistics(Result result, List<JobRecommendStatisticsVo> jobRecommendStatistics_list)throws Exception{
		List<JobRecommendStatisticsPo> list = new ArrayList<JobRecommendStatisticsPo>(); 
		jobRecommendStatisticsDao.batchDelete(list);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象ByIds
	 * @param result
	 * @param jobRecommendStatistics
	 * @return
	 */
	public Result batchDelJobRecommendStatisticsByIds(Result result,Long[] ids)throws Exception{
		jobRecommendStatisticsDao.batchDelJobRecommendStatisticsByIds(result,ids);
		return result;
	}
	

	/**
	 * 根据条件获取 招工接口对象列表
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryJobRecommendStatisticsList(Result result,Page page,JobRecommendStatisticsVo jobRecommendStatisticsVo){
		JobRecommendStatisticsPo jobRecommendStatisticsPo = new JobRecommendStatisticsPo();
		result = jobRecommendStatisticsDao.queryJobRecommendStatisticsList(result,page,jobRecommendStatisticsPo);
		return result;
	}
	

	/**
	 * 根据条件获取 招工接口对象列表 带User
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryJobRecommendStatisticsList(Result result,Page page,JobRecommendStatisticsVo jobRecommendStatisticsVo,UserInfo user){
		JobRecommendStatisticsPo jobRecommendStatisticsPo = new JobRecommendStatisticsPo();
		/**
		*自行匹配需要查询的字段及值
		**/
		result = jobRecommendStatisticsDao.queryJobRecommendStatisticsList(result,page,jobRecommendStatisticsPo);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象 带User对象
	 * @param result
	 * @return
	 */
	public Result getJobRecommendStatisticsById(Result result,Long id,UserInfo user) throws Exception{
		result = jobRecommendStatisticsDao.getJobRecommendStatisticsById(result,id);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象
	 * @param result
	 * @return
	 */
	public Result getJobRecommendStatisticsById(Result result,Long id) throws Exception{
		result = jobRecommendStatisticsDao.getJobRecommendStatisticsById(result,id);
		return result;
	}
	
	
	/**
	 * 更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result updateJobRecommendStatistics(Result result,JobRecommendStatisticsVo jobRecommendStatisticsVo) throws Exception {
		Long id = jobRecommendStatisticsVo.getId();
		result = jobRecommendStatisticsDao.getJobRecommendStatisticsById(result,id);
		JobRecommendStatisticsPo jobRecommendStatisticsPo  = (JobRecommendStatisticsPo)result.getData();
		if (jobRecommendStatisticsPo != null) {
																			if(jobRecommendStatisticsVo.getCode()!=null){
						jobRecommendStatisticsPo.setCode(jobRecommendStatisticsVo.getCode());
					}
																if(jobRecommendStatisticsVo.getRecommendCount()!=null){
						jobRecommendStatisticsPo.setRecommendCount(jobRecommendStatisticsVo.getRecommendCount());
					}
																if(jobRecommendStatisticsVo.getDownCount()!=null){
						jobRecommendStatisticsPo.setDownCount(jobRecommendStatisticsVo.getDownCount());
					}
									}
		return result;
	}
	
	
	/**
	 * 批量更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result batchUpdateJobRecommendStatistics(Result result,List<JobRecommendStatisticsVo> jobRecommendStatistics_list) throws Exception {
		List<JobRecommendStatisticsPo> list = new ArrayList<JobRecommendStatisticsPo>(); 
		jobRecommendStatisticsDao.batchUpdateJobRecommendStatistics(result,list);
		return result;
	}
	
}
