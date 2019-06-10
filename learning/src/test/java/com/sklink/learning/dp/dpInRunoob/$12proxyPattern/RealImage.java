package com.sklink.learning.dp.dpInRunoob.$12proxyPattern;

public class RealImage implements Image {
	private String fileName;
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	@Override
	public void display() {
		System.out.println(String.format("Display %s", this.fileName));
	}
	private void loadFromDisk(String fileName) {
		System.out.println(String.format("Load %s", fileName));
	}
}
