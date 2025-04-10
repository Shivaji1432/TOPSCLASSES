package assignment1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q37ReadConsole {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter your name :");
	String name=sc.nextLine();
	System.out.println("enter detail :");
	String detail=sc.nextLine();
	FileWriter fw=null;
	BufferedWriter bw=null;
	try {
		 fw=new FileWriter("C://Users//shivs//Documents//details.txt");
	     bw=new BufferedWriter(fw);
		bw.write("name :"+name);
		bw.newLine();
		bw.write("details :"+detail);
		System.out.println("data added");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
}
