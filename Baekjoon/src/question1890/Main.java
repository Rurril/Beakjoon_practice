package question1890;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+1][n+1];
		long[][] dp = new long[n+1][n+1];
		dp[1][1] = 1;
		
		String str[];
	    for (int i = 1; i <= n; i++) {
	    		str = br.readLine().split(" ");
	    		for (int j = 1; j <= n; j++) {
	    			map[i][j] = Integer.parseInt(str[j-1]);
	    		}
	    	}
		
		
		for(int i=1; i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(dp[i][j] == 0)continue; // 오기 불가능한 곳이라면 넘긴다.
				if(i==n&&j==n)continue; // 끝에 도착하면 멈춘다.
				
				int jump = map[i][j];
				if(j+jump <= n) {
					dp[i][j+jump] += dp[i][j];			
				}
				if(i+jump <= n) {
					dp[i+jump][j] += dp[i][j];
									
				}
//				System.out.println(dp[n][n]);
			}
		}
		
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(dp[n][n]);
	}
}
