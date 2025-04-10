package assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q39ReadWrite {
public static void main(String[] args) {
	FileReader fr=null;
	FileWriter fw=null;
	try {
		fr=new FileReader("C://Users//shivs//Documents//details.txt");
		fw=new FileWriter("C://Users//shivs//Documents//copied.txt");
		int data;
		while((data=fr.read())!=-1) {
			fw.write(data);
		}System.out.println("data copied");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if (fr!=null) {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if (fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
}
}
