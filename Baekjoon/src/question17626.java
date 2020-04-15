package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question17626 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[50001]; // 몇개의 제곱수로 이루어질 수 있는가. 		
		for(int i=1;i<=223;i++) {
			dp[i*i] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			if(dp[i] == 1)continue;
			// n - i^2 = m이라고 하면
			// dp[m]이 가장 작은 것에 +1 값을 한 것이 dp[n]이 되는 것. 
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				int temp = i - j*j;
				min = Math.min(min, dp[temp]);
			}
			
			dp[i] = min+1;
			
		}
		
		
		
		
		System.out.println(dp[n]);
	}
}
