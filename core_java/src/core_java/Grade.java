package core_java;
import java.util.*;
public class Grade {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int marks=sc.nextInt();
        if(marks>=95) {
        	System.out.println("Grade A++");
        }else if(marks<90 && marks>=80) {
        	System.out.println("Grade A");
        }else if(marks<80 && marks>=60) {
        	System.out.println("Grade B");
        }else if(marks<60 && marks>=50) {
        	System.out.println("Grade B+");
        }else if(marks<50 && marks>=33) {
        	System.out.println("Grade C");
        }else if(marks<33 && marks>=0) {
        	System.out.println("Grade F");
        }
	}

}
