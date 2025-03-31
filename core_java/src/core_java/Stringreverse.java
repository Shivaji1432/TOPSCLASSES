package core_java;

public class Stringreverse {
public static void main(String[] args) {
	String s="this is human rights";
	String s1="";
	for(int i=s.length()-1;i>=0;i--) {
		s1+=s.charAt(i);
	}System.out.println(s1);
	if(s==s1) {
		System.out.println("palindrom");
	}else {
		System.out.println("not a palindrom");
	}
}
}
