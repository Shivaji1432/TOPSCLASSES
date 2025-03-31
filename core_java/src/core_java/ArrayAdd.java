package core_java;

public class ArrayAdd {
public static void main(String[] args) {
	int a[]= {10,20,50,30,70};
	int sum=0;
	int avg=0;
	int min=a[0];
	int max=a[0];
	for(int i=0;i<a.length;i++) {
		System.out.println(a[i]);
		 sum+=a[i];
		 avg=sum/a.length;
		 if(a[i]>max) {
			 max=a[i];
		 }else if(a[i]<min) {
			 min=a[i];
		 }
	}System.out.println(sum);
	System.out.println(avg);
	System.out.println(max);
	System.out.println(min);
}
}
