package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question3079 {
	
	static long n,m;
	static long[] times;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Long.parseLong(temp[0]);
		m = Long.parseLong(temp[1]);
		
		
		times = new long[(int)n];
		
		for(int i=0;i<n;i++)times[i] = Long.parseLong(br.readLine());
		
		long left = 1;
		long right = Long.MAX_VALUE;
		long mid = 0;
		long ans = right;
		
		while(right >= left) {
			
			mid = (right + left)/2; // 걸리는 시간 세팅
			long cnt = 0; // 통과하는 사람의 숫자. m보다 같거나 많게 되어야 맞다.
			
			
			if(isPossible(mid)) {
				ans = Math.min(ans,  mid);
				right = mid-1;
			}
			else left = mid+1; 
			
		}
		System.out.println(ans);
		
	}
	private static boolean isPossible(long mid) {
		long cnt = 0; // 통과하는 사람의 숫자. m보다 같거나 많게 되어야 맞다.
		
		for(int i=0;i<n;i++) {
			
//			if(mid < times[i])continue;
			cnt += mid / times[i];
		
		}
		return cnt >= m;
	}
}
