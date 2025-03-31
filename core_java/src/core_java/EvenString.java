package core_java;

public class EvenString {
public static void main(String[] args) {
	String s="hariom is very popular in among dalit";
	String[]s1=s.split(" ");
	for (int i = 0; i < s1.length; i++) {
		if(s1[i].length() % 2==0) {
			System.out.print(s1[i]+" even length");
			System.out.println();
	}else{
			System.out.print(s1[i]+" odd length");
			System.out.println();
		}
	}
}
}
