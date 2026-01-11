package basic.genericExample;

public class Pair<X, Y> {
	private X first;
	private Y second;

	public Pair(X a1, Y a2) {
		first = a1;
		second = a2;
	}

	public X getFirst() {
		return first;
	}

	public void setFirst(X first) {
		this.first = first;
	}

	public Y getSecond() {
		return second;
	}

	public void setSecond(Y second) {
		this.second = second;
	}

	public static void main(String arg[]) {
		Pair<String, Integer> obj1 = new Pair<String, Integer>("test", 1);
		System.out.println("String is " + obj1.getFirst());
		System.out.println("Int is " + obj1.getSecond());

	}
}
