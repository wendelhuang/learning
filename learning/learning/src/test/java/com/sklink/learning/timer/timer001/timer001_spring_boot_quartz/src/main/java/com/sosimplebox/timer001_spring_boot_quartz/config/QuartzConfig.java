package com.sosimplebox.timer001_spring_boot_quartz.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sosimplebox.timer001_spring_boot_quartz.quartz.TestQuartz;

@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail testQuartzJobDetail() {
		return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
	}

	@Bean
	public Trigger testQuartzTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
				.repeatForever();

		return TriggerBuilder.newTrigger().forJob(testQuartzJobDetail()).withIdentity("testQuartzTrigger")
				.withSchedule(scheduleBuilder).build();
	}

}
