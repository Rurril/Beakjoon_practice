package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		dp[0] = arr[0];
		for(int i=1;i<n;i++){
			
			if(dp[i-1] > 0)dp[i] = dp[i-1] + arr[i];
			else if(dp[i-1] <= 0) {
				dp[i] = arr[i];
			}
		}
		
		int result = -Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			result = Math.max(result,  dp[i]);
		}
		
		System.out.println(result);
		
	}
}
