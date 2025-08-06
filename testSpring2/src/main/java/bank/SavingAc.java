package bank;

import org.springframework.stereotype.Component;

@Component
public class SavingAc implements Account {

	@Override
	public void detail() {
		System.out.println("Saving....");
	}

}
