package annotationTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

@ComponentScan("annotationTest")
@Component
public class MyJobDetailFactoryBean extends JobDetailFactoryBean {
	@Autowired
	private MyJob job;

	@Override
	public void setJobClass(Class<?> jobClass) {
		super.setJobClass(job.getClass());
	}

}
