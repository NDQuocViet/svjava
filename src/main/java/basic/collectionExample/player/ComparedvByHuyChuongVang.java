package basic.collectionExample.player;

import java.util.Comparator;

public class ComparedvByHuyChuongVang implements Comparator<Players> {

	@Override
	public int compare(Players o1, Players o2) {

		return o1.huychuongvang - o2.huychuongvang;
	}

}
