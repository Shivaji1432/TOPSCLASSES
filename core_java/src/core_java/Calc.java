package core_java;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
//      String choice=sc.next();
		int choice=sc.nextInt();
		if (choice == 1) {
			System.out.println(a + b);
		} else if (choice == 2) {
			System.out.println(a - b);
		} else if (choice == 3) {
			System.out.println(a * b);
		} else if (choice == 4) {
			System.out.println(a / b);
		}
//		if (choice =="add") {
//			System.out.println(a + b);
//		} else if (choice =="sub") {
//			System.out.println(a - b);
//		} else if (choice =="multiple") {
//			System.out.println(a * b);
//		} else if (choice =="divide") {
//			System.out.println(a / b);
//		}
	}
}
