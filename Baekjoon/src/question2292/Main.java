package question2292;


import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//대충 1억 6천 
		int[] list = new int[100000];
		
		for(int i = 0; i < list.length; i++) {
			if(i == 0) {
				list[0] = 0;
				continue;
			}
			list[i] = i+ list[i-1];
		}
		
		int n = sc.nextInt();
		
		int count = 0;
		while(true) {
			if((list[count]*6) +1 < n)count++;
			else {
				// TODO
				// 논리는 정해졌는데, 그 이후로 하는게 쉽지 않네. 천천히 생각해야할 부분인듯.
				
			}
		}
		
	}
	
}
