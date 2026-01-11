package basic.dongvat;

import java.io.Serializable;
import java.util.Comparator;

import basic.customException.AnimalCustomException;

public interface AnimalInterface extends Serializable, Comparable<AnimalInterface> {
	public String noiGiDo();
	public void sosanh( AnimalInterface obj) throws AnimalCustomException;
	public void inthongtin();
	public String getTen() ;
	public int getTuoiht();
	public String getMoitruong() ;
	public float getTuoitrungbinh();
	
	/**
	 * Sử dụng phân loại để nhóm các đối tượng theo <tuoiHienTai>/ <tuoiTrungBinh>
	 * nếu kết quả < 0.3 thì thuộc nhóm 1
	 * nếu kết quả [0.3, 0.6] thuộc nhóm 2 
	 * nếu kết quả > 0.6 thì thuộc nhóm 3
	 * @return
	 */
	public int getPhanLoai();
	
	public static final int currentYear = 2025;
}
