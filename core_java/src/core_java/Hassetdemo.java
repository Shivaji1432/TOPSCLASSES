package core_java;

import java.util.HashSet;
import java.util.Iterator;

public class Hassetdemo {
public static void main(String[] args) {
	HashSet<String> s=new HashSet<String>();
	s.add("shiv");
	s.add("monil");
	s.add("ronak");
	s.add("shiv");
	Iterator<String> i=s.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
}
}
