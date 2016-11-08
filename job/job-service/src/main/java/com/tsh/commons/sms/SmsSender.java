package com.tsh.commons.sms;

import com.dtds.platform.util.bean.Result;

/**
 * 短信发送接口
 *
 *
 */
public interface SmsSender {
	/**
	 * 发送手机短信
	 * @param result
	 * @param phone - 手机号
	 * @param content - 短信内容
	 * @return
	 * @throws Exception
	 */
	public Result sendPhoneMessage(Result result, String phone, String content) throws Exception;
	
	
	/**
	 * 验证码验证
	 * @param result
	 * @param key -- 验证key
	 * @param code -- 验证码
	 * @return
	 * @throws Exception
	 */
	public Result checkValidateCode(Result result, String key, String code) throws Exception;
}
