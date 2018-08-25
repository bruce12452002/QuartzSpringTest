package annotationTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuartz {

	public static void main(String[] args) {
//		new AnnotationConfigApplicationContext(MyJob.class);
		new ClassPathXmlApplicationContext("quartz.xml");
	}

}
