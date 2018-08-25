package annotation;

import org.springframework.stereotype.Component;

@Component
//@PersistJobDataAfterExecution
//@DisallowConcurrentExecution
public class MyAnnotationJob {// extends QuartzJobBean {
//	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
//		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
//	}

	 public void getXxx() {
		 System.out.println("xxxxxxxxxxxxxxxxxxxxx");
	 }
}
