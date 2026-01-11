package basic.collectionExample.player;

import java.util.Comparator;

public class ComparedvByHuyChuongBac implements Comparator<Players> {

	@Override
	public int compare(Players o1, Players o2) {
		// TODO Auto-generated method stub
		return o1.huychuongbac - o2.huychuongbac;
	}

}
