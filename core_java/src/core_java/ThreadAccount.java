package core_java;

import java.util.Scanner;

class Acc1 {
	double balance;

	public Acc1(double balance) {
		this.balance = balance;
	}

	public boolean amtExist(double amt) {
		return balance >= amt;
	}

	public synchronized void withdraw(double amt, String name) {
		if (amtExist(amt)) {
			System.out.println(name + " is withdrawing ₹" + amt);
			balance -= amt;
			System.out.println(name + " successfully withdrew. Remaining balance: ₹" + balance);
		} else {
			System.out.println(name + " tried to withdraw ₹" + amt + " but insufficient balance!");
		}
	}
}

class Cust implements Runnable {
	String name;
	Acc1 account;
	double amount;

	public Cust(String name, Acc1 account, double amount) {
		this.name = name;
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		account.withdraw(amount, name);
	}

}

public class ThreadAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Acc1 account = new Acc1(10000);

		System.out.print("Shiv, enter amount to withdraw: ");
		double amt1 = sc.nextDouble();

		System.out.print("Sitesh, enter amount to withdraw: ");
		double amt2 = sc.nextDouble();

		Cust c1 = new Cust("Shiv", account, amt1);
		Cust c2 = new Cust("Sitesh", account, amt2);

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();

	}
}
