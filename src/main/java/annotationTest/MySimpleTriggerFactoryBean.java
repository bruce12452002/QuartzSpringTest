package annotationTest;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

@ComponentScan("annotationTest")
@Component
public class MySimpleTriggerFactoryBean extends SimpleTriggerFactoryBean {
	@Autowired
	private MyJobDetailFactoryBean jobDetailBean;

	@Override
	public void setJobDetail(JobDetail jobDetail) {
		super.setJobDetail(jobDetailBean.getObject());
	}

	@Override
	public void setStartDelay(long startDelay) {
		super.setStartDelay(10);
	}

	@Override
	public void setRepeatInterval(long repeatInterval) {
		super.setRepeatInterval(2000);
	}

}
