package com.tsh.vas.test;


import org.junit.Ignore;

import com.dtds.platform.data.redis.RedisSlave;
import com.dtds.platform.test.jetty.JettyServer;
import com.tsh.commons.HttpConstants;
import com.tsh.commons.JobConstants;

@Ignore
public class JettyTest {

	public static void main(String[] args) throws Exception {
		//便民服务
	JettyServer.start(8188);
	
	System.out.println(HttpConstants.URL.JOB_UPDATE);
	RedisSlave.getInstance().dbSize();
	}
}
