package com.tsh.commons.sms;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dtds.platform.data.redis.RedisSlave;
import com.dtds.platform.sms.sendconfig.SmsResult;
import com.dtds.platform.sms.smsfactory.SmsSendFactory;
import com.dtds.platform.util.bean.Result;
import com.tsh.diamond.TshDiamondClient;

@Service(value="yunDianSmsSender")
public class YunDianSmsSender implements SmsSender{

	private Logger logger = Logger.getLogger(YunDianSmsSender.class);

	@Override
	public Result sendPhoneMessage(Result result, String phone, String content)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", phone);
		map.put("content", content);
		SmsResult se = SmsSendFactory.createSms(TshDiamondClient.getInstance().getConfig("sms_yundian")).sendSms(map);
		
		if (se.isSuccess()) {
			result.setMsg("验证码发送成功");
			result.setStatus(200);
		} else {
			result.setMsg("验证码发送失败");
			result.setStatus(500);
		}
		logger.info("手机号:"+phone+",已发送内容:"+content+",发送状态:"+result.getMsg());
		return result;
	}

	@Override
	public Result checkValidateCode(Result result, String key, String code)
			throws Exception {
		String validateCode =  RedisSlave.getInstance().getString(key);
		if (StringUtils.isBlank(validateCode) || StringUtils.isBlank(key)) {
			result.setMsg("验证码验证失败");
			result.setData(false);

			result.setStatus(500);
			return result;
		}
		if (!validateCode.equals(code)) {
			result.setStatus(500);
			result.setMsg("验证码输入错误");
			result.setData(false);
			return result;
		}
		result.setMsg("验证成功");
		result.setData(true);
		result.setStatus(200);
		return result;
	}

}
