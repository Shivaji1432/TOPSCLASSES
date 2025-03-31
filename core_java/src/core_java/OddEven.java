package core_java;

import java.util.Scanner;

public class OddEven {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int userInput=sc.nextInt();
	for(int i=userInput;i<=100;i++) {
		if(i%2==0) {
			System.out.println(i+"this is even number");
		}else {
			System.out.println(i+"this is odd number");
		}
	}
}
}
