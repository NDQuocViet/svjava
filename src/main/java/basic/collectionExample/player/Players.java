package basic.collectionExample.player;

public class Players implements interfacePlayer {
	String hoten;
	int huychuongvang;
	int huychuongbac;
	int huychuongdong;

	public Players(String hoten, int huychuongvang, int huychuongbac, int huychuongdong) {

		this.hoten = hoten;
		this.huychuongvang = huychuongvang;
		this.huychuongbac = huychuongbac;
		this.huychuongdong = huychuongdong;
	}

	@Override
	public String toString() {
		return "hoten: " + hoten + "\nhuychuongvang: " + huychuongvang + "\nhuychuongbac: " + huychuongbac
				+ "\nhuychuongdong: " + huychuongdong + "\n";
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getHuychuongvang() {
		return huychuongvang;
	}

	public void setHuychuongvang(int huychuongvang) {
		this.huychuongvang = huychuongvang;
	}

	public int getHuychuongbac() {
		return huychuongbac;
	}

	public void setHuychuongbac(int huychuongbac) {
		this.huychuongbac = huychuongbac;
	}

	public int getHuychuongdong() {
		return huychuongdong;
	}

	public void setHuychuongdong(int huychuongdong) {
		this.huychuongdong = huychuongdong;
	}

	@Override
	public int compareTo(Players o) {
		if (this.huychuongvang == o.huychuongvang && this.huychuongbac == o.huychuongbac) {
			return -this.huychuongdong + o.huychuongdong;
		} else if (this.getHuychuongvang() == o.huychuongvang) {
			return -this.huychuongbac + o.huychuongbac;
		}
		return -this.huychuongvang + o.huychuongvang;
	}

}
