package com.tsh.job.service;

import java.util.List;
import java.util.ArrayList;
import com.dtds.platform.util.bean.Result;
import org.springframework.stereotype.Service;
import com.dtds.platform.util.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Page;
import com.tsh.job.po.ApplyJobLogPo;
import com.tsh.job.vo.ApplyJobLogVo;
import com.tsh.job.dao.ApplyJobLogDao;


@Service
@SuppressWarnings("all")
public class ApplyJobLogService {
	@Autowired
	private ApplyJobLogDao applyJobLogDao;
	
	/**
	 * 新增招工接口对象
	 * @param result
	 * @param applyJobLog
	 * @return
	 */
	public Result addApplyJobLog(Result result,ApplyJobLogVo applyJobLogVo)throws Exception{
		ApplyJobLogPo applyJobLogPo = new ApplyJobLogPo();
		
		if (applyJobLogVo != null) {
																			if(applyJobLogVo.getParams()!=null){
						applyJobLogPo.setParams(applyJobLogVo.getParams());
					}
																if(applyJobLogVo.getCreateTime()!=null){
						applyJobLogPo.setCreateTime(applyJobLogVo.getCreateTime());
					}
																if(applyJobLogVo.getState()!=null){
						applyJobLogPo.setState(applyJobLogVo.getState());
					}
																if(applyJobLogVo.getAppJobId()!=null){
						applyJobLogPo.setAppJobId(applyJobLogVo.getAppJobId());
					}
									}
		
		result = applyJobLogDao.addApplyJobLog(result,applyJobLogPo);
		return result;
	}
	
	
	
	/**
	 * 保存 招工接口对象 带User对象
	 * @param result
	 * @return
	 */
	public Result saveApplyJobLog(Result result,ApplyJobLogVo applyJobLogVo,UserInfo user) throws Exception {
		if(applyJobLogVo == null){
			result.setData("参数为空，保存失败");
			return result;
		}
		
		Long id = applyJobLogVo.getId();
		result = applyJobLogDao.getApplyJobLogById(result,id);
		ApplyJobLogPo applyJobLogPo  = (ApplyJobLogPo)result.getData();
		
		if (applyJobLogPo != null) {
																			if(applyJobLogVo.getParams()!=null){
						applyJobLogPo.setParams(applyJobLogVo.getParams());
					}
																if(applyJobLogVo.getCreateTime()!=null){
						applyJobLogPo.setCreateTime(applyJobLogVo.getCreateTime());
					}
																if(applyJobLogVo.getState()!=null){
						applyJobLogPo.setState(applyJobLogVo.getState());
					}
																if(applyJobLogVo.getAppJobId()!=null){
						applyJobLogPo.setAppJobId(applyJobLogVo.getAppJobId());
					}
									}else{
			applyJobLogPo = new ApplyJobLogPo();
																			if(applyJobLogVo.getParams()!=null){
						applyJobLogPo.setParams(applyJobLogVo.getParams());
					}
																if(applyJobLogVo.getCreateTime()!=null){
						applyJobLogPo.setCreateTime(applyJobLogVo.getCreateTime());
					}
																if(applyJobLogVo.getState()!=null){
						applyJobLogPo.setState(applyJobLogVo.getState());
					}
																if(applyJobLogVo.getAppJobId()!=null){
						applyJobLogPo.setAppJobId(applyJobLogVo.getAppJobId());
					}
										result = applyJobLogDao.addApplyJobLog(result,applyJobLogPo);
		}
		return result;
	}
	
	
	
	/**
	 * 保存 招工接口对象
	 * @param result
	 * @return
	 */
	public Result saveApplyJobLog(Result result,ApplyJobLogVo applyJobLogVo) throws Exception {
		if(applyJobLogVo == null){
			result.setData("参数为空，保存失败");
			return result;
		}
		
		Long id = applyJobLogVo.getId();
		result = applyJobLogDao.getApplyJobLogById(result,id);
		ApplyJobLogPo applyJobLogPo  = (ApplyJobLogPo)result.getData();
		
		if (applyJobLogPo != null) {
																			if(applyJobLogVo.getParams()!=null){
						applyJobLogPo.setParams(applyJobLogVo.getParams());
					}
																if(applyJobLogVo.getCreateTime()!=null){
						applyJobLogPo.setCreateTime(applyJobLogVo.getCreateTime());
					}
																if(applyJobLogVo.getState()!=null){
						applyJobLogPo.setState(applyJobLogVo.getState());
					}
																if(applyJobLogVo.getAppJobId()!=null){
						applyJobLogPo.setAppJobId(applyJobLogVo.getAppJobId());
					}
									}else{
			applyJobLogPo = new ApplyJobLogPo();
																			if(applyJobLogVo.getParams()!=null){
						applyJobLogPo.setParams(applyJobLogVo.getParams());
					}
																if(applyJobLogVo.getCreateTime()!=null){
						applyJobLogPo.setCreateTime(applyJobLogVo.getCreateTime());
					}
																if(applyJobLogVo.getState()!=null){
						applyJobLogPo.setState(applyJobLogVo.getState());
					}
																if(applyJobLogVo.getAppJobId()!=null){
						applyJobLogPo.setAppJobId(applyJobLogVo.getAppJobId());
					}
										result = applyJobLogDao.addApplyJobLog(result,applyJobLogPo);
		}
		return result;
	}
	
	
	/**
	 * 批量新增招工接口对象
	 * @param result
	 * @param applyJobLog
	 * @return
	 */
	public Result batchSaveApplyJobLog(Result result, List<ApplyJobLogVo> applyJobLog_list) throws Exception {
		List<ApplyJobLogPo> list = new ArrayList<ApplyJobLogPo>();
		result = applyJobLogDao.batchSaveApplyJobLog(result,list);
		return result;
	}
	
	/**
	 * 删除招工接口对象
	 * @param id 招工接口对象标识
	 * @return
	 */
	public Result deleteApplyJobLog(Result result, Long id) throws Exception {
		result = applyJobLogDao.deleteApplyJobLog(result,id);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象
	 * @param result
	 * @param applyJobLog
	 * @return
	 */
	public Result batchDelApplyJobLog(Result result, List<ApplyJobLogVo> applyJobLog_list)throws Exception{
		List<ApplyJobLogPo> list = new ArrayList<ApplyJobLogPo>(); 
		applyJobLogDao.batchDelete(list);
		return result;
	}
	
	
	/**
	 * 批量删除招工接口对象ByIds
	 * @param result
	 * @param applyJobLog
	 * @return
	 */
	public Result batchDelApplyJobLogByIds(Result result,Long[] ids)throws Exception{
		applyJobLogDao.batchDelApplyJobLogByIds(result,ids);
		return result;
	}
	

	/**
	 * 根据条件获取 招工接口对象列表
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryApplyJobLogList(Result result,Page page,ApplyJobLogVo applyJobLogVo){
		ApplyJobLogPo applyJobLogPo = new ApplyJobLogPo();
		result = applyJobLogDao.queryApplyJobLogList(result,page,applyJobLogPo);
		return result;
	}
	

	/**
	 * 根据条件获取 招工接口对象列表 带User
	 * @param result
	 * @param page
	 * @param screenAdvertisementQuery
	 * @return
	 */
	public Result queryApplyJobLogList(Result result,Page page,ApplyJobLogVo applyJobLogVo,UserInfo user){
		ApplyJobLogPo applyJobLogPo = new ApplyJobLogPo();
		/**
		*自行匹配需要查询的字段及值
		**/
		result = applyJobLogDao.queryApplyJobLogList(result,page,applyJobLogPo);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象 带User对象
	 * @param result
	 * @return
	 */
	public Result getApplyJobLogById(Result result,Long id,UserInfo user) throws Exception{
		result = applyJobLogDao.getApplyJobLogById(result,id);
		return result;
	}
	
	
	/**
	 * 根据ID获取 招工接口对象
	 * @param result
	 * @return
	 */
	public Result getApplyJobLogById(Result result,Long id) throws Exception{
		result = applyJobLogDao.getApplyJobLogById(result,id);
		return result;
	}
	
	
	/**
	 * 更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result updateApplyJobLog(Result result,ApplyJobLogVo applyJobLogVo) throws Exception {
		Long id = applyJobLogVo.getId();
		result = applyJobLogDao.getApplyJobLogById(result,id);
		ApplyJobLogPo applyJobLogPo  = (ApplyJobLogPo)result.getData();
		if (applyJobLogPo != null) {
																			if(applyJobLogVo.getParams()!=null){
						applyJobLogPo.setParams(applyJobLogVo.getParams());
					}
																if(applyJobLogVo.getCreateTime()!=null){
						applyJobLogPo.setCreateTime(applyJobLogVo.getCreateTime());
					}
																if(applyJobLogVo.getState()!=null){
						applyJobLogPo.setState(applyJobLogVo.getState());
					}
																if(applyJobLogVo.getAppJobId()!=null){
						applyJobLogPo.setAppJobId(applyJobLogVo.getAppJobId());
					}
									}
		return result;
	}
	
	
	/**
	 * 批量更新 招工接口对象
	 * @param result
	 * @return
	 */
	public Result batchUpdateApplyJobLog(Result result,List<ApplyJobLogVo> applyJobLog_list) throws Exception {
		List<ApplyJobLogPo> list = new ArrayList<ApplyJobLogPo>(); 
		applyJobLogDao.batchUpdateApplyJobLog(result,list);
		return result;
	}
	
}
