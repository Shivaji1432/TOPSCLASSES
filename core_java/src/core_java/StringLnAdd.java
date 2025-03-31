package core_java;

public class StringLnAdd {
public static void main(String[] args) {
	String s="this is very popular thing.\nyes it is popular.";
	System.out.println(s);//\n for print new line.
	System.out.println("..................................................");
	String s1=s.concat("\ni want this now");
	System.out.println(s1);//for add character to strings 
	System.out.println("..................................................");
	String [] s2=s.split(" ");
	for (int i = 0; i < s2.length; i++) {
		System.out.print(s2[i]);//string to strings array or split string
	}
}
}
