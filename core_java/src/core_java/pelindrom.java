package core_java;

public class pelindrom {
public static void main(String[] args) {
	int n=143341;
	int t=n;
	int rn=0;
	while(n!=0) {
		int rem=n%10;
		 rn=(rn*10)+rem;
		 n/=10;
		 
	}if(rn==t) {
		System.out.println("pelidrom");
	}else {
		System.out.println("not pelidrom");
	}
}
}
