package assignment1;

import java.util.Scanner;

public class Q2Calc {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("enter your number 1: ");
	int a=sc.nextInt();
	System.out.println("enter your number 2: ");
	int b=sc.nextInt();
	int sum=a+b;
	int sub=a-b;
	float div=a/b;
	int multiple=a*b;
	boolean equal=a==b;
	boolean greater=a>b;
	System.out.println("sum :"+sum);
	System.out.println("sub :"+sub);
	System.out.println("divide :"+div);
	System.out.println("multiple :"+multiple);
	System.out.println("a,b is equal :"+equal);
	System.out.println("a is greater than b :"+greater);
}
}
