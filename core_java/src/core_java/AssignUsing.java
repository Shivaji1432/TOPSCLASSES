package core_java;

public class AssignUsing {
	private String name;
	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	public void show() {
		System.out.println("hello");
	}
	protected void display() {
		System.out.println("hello in the world java");
	}
public static void main(String[] args) {
	AssignUsing a=new AssignUsing();
	a.show();
	a.display();
}
}

