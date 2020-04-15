package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11561 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long t = Long.parseLong(br.readLine());
		long[] result = new long[(int)t];
		for(int i=0;i<t;i++) {
			Long n = Long.parseLong(br.readLine()); // 징검다리의 개수.
		
			long right = 200000000l; // right의 숫자가 초과하는 경우들이 생겨서 가장 큰수를 지정해서 설정해주어야함. 
			long left = 1;
			long mid = 0;
			
			while(right >= left) { // 시그마 공식 --  x*(x+1)/2
				mid = (right+left)>>1;
//				System.out.println(left + " " + right + " " + mid);
				long target = mid*(mid+1)/2;					
				if(target <= n)left = mid+1;
				else if(target > n) right = mid-1;
			}
			
			if(n==1)result[i] = 1;
			else result[i] = right;
			
			
			
		}
		for(int i=0;i<t;i++)System.out.println(result[i]);
	}
	
	
}
