package assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q38Filecopyio {
public static void main(String[] args) {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	try {
		fis=new FileInputStream("C://Users//shivs//Documents//details.txt");
		fos=new FileOutputStream("C://Users//shivs//Documents//shiv.txt");
		int data;
		while((data=fis.read())!=-1) {
			fos.write(data);
		}
		System.out.println("data copied");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(fos!=null) {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
}
