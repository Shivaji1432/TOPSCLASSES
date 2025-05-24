package core_java;

public class PracticeA {
public static void main(String[] args) {
//	int [] arr= {1,2,4,6,3,5};
//	int largest=arr[0];
//	int secondLargest=arr[0];
//	int thirdLargest=arr[0];
//	for (int i = 0; i < arr.length; i++) {
//		if(arr[i]>largest) {
//			thirdLargest=secondLargest;
//			secondLargest=largest;
//			largest=arr[i];
//		}else if(arr[i]>secondLargest && arr[i]!=largest) {
//			thirdLargest=secondLargest;
//			secondLargest=arr[i];
//		}else if(arr[i]>thirdLargest && secondLargest!=arr[i] && arr[i]!=largest) {
//			thirdLargest=arr[i];
//		}
//	}
//	System.out.println(largest);
//	System.out.println(secondLargest);
//	System.out.println(thirdLargest);
//	int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
//	for (int i : arr) {
//		if(i>max1) {
//			max3=max2;
//			max2=max1;
//			max1=i;
//		}else if(i>max2) {
//			max3=max2;
//			max2=i;
//		}else if(i>max3) {
//			max3=i;
//		}
//	}
//	System.out.println(max1+"*"+max2+"*"+max3+"*");
//	int prouduct=max1*max2*max3;
//	System.out.println(prouduct);
	int b[]= {0,1,0,1,1,0,0,0,1,1,1,1};
//	int maxCount=0;
//	int count=0;
//	for (int i = 0; i < b.length; i++) {
//		if(b[i]==0) {
//			count++;
//			maxCount=Math.max(maxCount, count);
//			}else {
//				count=0;
//			}
//	}System.out.println("consecutive 0's : "+maxCount);
//	for (int i = 0; i < b.length; i++) {
//		if(b[i]==1) {
//			count++;
//			maxCount=Math.max(maxCount, count);
//		}else {
//			count=0;
//		}
//	}System.out.println("consecutive 1's : "+maxCount);
//	int j=0;
//	for (int i = 0; i < b.length; i++) {
//		if(b[i]!=0) {
//			int temp=b[i];
//			b[i]=b[j];
//			b[j]=temp;
//			j++;
//		}
//	}
//	for (int i = 0; i < b.length; i++) {
//		System.out.print(b[i]);
//	}
//	int j=b.length-1;
//	for (int i = b.length-1;i > 0; i--) {
//		if(b[i]!=0) {
//			int temp=b[i];
//			b[i]=b[j];
//			b[j]=temp;
//			j--;
//		}
//	}
//	for (int i = 0; i < b.length; i++) {
//		System.out.print(b[i]);
//	}
	
}
}
