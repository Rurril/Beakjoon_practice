package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question14627 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int s = Integer.parseInt(temp[0]); // 사온 파의 개수.
		int c = Integer.parseInt(temp[1]); // 주문 받은 파닭의 개수.
		long[] length = new long[s];
		
		for(int i=0;i<s;i++)length[i] = Long.parseLong(br.readLine());
		//TODO
		
		long left = 1;
		long right = 1000000000l;
		
				
		while(right>= left) {
			
			long mid = (left+right)>>1;
			long count = 0;
			for(int i=0;i<s;i++) {
				count += length[i]/mid;
			}
			
//			System.out.println(left + " " + right + " "  + mid + " "+count);
			
			if(count < c)right = mid-1; // 길이가 길어서 파의 개수가 모자라므로 길이를 줄인다.
			else if(count >= c)left = mid+1;
			
		}
				
		
		long ramen = 0;
		for(int i=0;i<s;i++) {
			ramen += length[i];
		}
		
		ramen = ramen - right*c;
		
		System.out.println(ramen);
		// 구하는 것은 일정하게 파닭에 파를 넣고서 남은 파의 길이. 
		
	
		
		
	}
}	
