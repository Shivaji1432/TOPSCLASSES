package assignment1;
import core_java.*;
import assignment1.*;
class Priv{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
public class Q28Acessdemo {
public static void main(String[] args) {
	AssignUsing a=new AssignUsing();
	
	a.show();//public can acess by inside package and outside package.
	
//	a.setName("shiv");//private method can not access by outside package. 
//	System.out.println(a.getName());//or it cannot access in inside pakage also.	
	Priv p=new Priv();//it can only acess by own class
	p.setName("shiv");
	System.out.println(p.getName());
	
	Shivaji s=new Shivaji();//default access inside or in the class of same package.
	s.display();
 
	Countstring c=new Countstring();//protected access by it sub class on inside and
	c.display();//outside the pacakge
	
}
}
