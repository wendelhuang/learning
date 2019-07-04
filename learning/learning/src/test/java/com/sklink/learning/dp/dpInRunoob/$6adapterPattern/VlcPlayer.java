package com.sklink.learning.dp.dpInRunoob.$6adapterPattern;

public class VlcPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println(String.format("Play vlc fileName: %s", fileName));
		
	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		
	}

}
