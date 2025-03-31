package core_java;
public class Q_5 {
public static void main(String[] args) {
	for(int j=1;j<=100;j++) {
	int n=j;
	int temp=n;
	int rn=0;
	 for (int i = 1; i <= n ; i++) {
		 int rem=n%10;
		 rn=(rn*10)+rem;
		 n/=10;
	}if(rn==temp) {
		System.out.println(temp+"pelindrom");
	}else {
		System.out.println(temp+"not pelindrom");
	}
}
}
}
