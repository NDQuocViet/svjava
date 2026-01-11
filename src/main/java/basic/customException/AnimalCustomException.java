package basic.customException;

import basic.dongvat.AnimalInterface;

public class AnimalCustomException extends Exception {
	private static final long serialVersionUID = 1L;
	private AnimalInterface dv = null;
	
	public AnimalCustomException(String message, AnimalInterface obj1, AnimalInterface obj2) {
		super(message);
		dv = (obj1.getTuoitrungbinh() == 0) ? obj1 : obj2;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("\nNguyen nhan loi: ").append("\n\t");
		sb.append("Doi tuong \"").append(this.dv.getTen()).append("\"").append(" co tuoi trung binh = 0. \n\t");
		sb.append("Class:").append(dv.getClass().getName());
		return sb.toString();
	}
}
