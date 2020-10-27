package com.sklink.learning.lang.jmx.jmx01;

public class ServerConfigure implements ServerConfigureMBean {
	
	private int port;
	private String host;
	private int maxThread;
	private int minThread;

	public ServerConfigure(int port, String host, int maxThread, int minThread) {
		super();
		this.port = port;
		this.host = host;
		this.maxThread = maxThread;
		this.minThread = minThread;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public int getMaxThread() {
		return maxThread;
	}

	@Override
	public void setMaxThread(int maxThread) {
		this.maxThread = maxThread;
	}

	@Override
	public int getMinThread() {
		return minThread;
	}

	@Override
	public void setMinThread(int minThread) {
		this.minThread = minThread;
	}

}
