package assignment1;
class Shiv{
	static int a=10;
	int b=10;
	void display() {
		System.out.println(b);
	}
	static void displayst() {
		
		System.out.println(a);
	}
	static int sum(int a,int b) {
		return a+b;
	}
}
public class Q12Stataic {
public static void main(String[] args) {
	
	System.out.println(Shiv.sum(10,20));
	System.out.println(Shiv.a);//static can directly acess through class
//	System.out.println(Shiv.b);//instance variable cannot directly access by class
	Shiv shiv=new Shiv();//we have to create instance or object to call them
	shiv.display();
}
}
