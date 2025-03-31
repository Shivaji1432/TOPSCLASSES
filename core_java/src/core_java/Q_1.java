package core_java;

public class Q_1 {
public static void main(String[] args) {
	for(int i=100;i<=999;i++) {
	int n=i;
	int temp=n;
	int sum=0;
	while(n!=0) {
		int rem=n%10;
		sum=sum+(rem*rem*rem);
		n/=10;
	}if(sum==temp) {
		System.out.println("this is ArmStrong: "+temp);
	}else {
		//System.out.println("this is not ArmStrong: "+temp);
	}
	}
}
}
