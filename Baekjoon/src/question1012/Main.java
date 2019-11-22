package question1012;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	
	static int[][] map;
	static int bugs;
	static int[] count;
	static boolean[][] pass;
	static int[] mx = {1, -1, 0, 0};
	static int[] my = {0, 0, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		count = new int[testcase];
		
		for(int i =0; i< testcase; i++) {
			
			String[] temp = br.readLine().split(" ");
			int row = Integer.parseInt(temp[0]);
			int col = Integer.parseInt(temp[1]);
			int t_count = 0;
			map = new int[row][col];
			pass = new boolean[row][col];
			
			bugs = Integer.parseInt(temp[2]);
			
			
			for(int j = 0; j < bugs; j++) {
				
				String[] temp2 = br.readLine().split(" ");
				int x = Integer.parseInt(temp2[0]);
				int y = Integer.parseInt(temp2[1]);
				
				map[x][y] = 1;								
			}
			//여기까지가 맵에 배추 심는 작업 완료. 
			
			for(int j =0; j < map.length; j++) {
				for(int k = 0; k < map[0].length; k++) {
					if(!pass[j][k] && map[j][k] == 1) {
						t_count++;
						dfs(j, k);
					}
				}
			}
			
			count[i] = t_count;					
		}
		
		for(int i =0; i < testcase; i++) {
			System.out.println(count[i]);
		}
	}
	
	public static void dfs(int y, int x) {
		
		pass[y][x] = true;
		
		for(int i =0; i < 4; i++) {
			
			int ty = y + my[i];
			int tx = x + mx[i];
			
			if(ty == -1 || tx == -1 || ty == map.length || tx == map[0].length)continue;
			
			if(!pass[ty][tx] && map[ty][tx] == 1)dfs(ty,tx);
		}
		
	}
	
	
}
