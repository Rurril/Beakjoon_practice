package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		long[][] dp = new long[k+1][n+1];
		long mod = 1000000000;
		for(int i=1;i<=k;i++) {
			
		
			
			for(int j=1;j<=n;j++) {
				
				if(i==1) {
					dp[i][j] = 1;
					continue;
				}else if(j == 1) {
					dp[i][j] = i;
					continue;
				}
				
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod;
				
			}
		}
		
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(dp[i][j] + " ");
			}System.out.println();
		}
		
		System.out.println(dp[k][n]);
		
	}
}
