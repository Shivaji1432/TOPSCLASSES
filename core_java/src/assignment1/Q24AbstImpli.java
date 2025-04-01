package assignment1;
abstract class Abs{
	public Abs() {
		System.out.println("constructor is calling");
	}
	abstract void display();
}
class Abs1 extends Abs{
	public Abs1() {
		super();
		System.out.println("hello");
	}
	@Override
	void display() {
		System.out.println("welcome to coding world");
	}
}
public class Q24AbstImpli {
public static void main(String[] args) {
	Abs1 a =new Abs1();
	a.display();
}
}
