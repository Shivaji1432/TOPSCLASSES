package sport;

import org.springframework.stereotype.Component;

@Component("win")
public class Winner implements Player {

	@Override
	public void playerinfo() {
		System.out.println("you win...");
	}

}
