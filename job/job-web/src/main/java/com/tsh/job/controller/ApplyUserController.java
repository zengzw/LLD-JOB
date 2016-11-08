package com.tsh.job.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Pagination;
import com.tsh.job.service.ApplyUserService;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.controller.BaseController;
import com.dtds.platform.util.security.UserInfo;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/applyUser")
public class ApplyUserController extends BaseController{
	@Autowired
	private ApplyUserService applyUserService;
	
	/**
	* 保存招工接口对象
	* @param result
	* @param applyUser
	* @return
	*/
	@RequestMapping(value = "/saveApplyUser.do")
	@ResponseBody
	public Result saveApplyUser(@ModelAttribute ApplyUserVo applyUserVo)  {
		Result result = this.getResult();
		try {
			UserInfo user = result.getUserInfo();
			result = applyUserService.saveApplyUser(result, applyUserVo);
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
	@RequestMapping(value = "/delApplyUserById.do")
	@ResponseBody
	public Result delApplyUserById(Long id){
		Result result = this.getResult();
		try {
			result = applyUserService.deleteApplyUser(result,id);
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
	@RequestMapping(value = "/queryApplyUserPage.do")
	@ResponseBody
	public Pagination queryApplyUserPage(int page,int rows,@ModelAttribute ApplyUserVo applyUserVo){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		Pagination pagination = null;
		try {
			Page page_num = new Page(page,rows);
			result =  applyUserService.queryApplyUserList(result,page_num,applyUserVo,user);
			pagination = (Pagination)result.getData();
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		
		return pagination;
	}
	
	
	

}
