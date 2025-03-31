package core_java;

import java.util.Scanner;

public class GradeCase {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    int marks=sc.nextInt();
    switch(marks) {
    case 90-100:
    	System.out.println("A");
    	break;
    case 75-90:
    	System.out.println("B");
    	break;
    default:
    	System.out.println("invalid");
    }
}
}
