package core_java;

import java.util.Iterator;
import java.util.TreeSet;

public class Treesetex {
public static void main(String[] args) {
	TreeSet<Integer>n=new TreeSet<Integer>();
	n.add(12);
	n.add(52);
	n.add(50);
	Iterator<Integer> i=n.descendingIterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
}
}
