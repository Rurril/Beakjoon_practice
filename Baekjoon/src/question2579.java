package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2579 {
	
	static int[] points;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		points = new int[n+1];
	
		for(int i=1;i<=n;i++) {
			points[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = points[1];
		if(n>=2) dp[2] = dp[1]+ points[2];
		
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(dp[i-2] + points[i], dp[i-3] + points[i-1] + points[i]);
		}

		System.out.println(dp[n]);
	}
	
}
