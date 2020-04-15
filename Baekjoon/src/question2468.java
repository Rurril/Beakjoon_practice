package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question2468 {
	
	static int[][] map;
	static int n;
	static int area =0;
	static int[] tx = {1, -1, 0, 0};
	static int[] ty = {0, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
		for(int i=0;i<=100;i++) {
			bfs(i);
		}
		System.out.println(area);
	}
	public static void bfs(int height) {
		
		boolean[][] check = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] <= height)check[i][j] = false; //물에 잠겼을 때.
				else check[i][j] = true; // 잠기지 않았을 때. 
			}
		}
		
		
		Queue<Integer> y = new LinkedList();
		Queue<Integer> x = new LinkedList();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(check[i][j]) {
					cnt++;
					y.add(i);
					x.add(j);
					 
					
					while(!y.isEmpty() && !x.isEmpty()) {											
						
						int yy = y.poll();
						int xx = x.poll();
						check[yy][xx] = false;
						
						for(int k=0;k<4;k++) {
							int ny = yy + ty[k];
							int nx = xx + tx[k];
							
							if(ny >= n || nx >= n || ny < 0 || nx < 0)continue;
							
							if(check[ny][nx]) { // 연결되어있는 안전지대일 경우.
								y.add(ny);
								x.add(nx);
								check[ny][nx] = false; // 다시 확인하는 것 막기 위함. 
							}
							
							
						}
						
					}
					
				}
			}
		}
		
		if(area < cnt)area = cnt;
		
	}
}
