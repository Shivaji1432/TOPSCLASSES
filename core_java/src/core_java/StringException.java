package core_java;
class StringInvalidException extends Exception{
	
}
class Stringdemio{
	String s="shiv123";
	public void checkstring() throws StringInvalidException {
		int count=0;
		
		for (int i = 0; i < s.length(); i++) {
			if(count==1) {
				throw new StringInvalidException();
			}else {
				System.out.println();
			}
		}
	}
}
public class StringException {
public static void main(String[] args) {
	Stringdemio ss=new Stringdemio();
	try {
		ss.checkstring();
	} catch (StringInvalidException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
