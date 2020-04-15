package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question9663 {
	
	static int n;
	static int[][] map;
	static int[] tx = {1, 1, -1, -1};
	static int[] ty = {1, -1, 1, -1};
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		pos(n);
		
		System.out.println(count);
		
	}
	public static void pos(int num) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 0) { // 0이 아니라면 놓을 수 없음. 
					queenOn(i,j);
					pos(num-1);
					queenOff(i,j);
					
					if(num == 1)count++; // 마지막 1개를 놓을 수 있다면 카운팅. 
					
				}
			}
		}
		
	}
	public static void queenOn(int y, int x) {
		for(int i=0;i<n;i++) {
			map[y][i]++;  // 곂치면 숫자가 올라가지만 0이 아닌이상 그 자리에 둘 수 없다는 것. 
			map[i][x]++;
		}
		
		map[y][x]--; //곂치는 부분 을 위해서 1을 뺌. 
		
		for(int i=0;i<4;i++) {
			
			int ny = y+ty[i];
			int nx = x+tx[i];
			while(ny > -1 && nx > -1 && nx < n && ny < n) { // 맵 바깥으로 벗어나면 끝. 
				map[ny][nx]++;				
				ny += ty[i];
				nx += tx[i];				
			}
		}
	}
	public static void queenOff(int y, int x) {
		for(int i=0;i<n;i++) {
			map[y][i]--;
			map[i][x]--;
		}
		
		map[y][x]++;
		
		for(int i=0;i<4;i++) {
			
			int ny = y+ty[i];
			int nx = x+tx[i];
			while(ny > -1 && nx > -1 && nx < n && ny < n) { // 맵 바깥으로 벗어나면 끝. 
				map[ny][nx]--;
				
				ny += ty[i];
				nx += tx[i];				
			}
		}
	}
}
