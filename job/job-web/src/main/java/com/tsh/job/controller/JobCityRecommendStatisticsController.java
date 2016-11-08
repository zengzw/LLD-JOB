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
import com.tsh.job.service.JobCityRecommendStatisticsService;
import com.tsh.job.vo.JobCityRecommendStatisticsVo;




@Controller
@RequestMapping("/jobCityRecommendStatistics")
public class JobCityRecommendStatisticsController extends BaseController{
	@Autowired
	private JobCityRecommendStatisticsService jobCityRecommendStatisticsService;
	
	/**
	* 保存招工接口对象
	* @param result
	* @param jobCityRecommendStatistics
	* @return
	*/
	@RequestMapping(value = "/saveJobCityRecommendStatistics.do")
	@ResponseBody
	public Result saveJobCityRecommendStatistics(@ModelAttribute JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo)  {
		Result result = this.getResult();
		try {
			UserInfo user = result.getUserInfo();
			result = jobCityRecommendStatisticsService.saveJobCityRecommendStatistics(result, jobCityRecommendStatisticsVo,user);
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
	@RequestMapping(value = "/getJobCityRecommendStatisticsById.do")
	@ResponseBody
	public Result getJobCityRecommendStatisticsById(Long id){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		try {
			result = jobCityRecommendStatisticsService.getJobCityRecommendStatisticsById(result,id,user);
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
	@RequestMapping(value = "/delJobCityRecommendStatisticsById.do")
	@ResponseBody
	public Result delJobCityRecommendStatisticsById(Long id){
		Result result = this.getResult();
		try {
			result = jobCityRecommendStatisticsService.deleteJobCityRecommendStatistics(result,id);
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
	@RequestMapping(value = "/queryJobCityRecommendStatisticsPage.do")
	@ResponseBody
	public Pagination queryJobCityRecommendStatisticsPage(int page,int rows,@ModelAttribute JobCityRecommendStatisticsVo jobCityRecommendStatisticsVo){
		Result result = this.getResult();
		UserInfo user = result.getUserInfo();
		Pagination pagination = null;
		try {
			Page page_num = new Page(page,rows);
			result =  jobCityRecommendStatisticsService.queryJobCityRecommendStatisticsList(result,page_num,jobCityRecommendStatisticsVo,user);
			pagination = (Pagination)result.getData();
		} catch (Exception e) {
			result = this.error(result, e);
		}finally {
			this.send(result);
		}
		
		return pagination;
	}
	
	
	

}
