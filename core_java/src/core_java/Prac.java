package core_java;

import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int N = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//		scanner.close();
//		if (N %2!= 0) {
//			System.out.println("Weird");
//		} else if (N >= 2 && N <= 5) {
//			System.out.println("Not Weird");
//		} else if (N >= 6 && N <= 20) {
//			System.out.println("Weird");
//		} else if ( N >= 20) {
//			System.out.println("Not Weird");
//		} else {
//			System.out.println("invalid type");
//		}
	   
//	        Scanner scan = new Scanner(System.in);
//	        int i = scan.nextInt();
//	        double d=scan.nextDouble();
//	        scan.nextLine();
//	        String s=scan.nextLine();
//	        System.out.println("String: " + s);
//	        System.out.println("Double: " + d);
//	        System.out.println("Int: " + i);
//	        scan.close();

		        Scanner sc=new Scanner(System.in);
		        int n=1;
		        while(true){
		            String s=sc.nextLine();
		            if(s.equals("end-of-file")){
		                break;
		            }
		            System.out.println(n+" "+s);
		            n++;
		        }
		    }
		
	   }


