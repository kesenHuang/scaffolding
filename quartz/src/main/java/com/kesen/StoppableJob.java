package com.kesen;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

public class StoppableJob implements InterruptableJob {
	private boolean stop = false;
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		while (true) {
			if (stop)
				break;
			try{
				System.out.println("每间隔一秒，检测一次，查看是否停止");
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			System.out.println("正在持续工作！");
		}
	}

	/**
	** 
	* @Description: 中断的时候会调用的代码
	* @Param: [] 
	* @return: void 
	* @Author: kesen
	* @Date: 2019/11/7 15:52 
	*/ 
	@Override
	public void interrupt() throws UnableToInterruptJobException {
		System.out.println("任务要求被中断");
		//中断flag
		stop = true;
	}
}
