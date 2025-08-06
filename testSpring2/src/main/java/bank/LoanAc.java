package bank;

import org.springframework.stereotype.Component;

@Component("loanAc")
public class LoanAc implements Account {

	@Override
	public void detail() {
		System.out.println("Loan...");
	}
}

