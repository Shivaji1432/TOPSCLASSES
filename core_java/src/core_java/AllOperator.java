package core_java;

public class AllOperator {
	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		System.out.println(a == b); // relation operator
		System.out.println(a != b); // relation operator
		System.out.println(a >= b);// relation operator
		System.out.println(a <= b);// relation operator
		
		System.out.println("next");
	    
		System.out.println(a = b);// assignment operator
		System.out.println(a += b);// assignment operator
		System.out.println(a -= b);// assignment operator
		System.out.println(a *= b);// assignment operator
		
		System.out.println("next");
		
		System.out.println(a == b && a == b);// logical operator
		System.out.println(a != b && b != a);// logical operator
		System.out.println(a == b || a != b);// logical operator
		System.out.println(!true);// logical operator
		
		System.out.println("next");
		
		String c=a>b? "a is greater":"b is greater";
		System.out.println(c);
	}
}
