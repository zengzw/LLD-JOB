package com.tsh.job.controller;

import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.dtds.platform.web.userinfo.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ServierController
 *
 * @author dengjd
 * @date 2016/9/6
 */
@Controller
@RequestMapping("/server")
public class ServerController extends BaseController{

    @RequestMapping(value = "/getServerInfo.do")
    @ResponseBody
    public Map<Object, Object> getServerInfo() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        Result result = this.getResult();
        UserInfo userInfo = UserUtil.getUserInfo(request);
        try {
            map.put("userInfo", userInfo);
        } catch (Exception e) {
            this.error(result, e);
        } finally{
            this.send(result);
        }

        return map;
    }


    @RequestMapping(value = "/ueditor.do")
    @ResponseBody
    public Result ueditor()  {
        return this.getResult();
    }

}
