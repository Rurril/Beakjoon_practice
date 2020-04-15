package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question9251_sub {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		int n = str1.length();
		int m = str2.length();
		br.close();
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			
			char c1 = str1.charAt(i-1);
			
			for(int j=1;j<=m;j++) {
				char c2 = str2.charAt(j-1);
				
				if(c1 == c2) // 값이 같으면 좌측 대각선 위의 값 +1.
					dp[i][j] = dp[i-1][j-1] +1;
				else // 값이 다르면 좌측(i-1) or 상단(j-1)의 값중 더 큰 값. 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
