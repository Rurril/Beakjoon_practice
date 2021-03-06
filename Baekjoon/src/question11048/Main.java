package question11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main { // 이동하기 
	public static void main(String[] args) throws NumberFormatException, IOException { 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 미로의 크기 N 
		int M = Integer.parseInt(br.readLine()); // 미로의 크기 M 
		int[][] maps = new int[N+1][M+1]; 
		int[][] dp = new int[N+1][M+1]; 
		
		for(int x = 1; x <= N; x++) { //맵에 적힌 사탕대로 넣어준다.
			for(int y = 1; y <= M; y++) { 
				maps[x][y] = Integer.parseInt(br.readLine());  
			} 
		} 
		
		for(int x = 1; x <= N; x++) { 
			for(int y = 1; y <= M; y++) { // 좌측, 상단의 DP값 중 더 큰값에 현재의 사탕개수를 더하여 DP값에 저장 
				dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]) + maps[x][y]; 
				} 
			}
		
		System.out.println(dp[N][M]); 
		}
	}


