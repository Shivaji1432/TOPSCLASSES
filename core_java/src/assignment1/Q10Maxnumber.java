package assignment1;
public class Q10Maxnumber {
public static void main(String[] args) {
	int a=15;
	int b=25;
	int c=3;
	int maxno=max(a,b,c);
	System.out.println(maxno);
	
}
public static int max(int a,int b,int c) {
	if (a>=b && a>=c) {
		return a;
	}else if(b>=a && b>=c) {
		return b;
	}else {
		return c;
	}
}
}
