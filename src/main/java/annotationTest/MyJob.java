package annotationTest;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

//@Component
//@ComponentScan("annotationTest")
//@EnableScheduling
//@DisallowConcurrentExecution
public class MyJob extends QuartzJobBean {
	private int timeout;

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("aaa=" + ctx.getJobDetail().getJobDataMap().get("aaa"));
		ctx.getJobDetail().getJobDataMap().put("aaa", "333");
	}

	// @Scheduled(cron = "0/2 10 15 * * ?")
	// public void getXxx() {
	// try {
	// System.out.println("前=" + new Date());
	// Thread.sleep(5000);
	// System.out.println("後=" + new Date());
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
}
