package assignment1;
class Democlasses{
	public Democlasses() {
		System.out.print("hello ");
	}
	public void display(String a) {
		System.out.print(a+" world");
	}
}
class Demos extends Democlasses{
	public Demos() {
		super();
		System.out.println("ji");
	}
	public void show() {
		super.display("namaste");
		System.out.print(" java");
	}
}
public class Q23SuperDemo {

	public static void main(String[] args) {
		Demos d=new Demos();
		d.show();
		

	}

}
