package assignment1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q34ArrayLinklist {
public static void main(String[] args) {
	ArrayList<String> a=new ArrayList<String>();
	a.add("shiv");
	a.add("shankar");
	a.add("manish");
	a.add("kanha");
	a.remove(2);
	a.addFirst("ram");
	
	for (String string : a) {
		System.out.println(string);
	}
	System.out.println("*****************************************");
	LinkedList<String> b=new LinkedList<String>();
	b.add("shiv");
	b.add("shankar");
	b.add("manish");
	b.add("kanha");
	b.remove(2);
	b.addFirst("ram");

	for (String string1 : b) {
		System.out.println(string1);
	}
}
}
