package com.tsh.commons.sms.enums;

public enum SmsChannelTypeEnum {
	zhutong(1),
	yundian(3),
	jianwang(2);
	
	private int type;
	
	SmsChannelTypeEnum(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
}

