package com.tsh.job.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.tsh.job.service.ApplyJobLogService;
import com.tsh.job.vo.ApplyJobLogVo;


@Controller
@RequestMapping("/applyJobLog")
public class ApplyJobLogController extends BaseController{
	@Autowired
	private ApplyJobLogService applyJobLogService;
	
	/**
	* 保存招工接口对象
	* @param result
	* @param applyJobLog
	* @return
	*/
	@RequestMapping(value = "/saveApplyJobLog.do")
	@ResponseBody
	public Result saveApplyJobLog(@ModelAttribute ApplyJobLogVo applyJobLogVo)  {
		Result result = this.getResult();
		try {
			UserInfo user = result.getUserInfo();
			result = applyJobLogService.saveApplyJobLog(result, applyJobLogVo,user);
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
	@RequestMapping(value = "/getApplyJobLogById.do")
	@ResponseBody
	public Result getApplyJobLogById(Long id){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		try {
			result = applyJobLogService.getApplyJobLogById(result,id,user);
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
	@RequestMapping(value = "/delApplyJobLogById.do")
	@ResponseBody
	public Result delApplyJobLogById(Long id){
		Result result = this.getResult();
		try {
			result = applyJobLogService.deleteApplyJobLog(result,id);
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		return result;
	}
	
	
	
	
	/**
	 * @param pages
	 * @param rows
	 * @return 返回站内广告列表数据
	 */
	@RequestMapping(value = "/queryApplyJobLogPage.do")
	@ResponseBody
	public Pagination queryApplyJobLogPage(int page,int rows,@ModelAttribute ApplyJobLogVo applyJobLogVo){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		Pagination pagination = null;
		try {
			Page page_num = new Page(page,rows);
			result =  applyJobLogService.queryApplyJobLogList(result,page_num,applyJobLogVo,user);
			pagination = (Pagination)result.getData();
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		
		return pagination;
	}
	

}
