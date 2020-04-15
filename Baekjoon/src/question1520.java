package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1520 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			
			temp = br.readLine().split(" ");
			
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int[] ty = {0, 0, 1};
		int[] tx = {1, -1, 0};
		
		dp[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				for(int k=0;k<2;k++) { // 양옆으로 움직이는 것.
					int y= i+ty[k];
					int x= j+tx[k];
					
					if(y >= n || x < 0 || x >= m)continue; //map을 벗어나는 경우.
					
					if(map[y][x] < map[i][j])dp[y][x] += dp[i][j];
					
				}
				
			}
			
			for(int j=0;j<m;j++) {
				
				for(int k=2;k<=2;k++) { // 내려가는 것. 
					int y= i+ty[k];
					int x= j+tx[k];
					
					if(y >= n || x < 0 || x > m)continue; //map을 벗어나는 경우.
					
					if(map[y][x] < map[i][j])dp[y][x] += dp[i][j];
					
				}
				
			}
		}
		
		System.out.println(dp[n-1][m-1]);
		
	}
}
