package sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Chess implements Sport {

	@Autowired
	@Qualifier("win")
	Player player;

	@Override
	public void stats() {
		System.out.println("CheckMate....");
		player.playerinfo();
	}
}
