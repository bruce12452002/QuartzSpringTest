
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryTest {

	public static void main(String[] args) {
		//new ClassPathXmlApplicationContext("quartz.xml");
		new AnnotationConfigApplicationContext(annotation.QuartzConfiguration.class);
	}
}
