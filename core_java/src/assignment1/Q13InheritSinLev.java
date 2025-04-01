package assignment1;
class Animal{
	public void display() {
		System.out.println("animal class calling....");
	}
}
class Lion extends Animal{
	public void eat() {
		System.out.println("Eat flesh....");
	}
}
public class Q13InheritSinLev {
public static void main(String[] args) {
	Lion l=new Lion();
	l.display();
	l.eat();
}
}
