package com.sklink.learning.lang.jmx.jmx01;

public interface ServerMBean {
	public ServerConfigure getServerConfigure();
	public void setServerConfigure(ServerConfigure serverConfigure);
	public void defaultServerConfigure();
}
