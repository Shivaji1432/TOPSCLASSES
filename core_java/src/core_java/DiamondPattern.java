package core_java;

public class DiamondPattern {
	public static void main(String[] args) {
		int n = 5;

		// Upper part of the Diamond
		for (int i = 1; i <= n; i++) {
			// Print spaces
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			// Print stars
			for (int k = 1; k <= (2 * i - 1); k++) {
				if (k == 1 || k == (2 * i - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		// Lower part of the Diamond
		for (int i = n - 1; i >= 1; i--) {
			// Print spaces
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			// Print stars
			for (int k = 1; k <= (2 * i - 1); k++) {
				if (k == 1 || k == (2 * i - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
