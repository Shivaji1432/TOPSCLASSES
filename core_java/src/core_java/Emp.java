package core_java;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
class Byid implements Comparator<Employe>{

	@Override
	public int compare(Employe o1, Employe o2) {
		int i=0;
		if(o1.id>o2.id) {
			i=1;
		}
		else if(o1.id<o2.id) {
			i=-1;
		}
		else {
			i=0;
		}
		return i;
	}
	
}
class Byemail implements Comparator<Employe>{

	@Override
	public int compare(Employe o1, Employe o2) {
		
		return o1.email.compareTo(o2.email);
	}
	
}
class Employe{
	int id;
	String name;
	String email;
	public Employe(int id,String name,String email) {
		this.id=id;
		this.name=name;
		this.email=email;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
public class Emp {
public static void main(String[] args) {
	LinkedList<Employe> st=new LinkedList<Employe>();
	st.add(new Employe(3, "shiv", "shiv@gamil.com"));
	st.add(new Employe(1, "shivaji", "shivaji@gamil.com"));
	st.add(new Employe(2, "shalindra", "shalindra@gamil.com"));
	Collections.sort(st,new Byemail());
	for (Employe student12 : st) {
		System.out.println(student12);
	}
}
}
