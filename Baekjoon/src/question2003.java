package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2003 {
	public static void main(String[] arg) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		long m = Long.parseLong(temp[1]);
		long[] sumArr = new long[n+1];
		
		temp = br.readLine().split(" ");
		
		for(int i=1;i<=n;i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(temp[i-1]); // 부분합 배열을 완성시켜놓음. 
		}
		
		int left =1;
		int right =1;
		long cnt = 0;
		
		while(left <= n && right <= n) {
			
			// left == right 인데, m보다 크거나 작은 경우. 예외를 생각해야함. 
			if(left == right && sumArr[right] - sumArr[left-1] > m)right++;
			
			if(sumArr[right] - sumArr[left-1] == m) {
				cnt++;
				right++;
			}else if(sumArr[right] - sumArr[left-1] > m) { // m보다 크다면 left를 늘려서 합을 줄여야함.
				left++; 
			}else if(sumArr[right] - sumArr[left-1] < m) { // m보다 작다면 right를 늘려서 합을 늘려야함. 
				right++;
			}
			
		}
		System.out.println(cnt);
		
		
		
		
	}
}
