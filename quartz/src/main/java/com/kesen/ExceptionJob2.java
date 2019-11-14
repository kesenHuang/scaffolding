package com.kesen;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExceptionJob2 implements Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		int i = 0;
		try{
			System.out.println(100 /i);
		} catch (Exception e) {
			System.out.println("第二种方式：修改下参数，立即重新运行");
			JobExecutionException je = new JobExecutionException(e);
			je.setRefireImmediately(true);
			throw je;
		}
	}
}
