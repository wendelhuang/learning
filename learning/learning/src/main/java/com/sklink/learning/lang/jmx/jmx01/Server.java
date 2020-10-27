package com.sklink.learning.lang.jmx.jmx01;

public class Server implements ServerMBean {
	
	private ServerConfigure serverConfigure;
	
	public Server(ServerConfigure serverConfigure) {
		super();
		this.serverConfigure = serverConfigure;
	}

	@Override
	public ServerConfigure getServerConfigure() {
		synchronized (serverConfigure) {
			return this.serverConfigure;
		}
	}

	@Override
	public void setServerConfigure(ServerConfigure serverConfigure) {
		synchronized (serverConfigure) {
			this.serverConfigure = serverConfigure;
		}
	}

	@Override
	public void defaultServerConfigure() {
		synchronized (serverConfigure) {
			serverConfigure.setPort(8080);
			serverConfigure.setHost("localhost");
			serverConfigure.setMinThread(10);
			serverConfigure.setMaxThread(66);
		}
	}

}
