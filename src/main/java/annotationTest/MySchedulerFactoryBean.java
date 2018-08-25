package annotationTest;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@ComponentScan("annotationTest")
@Component
public class MySchedulerFactoryBean extends SchedulerFactoryBean {
	@Autowired
	private MySimpleTriggerFactoryBean simpleTrigger;

	@Override
	public void setTriggers(Trigger... triggers) {
		super.setTriggers(simpleTrigger.getObject());
	}
}
