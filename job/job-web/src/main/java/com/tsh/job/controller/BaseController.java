package com.tsh.job.controller;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.oss.OSSClientUtil;
import com.dtds.platform.util.security.UserInfo;
import com.dtds.platform.web.controller.PlatformController;
import com.dtds.platform.web.userinfo.UserUtil;
import com.tsh.commons.HttpConstants;
import com.tsh.job.utils.DateEditor;
import com.tsh.job.vo.ResponseMessageVo;

@Scope("prototype")
@SuppressWarnings("all")
public class BaseController extends PlatformController{
	@Override
	public Result getResult() {
		return getResult(this.request);
	}

	public Result getResult(HttpServletRequest request) {
		UserInfo userInfo = UserUtil.getUserInfo(request);
		String teamName = "job";
		Result result = new Result(request, userInfo, teamName);
		return result;
	}


	
	/**
	 * 图片上传
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/uploadimg.do")
	@ResponseBody
	public Map<Object, Object> uploadimg(@RequestParam(value = "file", required = false) MultipartFile file) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Result result = this.getResult();
		try {
			OSSClientUtil o = new OSSClientUtil();
			if(file.isEmpty()){
				return null;
			}
			String fileName = "";
			String suffix = OSSClientUtil.getSuffix(file.getOriginalFilename());
			InputStream is=null;
			
			is = file.getInputStream();
			fileName = o.putImage(is,suffix);
			is.close();
				
			map.put("fileName", fileName);
			map.put("path", o.getFilePath(fileName));
		} catch (Exception e) {
			this.error(result, e);
		} finally{
			this.send(result);
		} 
		return map;
	}
	
	
	
	/**
	 * 获取成功结果集
	 * @param message
	 * @param data
	 * @return
	 */
	public static ResponseMessageVo getResSuccess(String message,Object data){
	    ResponseMessageVo responseMessageVo = new ResponseMessageVo();
	    responseMessageVo.setData(data==null?"":data);
	    responseMessageVo.setMsg(message);
	    responseMessageVo.setStatus(HttpConstants.RespStatus.SUCCESS);
	    
	    return responseMessageVo;
	}
	
	/**
	 * 获取成功结果集
	 * @param message
	 * @param data
	 * @return
	 */
	public static ResponseMessageVo getResSuccess(String message){
	    ResponseMessageVo responseMessageVo = new ResponseMessageVo();
	    responseMessageVo.setMsg(message);
	    responseMessageVo.setData("");
	    responseMessageVo.setStatus(HttpConstants.RespStatus.SUCCESS);
	    
	    return responseMessageVo;
	}
	
	
	/**
	 * 针对分页信息返回
	 * @param message
	 * @param data
	 * @param total
	 * @return
	 */
	public ResponseMessageVo getResPageSuccess(String message,Object data){
	    ResponseMessageVo responseMessageVo = new ResponseMessageVo();
	     responseMessageVo.setData(data==null?"":data);
	    responseMessageVo.setMsg(message);
	    responseMessageVo.setStatus(HttpConstants.RespStatus.SUCCESS);
	    
	    return responseMessageVo;
	}
	
	
	/**
	 * 获取失败结果集
	 * @param message
	 * @param data
	 * @return
	 */
	public ResponseMessageVo getResError(String message,Object data){
	    ResponseMessageVo responseMessageVo = new ResponseMessageVo();
	       responseMessageVo.setData(data==null?"":data);
	    responseMessageVo.setMsg(message);
	    responseMessageVo.setStatus(HttpConstants.RespStatus.ERROR);
	    
	    return responseMessageVo;
	}
	
	
	/**
	 * 获取失败结果集
	 * @param message
	 * @param data
	 * @return
	 */
	public ResponseMessageVo getResError(String message){
	    ResponseMessageVo responseMessageVo = new ResponseMessageVo();
	    responseMessageVo.setMsg(message);
	    responseMessageVo.setData("");
	    responseMessageVo.setStatus(HttpConstants.RespStatus.ERROR);
	    
	    return responseMessageVo;
	}


    public static  String getErrorMessage(Throwable ex) {
        if(ex == null) return "";

        Throwable next = ex;
        while (next.getCause() != null) {
            next = next.getCause();
        }

        return next.getMessage();
    }

	/**
	 * 初始化日期转换类
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
    @InitBinder  
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {  
        //对于需要转换为Date类型的属性，使用DateEditor进行处理
        binder.registerCustomEditor(Date.class, new DateEditor());  
    }
	
}
