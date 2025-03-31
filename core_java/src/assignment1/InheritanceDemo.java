package assignment1;
class Inherit{
	void display() {
		System.out.println("helooo...");
	}
}
class Demoinherit extends Inherit{
	void call(){
	    super.display();
		System.out.println("yo.....");
	}
}
public class InheritanceDemo {
public static void main(String[] args) {
	Demoinherit dm=new Demoinherit();
	dm.call();

}
}
