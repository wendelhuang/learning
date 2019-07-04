package com.sklink.learning.timer.timer001;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class Timer001_TestTimer {

	/**
	 * 使用junit无法执行
	 */
	@Test
	public void test() {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				System.out.println(String.format("%s - task is running", new Date()));
			}
		};
		Timer timer = new Timer();
		timer.schedule(timerTask, 10, 3000);
	}

	public static void main(String[] args) {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				System.out.println(String.format("%s - task is running", new Date()));
			}
		};
		Timer timer = new Timer();
		timer.schedule(timerTask, 10, 3000);
	}
}
