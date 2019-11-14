package com.kesen;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExceptionJob1 implements Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		int i = 0;
		try{
			System.out.println(100 /i);
		} catch (Exception e) {
			System.out.println("第一种方式：取消Job对应的所有调度");
			JobExecutionException je = new JobExecutionException(e);
			je.setUnscheduleAllTriggers(true);
			throw je;
		}
	}
}
