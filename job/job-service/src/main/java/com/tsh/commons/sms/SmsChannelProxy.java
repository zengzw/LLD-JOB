package com.tsh.commons.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsh.commons.sms.enums.SmsChannelTypeEnum;

@Service
public class SmsChannelProxy {
	@Autowired
	JianWangSmsSender jianWangSmsSender;
	@Autowired
	YunDianSmsSender yunDianSmsSender;
	@Autowired
	ZhuTongSmsSender zhuTongSmsSender;
	
	public SmsSender getSmsChannelService(int type){ 
		if (type == SmsChannelTypeEnum.zhutong.getType()) 
			return zhuTongSmsSender;
		else if (type == SmsChannelTypeEnum.yundian.getType())
			return yunDianSmsSender;
		else if (type == SmsChannelTypeEnum.jianwang.getType())
			return jianWangSmsSender;
		
		return null;
	}
	
}
