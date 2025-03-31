package core_java;

public class Stringtype {
public static void main(String[] args) {
	String s1="Sun Rises in East";
	char[] ch=s1.toCharArray();
	for (int i = ch.length-1; i >= 0; i--) {
		System.out.print(ch[i]);
	}System.out.println();
	String[] s=s1.split(" ");
     
	for (int i = s.length-1; i >= 0; i--) {
		System.out.print(s[i]);
		System.out.print(" ");
	}System.out.println();
	for (int i = 0; i < s.length; i++) {
		char []ch1=s[i].toCharArray();
		for (int j = ch1.length-1; j >= 0; j--) {
			System.out.print(ch1[j]);
		}System.out.print(" ");
	}System.out.println();
	
	String temp=s[0];
	s[0]=s[s.length-1];
	s[s.length-1]=temp;
	for (int i = 0; i < s.length; i++) {
		System.out.print(s[i]+" ");
	}
	
	
	
	
}
}
