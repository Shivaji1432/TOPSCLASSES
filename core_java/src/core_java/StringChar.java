package core_java;

public class StringChar {
public static void main(String[] args) {
	String s="shivshankae";
//	char ch[]=s.toCharArray();
	for (int i = 0; i < s.length(); i++) {
		if(s.charAt(i)=='s') {
			String ch="r";
			System.out.print(ch);
		}else if(s.charAt(i)=='h'){
			String ch1="o";
			System.out.print(ch1);
		}else {
			System.out.print(s.charAt(i));
		}
	}
}
}
