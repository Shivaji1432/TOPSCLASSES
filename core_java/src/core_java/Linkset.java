package core_java;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Linkset {
public static void main(String[] args) {
	LinkedHashSet a=new LinkedHashSet();
	a.add(12);
	a.add("hello");
	a.add('a');
	Iterator i=a.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
}
}
