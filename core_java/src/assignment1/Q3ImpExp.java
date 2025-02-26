package assignment1;

public class Q3ImpExp {
public static void main(String[] args) {
	int a=10;   
	long l=a; //int=4byte into long=8byte 
	System.out.println("this is implicit "+l);
	int a1=10;          
	short s=(short)a1;  //int=4byte into shor=2byte
	System.out.println("this is explict"+s);
	int b1=1275;          
	byte b=(byte)b1;  //int=4byte into byte=1byte
	System.out.println("this is explict"+b);

}
}
