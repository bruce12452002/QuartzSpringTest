package annotation;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
//@PersistJobDataAfterExecution
//@DisallowConcurrentExecution
public class MyAnnotationJob extends QuartzJobBean {
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
	}

//	 public void getXxx() {
//		 System.out.println("xxxxxxxxxxxxxxxxxxxxx4");
//	 }
}
