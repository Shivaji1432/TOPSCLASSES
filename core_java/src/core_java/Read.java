package core_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Read {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String name=sc.next();


	FileInputStream fi=null;
	try {
		fi=new FileInputStream("C:\\Users\\shivs\\Documents\\"+name+".txt");
		int i=fi.read();
		while(i!=-1) {
			char c=(char)i;
		System.out.print(c);
		i=fi.read();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
