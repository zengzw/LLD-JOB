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
import com.tsh.job.service.JobRecommendStatisticsService;
import com.tsh.job.vo.JobRecommendStatisticsVo;




@Controller
@RequestMapping("/jobRecommendStatistics")
public class JobRecommendStatisticsController extends BaseController{
	@Autowired
	private JobRecommendStatisticsService jobRecommendStatisticsService;
	
	/**
	* 保存招工接口对象
	* @param result
	* @param jobRecommendStatistics
	* @return
	*/
	@RequestMapping(value = "/saveJobRecommendStatistics.do")
	@ResponseBody
	public Result saveJobRecommendStatistics(@ModelAttribute JobRecommendStatisticsVo jobRecommendStatisticsVo)  {
		Result result = this.getResult();
		try {
			UserInfo user = result.getUserInfo();
			result = jobRecommendStatisticsService.saveJobRecommendStatistics(result, jobRecommendStatisticsVo,user);
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
	@RequestMapping(value = "/getJobRecommendStatisticsById.do")
	@ResponseBody
	public Result getJobRecommendStatisticsById(Long id){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		try {
			result = jobRecommendStatisticsService.getJobRecommendStatisticsById(result,id,user);
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
	@RequestMapping(value = "/delJobRecommendStatisticsById.do")
	@ResponseBody
	public Result delJobRecommendStatisticsById(Long id){
		Result result = this.getResult();
		try {
			result = jobRecommendStatisticsService.deleteJobRecommendStatistics(result,id);
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
	@RequestMapping(value = "/queryJobRecommendStatisticsPage.do")
	@ResponseBody
	public Pagination queryJobRecommendStatisticsPage(int page,int rows,@ModelAttribute JobRecommendStatisticsVo jobRecommendStatisticsVo){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		Pagination pagination = null;
		try {
			Page page_num = new Page(page,rows);
			result =  jobRecommendStatisticsService.queryJobRecommendStatisticsList(result,page_num,jobRecommendStatisticsVo,user);
			pagination = (Pagination)result.getData();
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		
		return pagination;
	}
	
	
	

}
