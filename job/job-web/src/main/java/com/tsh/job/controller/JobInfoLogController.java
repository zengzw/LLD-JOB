package com.tsh.job.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.tsh.job.service.JobInfoLogService;
import com.tsh.job.vo.JobInfoLogVo;



@Controller
@RequestMapping("/jobInfoLog")
public class JobInfoLogController extends BaseController{
	@Autowired
	private JobInfoLogService jobInfoLogService;
	
	/**
	* 保存招工接口对象
	* @param result
	* @param jobInfoLog
	* @return
	*/
	@RequestMapping(value = "/saveJobInfoLog.do")
	@ResponseBody
	public Result saveJobInfoLog(@ModelAttribute JobInfoLogVo jobInfoLogVo)  {
		Result result = this.getResult();
		try {
			UserInfo user = result.getUserInfo();
			result = jobInfoLogService.saveJobInfoLog(result, jobInfoLogVo,user);
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		return result;
	}
	
	
	/**
	 * 根据ID查询招工接口对象的数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getJobInfoLogById.do")
	@ResponseBody
	public Result getJobInfoLogById(Long id){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		try {
			result = jobInfoLogService.getJobInfoLogById(result,id,user);
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		return result;
	}
	
	
	
	/**
	* 根据ID删除招工接口对象
	* @param id
	* @return
	*/
	@RequestMapping(value = "/delJobInfoLogById.do")
	@ResponseBody
	public Result delJobInfoLogById(Long id){
		Result result = this.getResult();
		try {
			result = jobInfoLogService.deleteJobInfoLog(result,id);
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		return result;
	}
	
	
	
	
	
	
	

}
