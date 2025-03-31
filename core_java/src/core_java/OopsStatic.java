package core_java;
class Static{
	static int count=0;
	public Static() {
		count++;
	}
}
public class OopsStatic {
public static void main(String[] args) {
	Static s=new Static();
	Static s1=new Static();
	System.out.println("object no: "+Static.count);
}
}
