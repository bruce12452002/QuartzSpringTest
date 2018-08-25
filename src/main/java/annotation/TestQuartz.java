package annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import annotationTest.MyJob;

@Component
public class TestQuartz {

	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(QuartzConfiguration.class, MyJob.class);
	}

}
