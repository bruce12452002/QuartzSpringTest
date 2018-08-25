package network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configurable
@ComponentScan("network")
public class QuartzConfiguration {
	@Autowired
	private LoseClassQuartz loseClassQuartz;

	@Bean
	public MethodInvokingJobDetailFactoryBean jobDetail() {
		MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		methodInvokingJobDetailFactoryBean.setTargetObject(loseClassQuartz);
		methodInvokingJobDetailFactoryBean.setTargetMethod("doJob");
		return methodInvokingJobDetailFactoryBean;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerBean() {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(jobDetail().getObject());
		// 每5秒执行一次
		// cronTriggerFactoryBean.setCronExpression("0/5 * * * * ?");
		// 每秒执行一次，这个表达式很重要，任务调度执行频率
		cronTriggerFactoryBean.setCronExpression("* * * * * ?");
		return cronTriggerFactoryBean;
	}

	@Bean
	public SchedulerFactoryBean trigger() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setTriggers(cronTriggerBean().getObject());
		return schedulerFactoryBean;
	}
}
