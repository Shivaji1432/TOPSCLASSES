package core_java;

public class Array2d {
public static void main(String[] args) {
	int [][]a= {{10,20,30},{11,22,33},{12,23,34}};
	int [][]b= {{20,30,40},{21,32,43},{52,63,74}};
	for (int i = 0; i < b.length; i++) {
		for (int j = 0; j < b.length; j++) {
			System.out.print(b[i][j]+" ");
		
		}	System.out.println("");
	}
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[i][j]+" ");
			
		}	System.out.println("");
	}
	int [][]result=new int[a.length][b.length];
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < b.length; j++) 
				result[i][j]=a[i][j]+b[i][j];
			
		}
	for (int i = 0; i < result.length; i++) {
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[i][j]+" ");
		}System.out.println();
	}
}
}
