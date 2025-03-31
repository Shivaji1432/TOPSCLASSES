package core_java;
class Student
{
	//method overload
	public void add(int a,int b) {
		int c=a+b;
		System.out.println(c);
	}
	public int add(byte a,int b) {
	System.out.println("byte");
		int c=a+b;
		return c;
	}
}
public class OopsMethods {
public static void main(String[] args) {
	Student s1=new Student();
	s1.add(10, 20);
	s1.add(10, 30);
}
}
