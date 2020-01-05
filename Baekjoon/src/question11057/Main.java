package question11057;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][10];
		int mod = 10007;
		
		for(int i = 0 ; i < 10; i++) { // 첫 n = 1 인 부분 모두 1로 초기화
			map[0][i] = 1;
		}
		
		for(int i = 1 ; i < n; i++) { //몇 번을 맵을 그리면서 해야되는가.
			for(int j = 0; j < 10; j++) {
				
				if(j==0) {
					map[i][j] = 1;
					continue;
				}
				map[i][j] = map[i-1][j] + map[i][j-1];
				map[i][j] = map[i][j]%mod;
			}
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			result += map[n-1][i]%mod;
		}
		
		System.out.println(result%mod);
				
	}
}
