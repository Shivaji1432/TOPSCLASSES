package assignment1;

class D1 {
	void display() throws ClassNotFoundException {
		Class.forName("logical.Shiv");
	}

	void show() {
		int mark[] = { 10, 20, 30 };
		for (int i = 0; i < mark.length; i++) {
			System.out.println(mark[i]);
		}
		System.out.println(mark[2]);
	}
}

public class Q30ExceptionDiffer {
	public static void main(String[] args) {
		D1 d = new D1();
		try {
			d.show();
			d.display();
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("array out of bound");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
