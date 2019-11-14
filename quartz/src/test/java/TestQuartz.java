import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import  static org.quartz.CronScheduleBuilder.cronSchedule;

import com.kesen.*;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.awt.image.CropImageFilter;
import java.util.Date;

public class TestQuartz {
	@Test
	public void  testDatabase(){
		try {
			databaseCurrentJob();
		} catch (Exception e) {

		}

	}

	@Test
	public void testException1() {
		try{
			exceptionHandle1();
		} catch (Exception e) {

		}

	}

	@Test
	public void testException2() {
		try{
			exceptionHandle2();
		} catch (Exception e) {

		}

	}


	@Test
	public void testStop() {
		try{
			stop();
		} catch (Exception e) {

		}

	}

	@Test
	public void testStore() throws Exception  {
		try {
			assginNewJob();
		} catch (ObjectAlreadyExistsException e) {
			System.out.println("任务已经在数据库存在！");
			resumeJobFromDatabase();
		}
	}
	private static void exceptionHandle1() throws Exception {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(2)
						.withRepeatCount(10))
				.build();

		//定义一个JobDetail
		JobDetail job = newJob(ExceptionJob1.class)
				.withIdentity("exceptionJob1", "someJobGroup")
				.build();

		//调度加入这个job
		scheduler.scheduleJob(job, trigger);

		//启动
		scheduler.start();

		//等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}

	private static void exceptionHandle2() throws Exception {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(2)
						.withRepeatCount(10))
				.build();

		//定义一个JobDetail
		JobDetail job = newJob(ExceptionJob2.class)
				.withIdentity("exceptionJob1", "someJobGroup")
				.build();

		//调度加入这个job
		scheduler.scheduleJob(job, trigger);

		//启动
		scheduler.start();

		//等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}

	private  void databaseCurrentJob() throws Exception {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(2)
						.withRepeatCount(10))
				.build();

		//定义一个JobDetail
		JobDetail job = newJob(DatabaseBackupJob.class)
				.withIdentity("backupjob", "databasegroup")
				.usingJobData("database", "how2java")
				.build();

		//调度加入这个job
		scheduler.scheduleJob(job, trigger);

		//启动
		scheduler.start();

		//等待200秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(200000);
		scheduler.shutdown(true);
	}

	private static void jobDataMap() throws SchedulerException, InterruptedException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(2)
						.withRepeatCount(10))
				.build();

		//定义一个JobDetail
		JobDetail job = newJob(MailJob.class)
				.withIdentity("mailjob1", "mailgroup")
				.usingJobData("email", "admin@10086.com")
				.build();

		//用JobDataMap 修改email
		job.getJobDataMap().put("email", "admin@taobao.com");

		//调度加入这个job
		scheduler.scheduleJob(job, trigger);

		//启动
		scheduler.start();

		//等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}

	private static void stop() throws Exception {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow()
				.build();

		//定义一个JobDetail
		JobDetail job = newJob(StoppableJob.class)
				.withIdentity("exceptionJob1", "someJobGroup")
				.build();

		//调度加入这个job
		scheduler.scheduleJob(job, trigger);

		//启动
		scheduler.start();

		Thread.sleep(5000);
		System.out.println("过5秒，调度停止 job");

		//key 就相当于这个Job的主键
		scheduler.interrupt(job.getKey());

		//等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}

	private  static void cronQuartz() throws Exception {
		Scheduler scheduler =  StdSchedulerFactory.getDefaultScheduler();
		JobDetail job =  newJob().withIdentity("mailJob", "mailGroup").build();
		CronTrigger trigger = newTrigger().withIdentity("trigger1","group1").withSchedule(cronSchedule("0/2 * * * * ?")).build();

		Date ft = scheduler.scheduleJob(job, trigger);

		scheduler.start();

		Thread.sleep(200000);
		scheduler.shutdown();
	}


	private static void resumeJobFromDatabase() throws Exception {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		// 等待200秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(200000);
		scheduler.shutdown(true);
	}

	private static void assginNewJob() throws SchedulerException, InterruptedException {
		// 创建调度器
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 定义一个触发器
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1") // 定义名称和所属的租
				.startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(15) // 每隔15秒执行一次
						.withRepeatCount(10)) // 总共执行11次(第一次执行不基数)
				.build();

		// 定义一个JobDetail
		JobDetail job = newJob(MailJob.class) // 指定干活的类MailJob
				.withIdentity("mailjob1", "mailgroup") // 定义任务名称和分组
				.usingJobData("email", "admin@10086.com") // 定义属性
				.build();

		// 调度加入这个job
		scheduler.scheduleJob(job, trigger);

		// 启动
		scheduler.start();

		// 等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}
}