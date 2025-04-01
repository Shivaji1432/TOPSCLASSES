package assignment1;
interface Inf{
	public void show();
	public static void seen() {
		System.out.println("hello");
	}
}
interface Infs {
	public void hello();
}
class Multi implements Inf,Infs{

	@Override
	public void hello() {
		System.out.println("this is infs side");
		
	}

	@Override
	public void show() {
		System.out.println("this is inf side");
	}
	
}
public class Q25Multipleiner {
public static void main(String[] args) {
	Multi m=new Multi();
	Inf.seen();
	m.show();
	m.hello();
}
}
