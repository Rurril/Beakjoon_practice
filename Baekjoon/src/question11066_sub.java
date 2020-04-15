package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11066_sub {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		int[] values;
		int[] sums;
		int[] results = new int[testCase];
		int[][] dp;
		
		for(int t=0;t<testCase;t++) {
			int n = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split(" ");
			
			values = new int[n+1];
			sums = new int[n+1];
			dp = new int[n+2][n+2];
			
			for(int i=1;i<=n;i++) {
				sums[i] = sums[i-1] + values[i];
			}
			
			for(int i=2;i<=n;i++) {
				for(int j=i-1;j>0;j--) {
					
					dp[j][i] = Integer.MAX_VALUE;
					
					for(int k=j;k<=i;k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i] + sums[i] - sums[j-1]);	
					}
					
					
				}
			}		
			results[t] = dp[1][n]; 
		}
		
		for(int i=0;i<testCase;i++) {
			System.out.println(results[i]);
		}
	}
}
