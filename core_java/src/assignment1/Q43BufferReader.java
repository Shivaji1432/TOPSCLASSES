package assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q43BufferReader {
public static void main(String[] args) {
	FileReader fr=null;
	BufferedReader br=null;
	try {
		fr=new FileReader("C://Users//shivs//Documents//home.txt");
		br=new BufferedReader(fr);
		/*int b=br.read();
		while(b!=-1) {
			char c=(char) b;
			System.out.print(c);
			b=br.read();
		}*/
		String str;
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
