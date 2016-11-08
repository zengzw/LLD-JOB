/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.dtds.platform.data.redis.RedisSlave;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.job.util.JobUtils;
import com.tsh.commons.sms.SmsChannelProxy;
import com.tsh.commons.sms.SmsSender;
import com.tsh.diamond.TshDiamondClient;
import com.tsh.job.po.ApplyUserPo;
import com.tsh.job.service.APPApiService;
import com.tsh.job.vo.AppOrderByVo;
import com.tsh.job.vo.AppUserApplyJobVo;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.vo.ResponseMessageVo;

/**
 * 屏端APP接口
 * 
 * @author zengzw
 * @date 2016年10月13日
 */
@Controller
@RequestMapping("/app/job")
public class APPController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(APPController.class);

    private static final String LOG_PREFIX  = ">> job-app-api#";

    @Autowired
    APPApiService apiService;




    /**
     * 短信发送
     */
    @Autowired
    SmsChannelProxy smsChannelProxy;



    /**
     * 获取短信接口
     * 
     * @return
     */
    private SmsSender getSmsSender(){
        String smsType = TshDiamondClient.getInstance().getConfig("is_sms_channel");
        if(StringUtils.isEmpty(smsType)){
            smsType = "3";
        }
        SmsSender sender = smsChannelProxy.getSmsChannelService(Integer.parseInt(smsType));

        return sender;
    }


    /**
     *  获取热梦招工职位列表
     */
    @RequestMapping(value="/hots")
    @ResponseBody()
    public ResponseMessageVo hotJobs(HttpServletRequest request){
        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }

        try {
            result = apiService.queryHotJob(result,result.getUserInfo());

        } catch (Exception e) {
            log.error("获取热门列表失败",e);

            return getResError("获取失败");
        }

        return getResSuccess("获取成功",result.getData());
    }


    /**
     *  职位详情
     */
    @RequestMapping(value="/detail")
    @ResponseBody()
    public ResponseMessageVo jobDetail(Long jobId){
        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }

        apiService.queryJobDetail(result, jobId);

        return getResSuccess("获取成功",result.getData());
    }


    /**
     *  根据城市  获取职位分类
     */
    @RequestMapping(value="/categorys",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseMessageVo listCategory(HttpServletRequest request){
        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }

        String cityId = request.getParameter("cityId");
        if(StringUtils.isBlank(cityId)){
            return this.getResError("确实参数");
        }

        apiService.queryListCategory(result, Long.parseLong(cityId));
        return getResSuccess("获取成功",result.getData());
    }





    /**
     *  获取所有有职位的城市
     */
    @RequestMapping(value="/areas",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseMessageVo listCity(HttpServletRequest request){
        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }

        apiService.queryListCity(result);

        return getResSuccess("获取成功",result.getData());
    }

    /**
     *  根据搜索条件显示 职位列表
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value="/list")
    @ResponseBody()
    public ResponseMessageVo listJob(HttpServletRequest request){
        String cityId = request.getParameter("cityId");
        String categoryIds = request.getParameter("categorys");
        String orderBy = request.getParameter("orderBy");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("rows");

        log.info("--reqeust params:rows:{},pageNo:{},cityId:{},groupName:{},categorys:{}",new Object[]{pageSize,pageNo,pageNo,orderBy,categoryIds});

        if(StringUtils.isEmpty(pageSize)|| StringUtils.isEmpty(pageNo)
                ||StringUtils.isBlank(cityId)){
            return this.getResError("确实必要参数", "");
        }

        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }

        String[] cids = categoryIds.split(",");
        Long[] categorys = com.job.util.StringUtils.stringArrayToLongArray(cids);
        Page page = new Page(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        apiService.queryJobList(result, page, Long.parseLong(cityId),categorys,getOrder(orderBy));

        return getResSuccess("获取成功",result.getData());
    }




    /**
     * 查看我的报名接口
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value="/myjob")
    @ResponseBody
    public ResponseMessageVo myJob(HttpServletRequest request){
        String mobile = request.getParameter("mobile");
        String strPageNo = request.getParameter("pageNo");
        String strRows = request.getParameter("rows");

        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }
        if(StringUtils.isEmpty(mobile)){
            return this.getResError("缺少必要参数");
        }

        log.info("--->myJob reqParams:pageNo:{},rows:{},mobile:{}",new Object[]{strPageNo,strRows,mobile}) ;

        int pageNo = StringUtils.isBlank(strPageNo)? 0 : Integer.parseInt(strPageNo);
        int row = StringUtils.isBlank(strRows)? 25 : Integer.parseInt(strRows);
        Page page = new Page(pageNo,row);
        apiService.queryListUserApplyedJob(result, page, mobile);


        List<AppUserApplyJobVo> resultData = result.getData();
        String message = CollectionUtils.isEmpty(resultData)? "没有查询到报名信息，请马上去报名吧。":"获取成功";
        return getResSuccess(message,resultData);
    }








    /**
     * 获取实时报名接口
     */
    @RequestMapping(value="/realtime",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseMessageVo realTime(HttpServletRequest request){
        Result result = this.getResult();
        ResponseMessageVo responseMessageVo = validateUserInfo(result.getUserInfo());
        if(responseMessageVo != null){
            return responseMessageVo;
        }

        apiService.getRealTimeApply(result);

        return getResSuccess("获取成功",result.getData());
    }






    /**
     * 短信验证码接口
     */
    @RequestMapping(value="/smscode",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ResponseMessageVo sendValidateCode(@RequestParam String mobile){
        if(StringUtils.isBlank(mobile)){
            return this.getResError("确实必要参数");
        }

        String code = JobUtils.generatePhoneCode(5);
        String content = "验证码为"+code+"，淘实惠客服绝不会索取此验证码，切勿泄露，5分钟内在页面中输入验证有效，详咨4000-558-518";
        Result result = new Result();
        log.info("-->smscode request:mobile:{},code:{}",mobile,code);
        
        try {
            //发送手机验证码
            getSmsSender().sendPhoneMessage(result, mobile,content);

            //成功了，根据手机号码存储验证码code
            if(result.getStatus() == 200){  
                int time = 5 * 60;
                RedisSlave.getInstance().set(mobile, code, time);
            }else{
                log.info(LOG_PREFIX+ "mobile:{}发送验证码失败",mobile);
                return this.getResError("发送失败");
            }

        } catch (Exception e) {
            log.error(LOG_PREFIX+"mobile:{}发送验证码异常。",mobile);
            log.error(LOG_PREFIX+"短信发送验证码异常。",e);

            return this.getResError("发送异常");
        }

        return getResSuccess("发送成功");
    }





    /**
     * 浏览次数修改接口
     * 
     * @param cityInfoId 信息Id
     */
    @RequestMapping(value="/update/view",method=RequestMethod.POST)
    @ResponseBody
    public ResponseMessageVo updateViewCount(@RequestParam Long jobId){
        if(jobId == null){
            return getResError("确实必要参数");
        }

        Result result = this.getResult();
        try {
            apiService.updateJobInfoViewCounts(result, jobId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getResSuccess("修改成功");
    }






    /**
     * 用户报名 
     */
    @RequestMapping(value="/user/apply",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody()
    public ResponseMessageVo userApply(HttpServletRequest request){
        Result result = this.getResult();
        String mobile = request.getParameter("mobile")
                , name = request.getParameter("name")
                , gender = request.getParameter("gender")
                , idCard = request.getParameter("idCard")
                , jobId = request.getParameter("jobId")
                , code = request.getParameter("code"); //短信验证码

        log.info(LOG_PREFIX +" mobile:{},name:{},gender:{},idCard:{},jobId:{},code:{}",
                new Object[]{mobile,name,gender,idCard,jobId,code});

        if(StringUtils.isBlank(mobile)|| StringUtils.isBlank(name)
                || StringUtils.isBlank(gender)
                || StringUtils.isBlank(jobId)
                || StringUtils.isBlank(idCard)
                || StringUtils.isBlank(code)){
            return this.getResError("缺少必要信息");
        }

        //校验用户信息
        UserInfo userInfo = result.getUserInfo();
        ResponseMessageVo responseMessageVo = validateUserInfo(userInfo);
        if(responseMessageVo != null){
            return responseMessageVo;
        }


        try {
            //短信码验证 校验
            getSmsSender().checkValidateCode(result, mobile, code);
            boolean isPass = result.getData();
            if(!isPass){
                return getResError(result.getMsg());
            }

            //保存信息
            ApplyUserVo userApplyVo = new ApplyUserVo();
            userApplyVo.setPhone(mobile);
            userApplyVo.setName(name);
            userApplyVo.setSex(Long.parseLong(gender));
            userApplyVo.setIdCard(idCard);
            userApplyVo.setJobInfoId(Long.parseLong(jobId));
            apiService.userApplyJob(result, userApplyVo, userInfo);

            //移除redis中的数据
            RedisSlave.getInstance().del(mobile);

        } catch (Exception e) {
            log.error("职位申请异常",e);
            return this.getResError(getErrorMessage(e));
        }

        return getResSuccess("报名成功");
    }






    /**
     * 验证码验证通过后，返回用户信息
     * 
     * @param mobile
     * @return
     */
    @RequestMapping(value="/smscode/validate",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseMessageVo validateCode(@RequestParam String mobile,@RequestParam String code){
        if(StringUtils.isBlank(mobile)||
                StringUtils.isBlank(code)){
            return this.getResError("确实必要参数");
        }


        Result result = new Result();
        try {
            //校验手机验证码,成功，不删除验证code。提交信息的时候会重新校验Code
            getSmsSender().checkValidateCode(result, mobile, code);
            if(result.getStatus() == 200){
                
                //获取用户的信息，根据Mobile 
                ApplyUserPo po =  apiService.queryUserByPhone(result, mobile).getData();
                ApplyUserVo vo = new ApplyUserVo();
                if(po !=null){
                    BeanUtils.copyProperties(po, vo);
                }
                
                return getResSuccess("校验成功",po == null ?"":vo);
            }else{
                log.info(LOG_PREFIX+ "mobile:{}校验失败",mobile);
                return this.getResError(result.getMsg());
            }

        } catch (Exception e) {
            log.error(LOG_PREFIX+"mobile:{}校验证码异常。",mobile);
            log.error(LOG_PREFIX+"短信校验证码异常。",e);

            return this.getResError("校验异常");
        }

    }






    /**
     * 校验用户登录信息
     * 
     * @param userInfo
     */
    private ResponseMessageVo validateUserInfo(UserInfo userInfo) {
       if(userInfo == null){
            log.info(LOG_PREFIX+" 没有找到相关用户信息！");
            return this.getResError("没有找到相关用户信息", "");
        }
        return null;
    }



    /**
     * 获取排序
     * @param orderDesc
     * @return
     */
    private Order getOrder(String orderDesc){
        String pushTime = "pushTime";
        String applyCount = "applyCount";
        String salary = "salaryMin";
        String viewCount = "viewCount";
        String desc = "1"; //降序
        Order order =  Order.desc(pushTime);
        if(StringUtils.isBlank(orderDesc)){
            return order;
        }

        AppOrderByVo orderByVo = JSON.parseObject(orderDesc,AppOrderByVo.class);
        //报名数
        if(StringUtils.isNotEmpty(orderByVo.getApplyCount())){
            if(orderByVo.getApplyCount().equals(desc)){
                return Order.desc(applyCount);
            }else{
                return Order.asc(applyCount);
            }
        }

        //上架时间
        if(StringUtils.isNotEmpty(orderByVo.getPushTime())){
            if(orderByVo.getPushTime().equals(desc)){
                return Order.desc(pushTime);
            }else{
                return Order.asc(pushTime);
            }
        }

        //浏览数
        if(StringUtils.isNotEmpty(orderByVo.getViewCount())){
            if(orderByVo.getViewCount().equals(desc)){
                return Order.desc(viewCount);
            }else{
                return Order.asc(viewCount);
            }
        }

        //起薪
        if(StringUtils.isNotEmpty(orderByVo.getSalary())){
            if(orderByVo.getSalary().equals(desc)){
                return Order.desc(salary);
            }else{
                return Order.asc(salary);
            }
        }

        return order;
    }


}
