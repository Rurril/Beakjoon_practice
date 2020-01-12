package question10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int mod = 1000000000;
		int result = 0;
		
		int[] dp = new int[10];
		
		for(int i = 0; i < 10; i++) {
			dp[i] = 1;
		}
		dp[0] = 0;
		
		for(int i = 1; i < n; i++) {
			int[] temp = new int[10];
			temp[0] = (dp[1])%mod;
			temp[1] = (dp[0] + dp[2])%mod;
			temp[2] = (dp[1] + dp[3])%mod;
			temp[3] = (dp[2] + dp[4])%mod;
			temp[4] = (dp[3] + dp[5])%mod;
			temp[5] = (dp[4] + dp[6])%mod;
			temp[6] = (dp[5] + dp[7])%mod;
			temp[7] = (dp[6] + dp[8])%mod;
			temp[8] = (dp[7] + dp[9])%mod;
			temp[9] = (dp[8])%mod;
			
			dp = temp;		
		}
		
		
		for(int i = 0;i<10;i++) {
			result = (result + dp[i])%mod;
		}
		System.out.println(result%mod);
	}
	
}
