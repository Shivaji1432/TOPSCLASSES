package sport;

import org.springframework.stereotype.Component;

@Component("active")
public class ActivePlayer implements Player {

	@Override
	public void playerinfo() {
		System.out.println("4 player remains....");
	}

}
