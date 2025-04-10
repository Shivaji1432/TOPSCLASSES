package assignment1;
class Test extends Thread{
	String name;
	public Test(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(name+" : "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+" : done");
	}
}
public class Q40MultiThread {
public static void main(String[] args) {
	Test t1=new Test("first");
	Test t2=new Test("second");
	Test t3=new Test("third");
	Test t4=new Test("fourth");
	Test t5=new Test("fifth");
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
}
}
