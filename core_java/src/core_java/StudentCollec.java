package core_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

class Student12 implements Comparable<Student12>{
	int id;
	String name;
	String email;
	public Student12(int id,String name,String email) {
		this.id=id;
		this.name=name;
		this.email=email;
	}
	@Override
	public String toString() {
		return "Student12 [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	@Override
	public int compareTo(Student12 o) {
//		int i=0;
//		if(this.id>o.id) {
//			i=1;
//		}
//		else if(this.id<o.id) {
//			i=-1;
//		}
//		else {
//			i=0;
//		}
//		return i;
		return this.name.compareTo(o.name);
	}
	
}
public class StudentCollec {
public static void main(String[] args) {
	LinkedList<Student12> st=new LinkedList<Student12>();
	st.add(new Student12(3, "shiv", "shiv@gamil.com"));
	st.add(new Student12(1, "shivaji", "shivaji@gamil.com"));
	st.add(new Student12(2, "shalindra", "shalindra@gamil.com"));
	Collections.sort(st);
	for (Student12 student12 : st) {
		System.out.println(student12);
	}
}
}
