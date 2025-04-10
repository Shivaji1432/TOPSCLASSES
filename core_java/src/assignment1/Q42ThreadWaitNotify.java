package assignment1;

import java.util.Scanner;

class Paytm1 {
	double wallet;

	public Paytm1(double wallet) {
		this.wallet = wallet;
	}

	public boolean isamtexist(double amt) {
		boolean b = false;
		if (wallet >= amt) {
			b = true;
		}
		return b;
	}

	public void debit(double amt) throws InterruptedException {
		while (wallet < amt) {
			System.out.println("Insufficient balance. Waiting for deposit...");
			wait();
		}

		wallet -= amt;
		System.out.println("debit amount : " + amt + " remaining wallet : " + wallet);
		notifyAll();
	}

	public void credit(double amt) {
		wallet += amt;
		System.out.println("credit amount : " + amt + " remaining wallet : " + wallet);
		notifyAll();
	}
}

class User1 extends Thread {
	String username;
	Paytm1 paytm1;
	boolean isdebit;

	public User1(String username, Paytm1 paytm1, boolean isdebit) {
		this.username = username;
		this.paytm1 = paytm1;
		this.isdebit = isdebit;
	}

	@Override
	public void run() {
		synchronized (paytm1) {
		Scanner sc = new Scanner(System.in);
		System.out.println(username + " : enter amount");
		double amt = sc.nextDouble();
		if (isdebit) {
			try {
				paytm1.debit(amt);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		} else {
			paytm1.credit(amt);
		}
	}
}
}
public class Q42ThreadWaitNotify {
	public static void main(String[] args) {
		Paytm1 paytm1 = new Paytm1(1000);
		User1 user1 = new User1("shiv", paytm1, true);
		User1 user2 = new User1("sitesh", paytm1, false);
		user1.start();
		user2.start();
	}
}
