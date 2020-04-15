package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question14889 {
	
	static int n;
	static int sum = 0;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] hasTeam;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		hasTeam = new boolean[n];
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				sum += map[i][j];
			}
		}
		int[] arr = new int[n/2];
		bfs(0, n, 0, arr); // 0부터 n까지 arr에 배열에 담기.
		
		System.out.println(min);
		System.out.println(" SUM " + sum);
	}
	public static void bfs(int start, int end, int cnt, int[] arr) {
		
		if(cnt == n/2) { // 다 채우고 들어온 경우.
			
//			for(int i=0;i<n/2;i++)System.out.print(arr[i] + " ");
//			System.out.println();
			
			int score = 0;
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<n/2;j++) {
					if(i==j)continue;
					
					int x = arr[i];
					int y = arr[j];
					score += map[x][y] + map[y][x];
				}
			}
			System.out.println(score);
			
			int res = Math.abs(sum - score*2);
			if(res <= min)min = res;
			
			
		}else {
			for(int i=start;i<end;i++) {
				
				arr[cnt] = i;
				bfs(i+1, end, cnt+1, arr);
				
			}
		}
		
	}
}
