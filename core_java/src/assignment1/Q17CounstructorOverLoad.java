package assignment1;
class Construct{
	public Construct() {
		System.out.println("constructer called..");
	}
	public Construct(int age ) {
		System.out.println("your age is "+age);
	}
	public Construct(int age,int id ) {
		System.out.println("your age is "+age+"your id is"+id);
	}
	public Construct(float percentage) {
		System.out.println("your percentage is "+percentage);
	}
}
public class Q17CounstructorOverLoad {
public static void main(String[] args) {
		Construct st=new Construct();
		Construct st1=new Construct(12.00f);
		Construct st2=new Construct(12);
		Construct st3=new Construct(12,2);
		
		
	}
	}


