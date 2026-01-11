package basic.genericExample;

public class WildCard <T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public boolean compare(WildCard<? extends Number > wcd) {
		if(t==wcd.t) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main (String arg[]) {
		WildCard<Integer> obj1 = new WildCard<Integer>();
		obj1.setT(10);
		
		WildCard<String> obj2 = new WildCard<String>();
		obj2.setT("test");
		
		WildCard<Integer> obj3 = new WildCard<Integer>();
		obj3.setT(100);
		
		System.out.println("first: "+ obj1.getT());
		System.out.println("second: "+ obj2.getT());
		System.out.println("equal: " +obj1.compare(obj3));

	}
}
