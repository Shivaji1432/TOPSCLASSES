package core_java;

public class HollowPattern {
	public static void main(String[] args) {

		int n = 5;

		// Simple square pattern
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// logic for print hollow square
				if (i == 1 || i == n || j == 1 || j == n) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}
}
