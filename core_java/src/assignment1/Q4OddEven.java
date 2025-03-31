package assignment1;

import java.util.Scanner;

public class Q4OddEven {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the number");
	int n=sc.nextInt();
	if(n%2!=0) {
		System.out.println("the given number is Odd");
	}else {
		System.out.println("the given number is even");
	}
}
}
