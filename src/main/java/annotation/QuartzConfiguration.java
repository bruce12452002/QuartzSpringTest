package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
@ComponentScan("annotation")
public class QuartzConfiguration {
	@Autowired
	private MyAnnotationJob myJob;

	// @Bean
	// public JobDetailFactoryBean jobDetail() {
	// JobDetailFactoryBean job = new JobDetailFactoryBean();
	// job.setJobClass(MyJob.class);
	// return job;
	// }
	//
	// @Bean
	// public SimpleTriggerFactoryBean simpleTrigger() {
	// SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
	// trigger.setJobDetail(jobDetail().getObject());
	// trigger.setStartDelay(10);
	// trigger.setRepeatInterval(2000);
	// return trigger;
	// }
	//
	// @Bean
	// public SchedulerFactoryBean schedulerFactory() {
	// SchedulerFactoryBean schedule = new SchedulerFactoryBean();
	// schedule.setTriggers(simpleTrigger().getObject());
	// return schedule;
	// }

	@Bean
	public MethodInvokingJobDetailFactoryBean jobDetail() {
		MethodInvokingJobDetailFactoryBean job = new MethodInvokingJobDetailFactoryBean();
		job.setTargetObject(myJob);
		job.setTargetMethod("getXxx");
		return job;
	}

	@Bean
	public SimpleTriggerFactoryBean simpleTrigger() {
		SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
		trigger.setJobDetail(jobDetail().getObject());
		trigger.setStartDelay(10);
		trigger.setRepeatInterval(2000);
		return trigger;
	}

	// @Bean
	// public CronTriggerFactoryBean cronTriggerBean() {
	// CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
	// cronTriggerFactoryBean.setJobDetail(jobDetail().getObject());
	// cronTriggerFactoryBean.setCronExpression("* * * * * ?");
	// return cronTriggerFactoryBean;
	// }

	@Bean
	public SchedulerFactoryBean trigger() {
		SchedulerFactoryBean schedule = new SchedulerFactoryBean();
		schedule.setTriggers(simpleTrigger().getObject());
		return schedule;
	}

}
