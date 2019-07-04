package com.sklink.learning.dp.dpInRunoob.$6adapterPattern;

public class Mp4Player implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println(String.format("Play mp4 fileName: %s", fileName));
		
	}

}
