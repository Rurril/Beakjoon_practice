package question2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] check;
	static int[] tx = {1, -1, 0, 0};
	static int[] ty = {0, 0, 1, -1};
	static int max; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		max = n*m;
		
		map = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String[] temp2 = br.readLine().split("");
			for(int j=0;j<temp2.length;j++) {
				map[i][j] = Integer.parseInt(temp2[j]);
			}
		}
		
		dfs(0, 0, 1);
		
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int depth) {
		
		check[x][y] = true; // 왔다갔다는 것을 의미.
		
		
		for(int i=0; i<4;i++) {
			int x2 = x;
			int y2 = y;
						
			x2 += tx[i];
			y2 += ty[i];
			
			
			if(x2 == -1 || y2 == -1 || x2 == n || y2 == m)continue;
			if(check[x2][y2])continue; // 들린 곳이면 continue;
			if(map[x2][y2] == 0)continue; // 올 수 없는 곳이므로 continue;
			
			if(x2==n-1&& y2==m-1) {
				if(depth < max)max = depth+1;
				continue;
			}
			
			dfs(x2, y2, depth+1);
			
		}
		check[x][y] = false;
		
	}
}
