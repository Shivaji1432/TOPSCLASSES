package core_java;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		// the sum of even 1 to 100
//	int sum =0;
//	for (int i=1;i<=100;i++) {
//		if(i%2==0) {
//			sum+=i;
//		}
//	}System.out.println(sum);
		Scanner sc = new Scanner(System.in);
//		String userInput = null;
//		do {
//			System.out.println("enter no 1: ");
//			int num1 = sc.nextInt();
//			System.out.println("enter no 2: ");
//			int num2 = sc.nextInt();
//			System.out.println("enter choice: ");
//			String userChoice = sc.next();
//			int result = 0;
//			switch (userChoice) {
//			case "add":
//				result = num1 + num2;
//				System.out.println(result);
//
//			case "sub":
//				result = num1 - num2;
//				System.out.println(result);
//				break;
//
//			case "multiple":
//				result = num1 * num2;
//				System.out.println(result);
//				break;
//
//			case "div":
//				result = num1 / num2;
//				System.out.println(result);
//				break;
//
//			default:
//				System.out.println("invalid data");
//				break;
//			}
//			System.out.println("do you want to continue : ");
//			userInput = sc.next();
//		} while (!userInput.equals("n"));
		int a[]= {1,2,3,4,5};
		int temp=a[0];
//		int temp1=a[a.length-1];
//		for (int i = a.length-1;i>=1; i--) {
//			a[i]=a[i-1];
//		}a[0]=temp1;
//		System.out.println(Arrays.toString(a));
		for (int i = 1; i <a.length; i++) {
			a[i-1]=a[i];
		}
		a[a.length-1]=temp;
		System.out.println(Arrays.toString(a));
		
}
}
