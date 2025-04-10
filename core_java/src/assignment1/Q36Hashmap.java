package assignment1;

import java.util.HashMap;

public class Q36Hashmap {
public static void main(String[] args) {
	HashMap<String, Integer>age=new HashMap<String, Integer>();
	age.put("shiv", 25);
	age.put("sitesh", 38);
	age.put("manish", 28);
	age.remove("shiv");
	System.out.println(age.get("sitesh"));
	System.out.println(age.get("shiv"));
	System.out.println(age.get("manish"));
	System.out.println(age);
	System.out.println(age.size());
}
}
