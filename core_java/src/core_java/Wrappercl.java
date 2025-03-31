package core_java;

public class Wrappercl {
public static void main(String[] args) {
	int a=10;
	Integer a1=new Integer(a);//boxing
	Integer a2=a;//autoBoxing
	Integer b=10;
	int b1=b.intValue();//unBoxing
	int b2=b;//autuBoxing
	Integer c1=10;
	c1.toString();
	 String s="10";
	 int s1=Integer.parseInt(s);
	 Double d=123.2625;
	 Float.parseFloat(d.toString());
	
}
}
