package assignment1;
class Bird{
	public void display(){
		System.out.println("flying...");
	}
}
class Crow extends Bird{
	@Override
	public void display() {
		super.display();
		System.out.println("crow is flying....");
	}
}
class Ostrich extends Bird{
	@Override
	public void display() {
		super.display();
		System.out.println("Ostrich is not flying....");
	}
}
public class PolymorOvRide {
public static void main(String[] args) {
	Crow cr=new Crow();
	cr.display();
}
}
