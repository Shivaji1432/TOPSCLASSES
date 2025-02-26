package assignment1;

import java.util.Scanner;

public class Q2Calc {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("enter your number 1: ");
	int a=sc.nextInt();
	System.out.println("enter your number 2: ");
	int b=sc.nextInt();
	System.out.println("enter your choice");
	int choice =sc.nextInt();
	switch(choice){
	case 1:
		System.out.println("the sum of two number  is");
		System.out.println(a+b);
		break;
	case 2:
		System.out.println("the sub of two number  is");
		System.out.println(a-b);
		break;
	case 3:
		System.out.println("the multiple of two number  is");
		System.out.println(a*b);
		break;
	case 4:
		System.out.println("the divsion of two number  is");
		System.out.println(a/b);
		break;
	case 5:
		System.out.println("the divsion of two number  is");
		System.out.println(a%b);
		break;
	case 6:
		System.out.println("the two number is equal");
		System.out.println(a==b);
		break;
	case 7:
		System.out.println("the two number is not equal");
		System.out.println(a!=b);
		break;
	case 8:
		System.out.println("the number a is greater");
		System.out.println(a>b);
		break;
	case 9:
		System.out.println("the number b is greater");
		System.out.println(a<b);
		break;
	case 10:
		System.out.println("the number a is greater and equal to b5");
		System.out.println(a>=b);
		break;
	default:
		System.out.println("error");
	}
}
}
