package basic.dongvat;

import java.io.Serializable;

import basic.customException.AnimalCustomException;

@SuppressWarnings("serial")
public abstract class dongvat implements AnimalInterface, Serializable {
	private String ten;
	private int tuoiht;
	private String moitruong;
	private float tuoitrungbinh;

	public dongvat(String ten, int tuoiht, String moitruong, float tuoitrungbinh) {
		this.ten = ten;
		this.tuoiht = tuoiht;
		this.moitruong = moitruong;
		this.tuoitrungbinh = tuoitrungbinh;
	}
	
	public int getPhanLoai() {
		double ketQua = (double)this.getTuoiht() / this.getTuoitrungbinh();
		int loai = (ketQua < 0.3) ? 1 : ((ketQua >= 0.3 && ketQua <= 0.6 )? 2 : 3);
		return loai;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getPhanLoai();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || this.getClass() != obj.getClass()) return false;
		dongvat dv = (dongvat) obj;
		if(this.getClass() == obj.getClass() && this.getTen().equals(dv.getTen()) 
					&& this.getTuoiht() == dv.getTuoiht() ) return true;
		return false;
	}

	public void sosanh(AnimalInterface obj) throws AnimalCustomException {
		if(this.getTuoitrungbinh() == 0 || obj.getTuoitrungbinh() == 0) 
			throw new AnimalCustomException("phat sinh phep chia cho 0", (AnimalInterface)this, obj);

		if ((this.getTuoiht() / this.getTuoitrungbinh()) > (obj.getTuoiht() / obj.getTuoitrungbinh())) {
			System.out.println(this.ten + " lon tuoi hon " + obj.getTen());
		} else if ((this.getTuoiht() / this.getTuoitrungbinh()) < (obj.getTuoiht() / obj.getTuoitrungbinh())) {
			System.out.println(obj.getTen() + " lon tuoi hon " + this.ten);
		} else {
			System.out.println("hai con bang tuoi");
		}
	}
	
	@Override
	public int compareTo(AnimalInterface o) {
		return (this.getTuoiht() / this.getTuoitrungbinh() > 
					o.getTuoiht()/ o.getTuoitrungbinh())? 1 : -1;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	public void setTuoiht(int tuoiht) {
		this.tuoiht = tuoiht;
	}
	public void setMoitruong(String moitruong) {
		this.moitruong = moitruong;
	}
	public void setTuoitrungbinh(float tuoitrungbinh) {
		this.tuoitrungbinh = tuoitrungbinh;
	}
	public String getTen() {
		return ten;
	}
	public int getTuoiht() {
		return tuoiht;
	}
	public String getMoitruong() {
		return moitruong;
	}
	public float getTuoitrungbinh() {
		return tuoitrungbinh;
	}
	public void inthongtin(){
		System.out.println("ten: " + ten);
		System.out.println("\tmoi truong song: " + moitruong);
		System.out.println("\ttuoi hien tai: " + tuoiht);
		System.out.println("\ttuoi trung binh: " + tuoitrungbinh);
		System.out.println("\ttuoiht/tuoitrungbinh:" + (tuoiht/ tuoitrungbinh));
	}
}
