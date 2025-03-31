package core_java;

public class MultiArray {
public static void main(String[] args) {
	int arr[][]= {{10,20,30},{15,25,35},{20,40,60}};
	int ar[][]= {{1,2,3},{15,25,35},{2,4,6}};
	
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			System.out.print(arr[i][j]+ar[i][j]+" ");
			
		}System.out.println();
		
	}
}
}
