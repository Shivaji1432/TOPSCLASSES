package assignment1;
class Invalid extends Exception{
	public  Invalid(String message) {
		super(message);
	}
}
class Agevalid{
	public void age(int age) throws Invalid {
		if(age<18) {
			throw new Invalid("you are not valid for vote");
		}else {
			System.out.println("you are valid");
		}
	}
}
public class Q31CustomExcep {
public static void main(String[] args) {
	Agevalid a=new Agevalid();
	try {
		a.age(16);
	} catch (Invalid e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
}
}
