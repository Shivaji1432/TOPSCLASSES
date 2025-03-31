package core_java;

class Calculate {
	static int add(int a, int b) {
		return a + b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

	static float divide(float a, float b) {
		return a / b;
	}

	static int sub(int a, int b) {
		return a - b;
	}

}

public class CalcSim {
	public static void main(String[] args) {
     System.out.println(Calculate.add(10, 20));
	}

	
}
