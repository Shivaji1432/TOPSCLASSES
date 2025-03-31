package core_java;

public class Exe1 {
	public static void main(String[] args) {
		int rows = 5;
		int space = rows - 1;
		int stars = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
		
		for (int j = 1; j <= 2*stars-1; j++) {
			System.out.print("*");
		}
		stars++;
		space--;
		System.out.println("");
		
		
	}
}
}
