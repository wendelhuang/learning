package com.sosimplebox.timer001_spring_task.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSpringTask {
	private static Logger LOGGER = LoggerFactory.getLogger(TestSpringTask.class);

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Scheduled(cron = "0/5 * * * * *")
	@Async
	public void schedule1() {
		// System.out.println("schedule1");
		LOGGER.info(String.format("%s - Thread %s cron", simpleDateFormat.format(new Date()),
				Thread.currentThread().getName()));
	}

	@Scheduled(fixedRate = 3000)
	public void schedule2() {
		// System.out.println("schedule2");
		LOGGER.info(String.format("%s - Thread %s fixedRate", simpleDateFormat.format(new Date()),
				Thread.currentThread().getName()));
	}

	@Scheduled(fixedDelay = 5000)
	public void schedule3() {
		// System.out.println("schedule3");
		LOGGER.info(String.format("%s - Thread %s fixedDelay", simpleDateFormat.format(new Date()),
				Thread.currentThread().getName()));
	}
}
