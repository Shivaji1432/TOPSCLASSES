package core_java;

public class Prime {
public static void main(String[] args) {
	System.out.println("hello");
	for(int j=3;j<=100;j++) {
	int n=j;
	int flag=0;
	for(int i=2;i<n;i++) {
		if(n%i==0) {
			flag=1;
			break;
			
		}
		}
	if(flag==0) {
		System.out.println(n+"prime");
		
	}}
}
}
