package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question1699 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[100001];
		Arrays.fill(dp, 100000);
		
		for(int i=1;i<=n;i++) {
			if(i*i<=100000)dp[i*i] = 1;
			
			if(dp[i] ==1)continue;
			
			for(int j=1;j<=i/2;j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
			}
		}
		
		System.out.println(dp[n]);
		
		
		
		
		
	}
	
}