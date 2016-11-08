package com.tsh.job.controller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Result;
import com.tsh.job.service.CommomAreaService;
import com.tsh.job.vo.ResponseMessageVo;


@Controller
@RequestMapping("/commom/area")
public class CommomAreaController extends BaseController{
    @Autowired
    private CommomAreaService commomAreaService;



    /**
     * 获取所有的地区
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/getListArea")
    @ResponseBody
    public ResponseMessageVo queryLstArea(String pid) throws Exception{

        if(StringUtils.isEmpty(pid)){
            return getResError("pid不能为空");
        }

        Result result = this.getResult();
        commomAreaService.getListCommomAreaByPid(result, pid);
        return getResSuccess("获取成功", result.getData());
    }
    
    
    

    /**
     * 获取所有的地区
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/getListProvice")
    @ResponseBody
    public ResponseMessageVo queryListProvice() throws Exception{
        Result result = this.getResult();
        commomAreaService.queryListProvice(result);
        return getResSuccess("获取成功", result.getData());
    }
    
    /**
     * 获取所有的地区
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/getListCityByPid")
    @ResponseBody
    public ResponseMessageVo queryListCityByPid(Long provinceId) throws Exception{
        if(provinceId == null){
            return getResError("pid不能为空");
        }

        Result result = this.getResult();
        commomAreaService.queryListCity(result, provinceId);
        return getResSuccess("获取成功", result.getData());
    }
     
    
    

}
