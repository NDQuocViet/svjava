package basic.genericExample;

public class GenericMethod {
	public <M> M Display(M val) {
		return val;
	}

	public static void main(String arg[]) {
		GenericMethod obj = new GenericMethod();
		System.out.println("String :" + obj.Display("test"));
		System.out.println("int :" + obj.Display(2));
		System.out.println("boolean :" + obj.Display(true));
		System.out.println("double :" + obj.Display(7.5));
	}
}

