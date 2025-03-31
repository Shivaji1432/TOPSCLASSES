package core_java;

import java.io.File;
import java.io.IOException;

public class FileClassMet {
public static void main(String[] args) {
	File f=new File("C:\\Users\\shivs\\Documents\\alpha.txt");
	System.out.println(f.exists());
	if(f.exists()) {
		System.out.println("class found");
		f.delete();
	}else {
		System.out.println("class not found");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
