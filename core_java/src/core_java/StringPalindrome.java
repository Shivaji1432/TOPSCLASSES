package core_java;

public class StringPalindrome {
	public static void main(String[] args) {
		String s = "popo";
		char[] ch = s.toCharArray();
		char ch1 = 0, ch2 = 0;
		for (int i = 0; i < ch.length; i++) {
			ch1 = ch[i];
		}
		for (int i = ch.length - 1; i >= 0; i--) {
			ch2 = ch[i];
		}
		if (ch1 == ch2) {
			System.out.println("palindrom");
		} else {
			System.out.println("not palindrom");
		}
	}
}
