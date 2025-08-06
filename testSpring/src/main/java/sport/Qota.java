package sport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Qota {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ax = new AnnotationConfigApplicationContext(Appconfig.class);

		Sport c = ax.getBean("cricket", Sport.class);
		Sport ch = ax.getBean("chess", Sport.class);

		c.stats();
		ch.stats();
	}
}
