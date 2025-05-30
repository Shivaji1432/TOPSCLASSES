package assignment1;

import java.util.Scanner;

class Paytm{
	double wallet;
	public Paytm(double wallet) {
		this.wallet=wallet;
	}
	public boolean isamtexist(double amt) {
		boolean b=false;
		if(wallet>=amt) {
			b=true;
		}
		return b;
	}
	//here we can synchronized the method directly so we don't have to use 
	//synchronized block
	public void debit(double amt) {
		wallet-=amt;
		System.out.println("debit amount : "+amt+" remaining wallet : "+wallet);
	}
	public void credit(double amt) {
		wallet+=amt;
		System.out.println("credit amount : "+amt+" remaining wallet : "+wallet);
	}
}
class User extends Thread{
	String username;
	Paytm paytm;
	boolean isdebit;
	public User(String username,Paytm paytm,boolean isdebit) {
		this.username=username;
		this.paytm=paytm;
		this.isdebit=isdebit;
	}
	@Override
	public void run() {
		//synchronized block 
		synchronized (paytm) {
			Scanner sc=new Scanner(System.in);
			System.out.println(username+" : enter amount");
			double amt=sc.nextDouble();
			if(isdebit) {
				if(paytm.isamtexist(amt)) {
				paytm.debit(amt);
			}else {
				System.out.println("invalid entry");
			}
		}else {
			paytm.credit(amt);
		}
		}
	}
}
public class Q41Threadsync {
public static void main(String[] args) {
	Paytm paytm=new Paytm(1000);
	User user1=new User("shiv", paytm, true);
	User user2=new User("sitesh", paytm, false);
	user1.start();
	user2.start();
	
}
}
