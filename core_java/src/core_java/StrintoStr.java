package core_java;

public class StrintoStr {
public static void main(String[] args) {
	String s="hello in world";
	String []ss=s.split(" ");
	String s1="java";
	String s2="programming";
	for (int i = 0; i < ss.length; i++) {
		if(i==2) {
			System.out.print(s1+" ");
		}
		 if(i==2) {
			System.out.print(s2+" ");
		}
		System.out.print(ss[i]+" ");
	}
}
}
