package core_java;
class Animal{
	String eat;
	public Animal() {
       System.out.println("three type of animal");
	}
	public void omni(String eat) {
		this.eat=eat;
		System.out.println(eat);
	}
}
public class Oops {
public static void main(String[] args) {
	Animal an=new Animal();
	an.omni("grass and flesh eating omnivor");
	an.omni("flesh eating carnivor");
	an.omni("grass eating herbivor");
}
}
