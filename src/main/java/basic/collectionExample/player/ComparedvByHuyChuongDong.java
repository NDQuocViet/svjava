package basic.collectionExample.player;

import java.util.Comparator;

public class ComparedvByHuyChuongDong implements Comparator<Players> {

	@Override
	public int compare(Players o1, Players o2) {
		// TODO Auto-generated method stub
		return o1.huychuongdong - o2.huychuongdong;
	}

}
