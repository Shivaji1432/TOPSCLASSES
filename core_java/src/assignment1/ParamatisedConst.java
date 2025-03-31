package assignment1;
class Tiger{
	public Tiger(float a) {
		System.out.println("tiger is roaring...");
	}
	public Tiger(int a) {
		System.out.println(a+"tiger is roaring...");
	}
	public Tiger(int a,int b) {
		System.out.println(a+"tiger is roaring... with another"+b+"tigers");
	}
}
public class ParamatisedConst {
public static void main(String[] args) {
	Tiger t=new Tiger(1);
	Tiger t1=new Tiger(5);
	Tiger t2=new Tiger(1,2);
	
}
}
