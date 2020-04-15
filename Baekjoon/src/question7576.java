package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class question7576 {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int m = Integer.parseInt(temp[0]);
		int n = Integer.parseInt(temp[1]);
		Queue<Dot> q = new LinkedList();
		int[] ty = {1, -1, 0, 0};
		int[] tx = {0, 0, 1, -1};
					
		map = new int[n+2][m+2];
		
		for(int i=0;i<n+2;i++)Arrays.fill(map[i], -1); // 벽으로 꽉 채워버리기
		
		for(int i=1;i<n+1;i++) {
			temp = br.readLine().split(" ");
			for(int j=1;j<m+1;j++) {
				map[i][j] = Integer.parseInt(temp[j-1]);
				if(map[i][j] == 1)q.add(new Dot(i,j, 0));
			}
		}
		
		int cnt =0;
		while(!q.isEmpty()) {
			
			Dot a = q.poll();			
			int today = a.day;
			
			for(int i=0;i<4;i++) {
				int y = a.y + ty[i];
				int x = a.x + tx[i];
				if(map[y][x] == 0) {
					map[y][x] = 1;
					q.add(new Dot(y,x, today+1));
				}
			}
			cnt = today;
			
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j] == 0)cnt=-1;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}

class Dot{
	
	int y;
	int x;
	int day;
	Dot(int y, int x, int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
