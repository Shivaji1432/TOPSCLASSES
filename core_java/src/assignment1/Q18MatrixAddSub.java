package assignment1;

public class Q18MatrixAddSub {
public static void main(String[] args) {
	int a[][]= {{12,13,10},{12,10,10},{14,15,25}};
	int b[][]= {{12,13,10},{12,10,90},{45,14,15}};
	int[][] result =new int[3][3];
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < b.length; j++) {
			 result[i][j]=a[i][j]-b[i][j];
	
		}
	}System.out.println("matric substraction");
	for (int i = 0; i < result.length; i++) {
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[i][j]+" ");
		}System.out.println();
	}System.out.println("matrix addition");
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < b[0].length; j++) {
			
			 result[i][j]=a[i][j]+b[i][j];
			
		}
	}
	for (int i = 0; i < result.length; i++) {
		for (int j = 0; j < result[i].length; j++) {
			System.out.print(result[i][j]+" ");
		}System.out.println();
	}
	
}
}
