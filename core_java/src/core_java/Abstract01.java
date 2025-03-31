package core_java;
abstract class Ac{
	public abstract void display();
}
class Sv extends Ac{

	@Override
	public void display() {
		System.out.println("saving account..");
		
	}
	
}
public class Abstract01 {
public static void main(String[] args) {
	Sv sv=new Sv();
	sv.display();
}
}
