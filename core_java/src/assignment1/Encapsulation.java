package assignment1;
class Account{
	private int id;
	public int getId() {
		return id;
	}
	private int password;
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
}
public class Encapsulation {
public static void main(String[] args) {
	Account ac=new Account();
	ac.setId(12);
	System.out.println("your id is "+ac.getId());
	ac.setPassword(123456);
	System.out.println("your password is "+ac.getPassword());
}
}
