package core_java;

import java.util.Scanner;

public class CalcCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String choice = sc.next();
		switch (choice) {
		case "add":
			System.out.println(a + b);
			break;
		case "sub":
			System.out.println(a - b);
			break;
		case "multiple":
			System.out.println(a * b);
			break;
		case "divide":
			System.out.println(a / b);
			break;
		default:
			System.out.println("invalid");
		}
	}
}
