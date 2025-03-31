package core_java;

public class Q_3 {
	public static void main(String[] args) {
		for (int j = 3; j <= 100; j++) {
			int n = j;
			boolean b = false;
			for (int i = 2; i <n; i++) {
				if (n % i == 0) {
					b = true;
					break;
				}
			}
			if (b == false) {
				System.out.println(n+"prime");
			} else {
				System.out.println(n+"composite");
			}
		}
	}
}
