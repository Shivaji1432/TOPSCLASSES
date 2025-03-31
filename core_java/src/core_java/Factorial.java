package core_java;

public class Factorial {

	public static void main(String[] args) {
		int n=10;
		int fact=1;
//		for(int i=1;i<=n;i++) {
//			fact *=i;
//			
//		}
		while(n!=0) {
			fact *=n;
			n--;
		}
		System.out.println(fact);
	}

}
