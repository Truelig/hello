package com.tuu.springboot.config;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * 定时多线程执行
 * @author JiangPengFei
 * @version $Id: mdyun-new, v 0.1 2019/3/29 10:13 JiangPengFei Exp $$
 */
@Component
public class ScheduleConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(30));
	}
}
