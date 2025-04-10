package assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q32ReadWrite {
public static void main(String[] args) {
	FileReader fr=null;
	FileWriter fw=null;
	try {
		fr=new FileReader("C://Users//shivs//Documents//home.txt");
		int i=fr.read();
		while(i!=-1) {
			char c=(char) i;
			System.out.print(c);
			i=fr.read();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		fw=new FileWriter("C://Users//shivs//Documents//home.txt");
		String s="welcome to my java world";
		fw.write(s);
		fw.flush();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
