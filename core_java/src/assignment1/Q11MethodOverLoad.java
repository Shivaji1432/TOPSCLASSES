package assignment1;
class Method{
	public void display() {
		System.out.println("hello...");
	}
	public void display(int a) {
		System.out.println(a+"hello...");
	}
	public int  display(int a,int b) {
		System.out.println(a+"hello..."+b);
		return a;
	}
	public float  display(int a,float b) {
		System.out.println(a+"hello..."+b);
		return b;
	}
	
}
public class Q11MethodOverLoad {
public static void main(String[] args) {
	Method method=new Method();
	method.display();
	method.display(12);
	method.display(12,52);
	method.display(10,20.00f);
}
}
