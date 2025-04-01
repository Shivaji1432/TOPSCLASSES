package assignment1;

public class Q20StringMethodE_C {
public static void main(String[] args) {
	String s="shiv";
	String s1="shankar";
	String s2="shiv";
	System.out.println(s.equals(s2));//compare the value given in string is equal or not.
	System.out.println(s.equals(s1));
	System.out.println(s.compareTo(s2));//here it compare the value given in string and
	System.out.println(s1.compareTo(s));//gives 0 for true and +pve and -nve for false 
}
}
