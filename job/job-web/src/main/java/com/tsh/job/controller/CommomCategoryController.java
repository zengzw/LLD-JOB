package com.tsh.job.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.service.CommomCategoryService;
import com.tsh.job.vo.ResponseMessageVo;
import com.tsh.job.controller.BaseController;
import org.apache.commons.lang3.StringUtils;


@Controller
@RequestMapping("/commom/category")
public class CommomCategoryController extends BaseController{
	@Autowired
	private CommomCategoryService commomCategoryService;
	
	

    /**
     * 获取所有的地区
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/getListCategory")
    @ResponseBody
    public ResponseMessageVo queryLstArea(String pid) throws Exception{

        if(StringUtils.isEmpty(pid)){
            return getResError("pid不能为空");
        }

        Result result = this.getResult();
        commomCategoryService.getListCommomCategoryByPid(result, pid);
        return getResSuccess("获取成功", result.getData());
    }
    
    /**
     * 获取所有的地区
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/getListCategoryByCityId")
    @ResponseBody
    public ResponseMessageVo queryLstCagegoryParentByCityId(String cityId) throws Exception{
        
        if(StringUtils.isEmpty(cityId)){
            return getResError("cityId不能为空");
        }
        
        Result result = this.getResult();
        commomCategoryService.getExitListCommomCategoryByCityId(result,Long.parseLong(cityId));
        return getResSuccess("获取成功", result.getData());
    }
    
    
    /**
     * 获取所有的地区
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/getListCategoryByPid")
    @ResponseBody
    public ResponseMessageVo queryLstCategoryChilDrenByCityId(String categoryPid,String cityId) throws Exception{
        
        if(StringUtils.isEmpty(categoryPid) || StringUtils.isEmpty(cityId)){
            return getResError("categoryPid不能为空");
        }
        
        Result result = this.getResult();
        commomCategoryService.getExitListCommomCategoryByPid(result, Long.parseLong(categoryPid),Long.parseLong(cityId));
        return getResSuccess("获取成功", result.getData());
    }
    

}

