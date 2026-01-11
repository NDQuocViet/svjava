package basic.collectionExample.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class mainPlayer {
	public List<Players> initPlayer() {
		List<Players> playerList = new ArrayList<Players>();
		Random ran = new Random();
		for (int i = 0; i < 30; i++) {
			Players players = new Players("player" + i, ran.nextInt(1, 10), ran.nextInt(1, 10), ran.nextInt(1, 10));
			playerList.add(players);
		}
		return playerList;
	}

	public static void main(String arg[]) {
		mainPlayer mPlayer = new mainPlayer();
		List<Players> lp = mPlayer.initPlayer();
		
		Collections.sort(lp);
		
		for (Players p : lp) {
			System.out.println(p.toString());
		}
	}

}
