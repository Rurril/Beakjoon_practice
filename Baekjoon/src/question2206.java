package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question2206 {
	
	static int[][] map;
	static int[][] visit;
	static int[] tx = {1, -1, 0, 0};
	static int[] ty = {0, 0, 1, -1};
	static int n, m, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		map = new int[n][m];
		visit = new int[n][m];		
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				visit[i][j] = Integer.MAX_VALUE; // 아직 가지 않은 것을 확인.
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		bfs(0,0); //0,0에서 시작. 
		if(ans == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(ans);
		
	}
	public static void bfs(int y, int x) {
		Queue<D1> q = new LinkedList();
		q.add(new D1(0, 0, 1, 0)); // y, x, 날짜, 벽부순 횟수. 
		visit[y][x] = 0;
		
		while(!q.isEmpty()) {
			D1 dot = q.poll();			
			
			//도착지점 종료. 
			if(dot.y == n-1 && dot.x == m-1) {
				ans = dot.day;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int ny = dot.y + ty[i];
				int nx = dot.x + tx[i];				
				
				if(y >= m || y <0 || x < 0 || x >= n)continue;
				
				if(visit[y][x] <= dot.bWall)continue;
				
				if(map[ny][nx] == 0) { //벽이 아닐때.
				
					visit[ny][nx] = dot.bWall;
					q.add(new D1(ny, nx, dot.day+1, dot.bWall));					
				}else { // 벽일 때.
					if(dot.bWall == 0) {
						visit[ny][nx] = dot.bWall+1;
						q.add(new D1(ny, nx, dot.day+1, dot.bWall+1));
					}
				}
				
			}
			
		}
	}
}
class D1{
	
	int x, y, day; // x,y 좌표, 날짜, 거리
	int bWall; // 벽 부순것.
	
	D1(int x, int y, int day, int bWall){
		this.x = x;
		this.y = y;
		this.day = day;		 
		this.bWall = bWall; // 벽부순횟수.  
	}
}
