package sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cricket")
public class Cricket implements Sport {

	@Autowired
	@Qualifier("active")
	Player player;

	@Override
	public void stats() {
		System.out.println("ALL OUT..");
		player.playerinfo();
	}

}
