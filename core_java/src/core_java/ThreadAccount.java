package core_java;

import java.util.Scanner;

class Acc1 {
	double balance;

	public Acc1(double balance) {
		super();
		this.balance = balance;
	}
	public boolean amtExist(double amt) {
		boolean b=false;
		if(balance>=amt) {
			b=true;
	}
		return b;
	}
	public void withdraw(double amt) {
		balance-=amt;
	}
}
class Cust extends Thread{
	String name;
	Acc1 account=new Acc1(10000);
	
	public Cust(String name, Acc1 account) {
		super();
		this.name = name;
		this.account = account;
	}
	void display() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter amount to withdraw :"+name);
		double amt=sc.nextDouble();
		if(account.amtExist(amt)) {
			account.withdraw(amt);
		}else {
			System.out.println();
		}
	}
	
}
public class ThreadAccount {
public static void main(String[] args) {
	Acc1 account=new Acc1(10000);
	Cust c=new Cust("shiv",account);
	Cust c1=new Cust("sitesh",account);
	
}
}
