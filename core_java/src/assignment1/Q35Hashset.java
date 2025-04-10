package assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class Q35Hashset {
public static void main(String[] args) {
	//hashset not allow duplicate data.
	HashSet<Integer> i=new HashSet<Integer>();
	i.add(15);
	i.add(225);
	i.add(155);
	i.add(215);
	i.add(15);
	System.out.println(i);
	System.out.println(i.size());
	System.out.println("*******************************");
	//arraylist allow duplicate nut we can use hashset to remove duplicate.
	ArrayList<Integer> a=new ArrayList<Integer>();
	a.add(10);
	a.add(20);
	a.add(30);
	a.add(20);
	a.add(10);
	System.out.println(a);
	System.out.println(a.size());
	System.out.println("after removing duflicate value.");
	HashSet<Integer>d=new HashSet<Integer>(a);
	System.out.println(d);
	System.out.println(d.size());
}
}
