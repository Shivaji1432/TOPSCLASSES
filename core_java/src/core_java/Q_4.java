package core_java;

public class Q_4 {
public static void main(String[] args) {
	int a=0;
	int b=1;
	System.out.print(a+" "+b);
	for(int i=1;i<=10;i++) {
		int c=a+b;
		System.out.print(" "+c);
		a=b;
		b=c;
	}
}
}
