package com.sklink.learning.dp.dpInRunoob.$6adapterPattern;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println(String.format("Play mp3 fileName %s", fileName));
		}else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else {
			System.out.println(String.format("Invalid media %s format not supported", audioType));
		}
	}

}
