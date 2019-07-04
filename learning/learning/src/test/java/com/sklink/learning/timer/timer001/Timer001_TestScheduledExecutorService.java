package com.sklink.learning.timer.timer001;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Timer001_TestScheduledExecutorService {

	@Test
	public void test() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

		scheduledExecutorService.scheduleAtFixedRate(() -> {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(String.format("%s - task is running", simpleDateFormat.format(new Date())));
		}, 0, 3, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

		scheduledExecutorService.scheduleAtFixedRate(() -> {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(String.format("%s - thread %s is running", simpleDateFormat.format(new Date()),
					Thread.currentThread().getName()));
		}, 0, 3, TimeUnit.SECONDS);
	}
}
