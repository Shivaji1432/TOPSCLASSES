package core_java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FilesTest {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String name=sc.next();
	String email=sc.next();

	FileOutputStream f=null;
	try {
		f=new FileOutputStream("C:\\Users\\shivs\\Documents\\"+name+".txt");
		byte[]b=email.getBytes();
		f.write(b);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
