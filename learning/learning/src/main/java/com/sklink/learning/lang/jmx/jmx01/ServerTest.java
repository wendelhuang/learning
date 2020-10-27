package com.sklink.learning.lang.jmx.jmx01;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class ServerTest {
	public static void main(String[] args) throws Exception {
		testServerConfigureMBean();
	}
	
	public static void testServerConfigureMBean() throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ServerConfigure serverConfigure = new ServerConfigure(8080, "localhost", 20, 100);
		
		ObjectName serverName = new ObjectName("com.sklink.learning.lang.jmx.jmx01:type=ServerConfigure");
		mbs.registerMBean(serverConfigure, serverName);
		System.out.println("Waiting...");
		Thread.sleep(Integer.MAX_VALUE);
	}
}
