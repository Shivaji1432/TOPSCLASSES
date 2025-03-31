package core_java;
class Animals
{
  public void display() {
	  System.out.println("type of animal....");
  }
}
class Omnivore extends Animals
{
	public void display1() {
		System.out.println("they eat both grass and flesh...");
	}
}
class Carnivore extends Animals
{
  public void display2() {
	  System.out.println("they can eat flesh...");
  }
}
class Herbivore extends Animals
{
	public void display3() {
		System.out.println("they can eat flesh...");
	}
}
public class OopsInherti {
public static void main(String[] args) {
	Animals a=new Animals();
	Herbivore a1=new Herbivore();
	a.display();
	a1.display3();
	Animal animal=new Animal();
	animal.omni("eat");
}
}
