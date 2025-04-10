package assignment1;
interface BankAccount{
	public void credit(double amount);
	public void debit(double amount);
}
class AcDetail implements BankAccount{
	String AcName;
	double Balance;
	public void acdetail(String AcName,double Balance) {
		this.AcName=AcName;
		this.Balance=Balance;
	}
	@Override
	public void credit(double amount) {
		Balance+=amount;
		System.out.println(AcName+"your account is credit with rupees :"+amount);
		System.out.println("your account balance is :"+Balance);
	}
	@Override
	public void debit(double amount) {
		if(amount<=Balance) {
			Balance-=amount;
			System.out.println(AcName+"your account is debit with rupees :"+amount);
		}else {
			System.out.println("insufficiant balance");
		}
		
	}
	public void accountbalance() {
		System.out.println("your account balance is :"+Balance);
		}
}
public class Q26RealWrldEx {
public static void main(String[] args) {
	AcDetail ac=new AcDetail();
	ac.acdetail("shivshankar", 1000);
	ac.credit(5000);
	ac.debit(2000);
	ac.debit(10000);
	ac.accountbalance();
}
}

