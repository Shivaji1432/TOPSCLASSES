package assignment1;
class Constructs{
	public Constructs() {
		System.out.println("constructor calling....");
	}
	public Constructs(String a) {
		System.out.println("constructor calling...."+a);
	}
	public Constructs(String a,int b) {
		System.out.println(b+"constructor calling...."+a);
	}
}
public class Q8ConstructorOverLoad {
public static void main(String[] args) {
	Constructs c=new Constructs();
	Constructs c1=new Constructs("shiv");
	Constructs c2=new Constructs("Shiva",2);
	
	
}
}
