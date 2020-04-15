package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2293 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]); 
		int k = Integer.parseInt(temp[1]); 
		int coin;
		int[] dp = new int[k+1];
		
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			coin = Integer.parseInt(br.readLine());
			for(int j = 1; j < k+1; j++) {
				if(j >= coin)
					dp[j] += dp[j - coin];
			
			}
		}
		System.out.println(dp[k]);
	}
}
