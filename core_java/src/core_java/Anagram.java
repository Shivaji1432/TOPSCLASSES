package core_java;

import java.util.Arrays;

public class Anagram {
public static void main(String[] args) {
    	String s1="mother in law";
    	String s2="hitler woman";
    	String str=s1.replaceAll(" ","");
    	String str1=s2.replaceAll(" ","");
    	char []ch=str.toCharArray();
    	char []ch1=str1.toCharArray();
    	Arrays.sort(ch);
    	Arrays.sort(ch1);
    System.out.println(ch);
    System.out.println(ch1);
    if(ch.equals(ch1)) {
    	System.out.println("it not anagram");
    }
    else {
    	System.out.println("it is anagram");
    }
}
}
