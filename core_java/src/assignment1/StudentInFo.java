package assignment1;
class Student{
	String name;
	int age;
	public void display(String name,int age) {
		System.out.println(this.name=name);
		System.out.println(this.age=age);
	}
}
public class StudentInFo{
public static void main(String[] args) {
	Student st=new Student();
	st.display("shiv", 20);
}
}
