package core_java;
class AgeInvalidException extends Exception {
	
}
class Age{
	int n=19;
	public void getage() throws AgeInvalidException{
	if(n<18){
		throw new AgeInvalidException();
	}else {
		System.out.println(n+"you are valid");
	}
}
}
public class Exceptiondemo {
public static void main(String[] args) {
	Age a=new Age();
	try {
		a.getage();
	} catch (AgeInvalidException e) {
		e.printStackTrace();
	}
	
}
}
