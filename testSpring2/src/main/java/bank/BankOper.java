package bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankOper {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ax = new AnnotationConfigApplicationContext(AppConfig.class);
		Account sv = ax.getBean("savingAc", Account.class);
		Account ln = ax.getBean("loanAc", Account.class);
		sv.detail();
		ln.detail();
	}
}
