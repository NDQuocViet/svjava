package basic.genericExample;

public class GenericClass<T> {

	private T t;

	public void setValue(T t) {
		this.t = t;
	}

	public T getValue() {
		return t;
	}

	public static void main(String arg[]) {
		GenericClass<Integer> iobj = new GenericClass<Integer>();
		iobj.setValue(10000);
		System.out.println(iobj.getValue());
		GenericClass<String> sobj = new GenericClass<String>();
		sobj.setValue("ten");
		System.out.println(sobj.getValue());

	}
}
