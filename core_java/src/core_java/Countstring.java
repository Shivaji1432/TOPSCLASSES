package core_java;

import java.util.Scanner;

public class Countstring extends Animals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "hello java hello python";
		String user = sc.nextLine();
		String user1 = sc.nextLine();
		String user2 = sc.nextLine();
		sc.close();
		String[] s1 = s.split(" ");
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < s1.length; i++) {
			if (s1[i].equals(user)) {
				count++;
			} else if (s1[i].equals(user1)) {
				count1++;
			} else if (s1[i].equals(user2)) {
				count2++;
			} else {
				System.out.print(s1[i]);

			}
		}
		System.out.println(s);
		System.out.println(user + " " + count);
		System.out.println(user1 + " " + count1);
		System.out.println(user2 + " " + count2);
	}
}
