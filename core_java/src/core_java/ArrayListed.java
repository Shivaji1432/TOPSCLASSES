package core_java;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListed {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("shiv");
		a.add(20);
		a.add('a');
		a.add(10);
		a.add(2, "shiva");
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(55);
		b.add(20);
		b.add(40);
		b.add(100);
		b.add(2, 60);
//	a.remove(3);
//	a.set(2, 10);
//	System.out.println(a.size());
//	for (Integer i : a) {
//		System.out.println(i);
//	}

		b.addAll(a);
		Iterator<Integer> o = b.iterator();
		while (o.hasNext()) {
			System.out.println(o.next());
		}
	}
}
