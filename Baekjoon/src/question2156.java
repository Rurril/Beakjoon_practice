package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			p[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = p[1];
		
		if(n>=2)dp[2] = p[2] + dp[1];
						
		for(int i=3;i<=n;i++) {
			
			dp[i] = Math.max(dp[i-1], Math.max(p[i] + dp[i-2], p[i]+p[i-1] + dp[i-3]));
		}
		
		int max = 0;
		for(int i=1;i<=n;i++) {		
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}
}
