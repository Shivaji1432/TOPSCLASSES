package core_java;

public class DataType {

	public static void main(String[] args) {
		int a=10;
		short b=15;
		long c=20;
		byte d=25;
		 float e=30.00f;
		 double f=35.00;
		 char g='a';
		 boolean x=false;
		 System.out.println(a+b+c+d+e+f+g);
		 if(!x ) {
		 System.out.println("you are true");
		 }else {
			 System.out.println("you are not");
		 }
		long l= a;
		System.out.println(l+1000000000000000l);
        short s= (short)a;
        int b1=(int)l;
        System.out.println("int "+b1+" short "+s);
}
}
