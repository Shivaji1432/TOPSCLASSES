package core_java;

import java.io.FileInputStream;
import java.io.IOException;

public class FilesInput {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\shivs\\Documents\\home.txt");
			int i = fis.read();
			while (i != -1) {
				char c = (char) i;
				System.out.print(c);
				i = fis.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
