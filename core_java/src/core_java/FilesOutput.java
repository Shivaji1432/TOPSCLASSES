package core_java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesOutput {
public static void main(String[] args) {
	FileOutputStream fos=null;
	try {
		fos= new FileOutputStream("C:\\Users\\shivs\\Documents\\home.txt");
		String s="hello java, hello world";
		byte[] b=s.getBytes();
		fos.write(b);
	} catch(IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(fos!=null) {
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
