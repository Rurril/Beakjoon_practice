package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2580 {
	
	static int[][] map = new int[9][9];
	static int[][] res = new int[9][9];
	static boolean find = false; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		bfs();
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(res[i][j] + " ");
			}System.out.println();
		}
	}
	
	public static void bfs() { // 스도쿠 시작~
		
		if(find)return;
		// 3가지 조건, 같은 행에서 그리고 열에서 같은 숫자가 반복되면 안된다. 
		// 마지막으로 같은 3*3 행렬에서 같은 숫자가 반복되면 안된다.
		boolean flag = true;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] == 0)flag = false;
			}
				
		}
		
//		for(int i=0;i<9;i++) {
//			for(int j=0;j<9;j++) {
//				System.out.print(map[i][j] + " ");
//			}System.out.println();
//		}
		
		if(flag) { // 0이 없다는 것이므로 완성된 것. 
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					res[i][j] = map[i][j];
				}
			}
			find = true; 
			return;
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j] == 0) {
					for(int k=1;k<=9;k++) {
						if(condition(i, j, k)) {
							map[i][j] = k;
							bfs();
							map[i][j] = 0;
						}
						
					}
				}
			}
		}
	}
	
	public static boolean condition(int y, int x, int num) {
		
		for(int i=0;i<9;i++) {
			if(map[i][x] == num)return false;
		}
		
		for(int i=0;i<9;i++) {
			if(map[y][i] == num)return false;
		}
		
		//마지막 같은 정사각형 안에서 같은 숫자가 반복되면 안됨. 
		int sy = (y/3)*3;
		int sx = (x/3)*3;
		for(int i = sy; i<sy+3;i++) {
			for(int j= sx; j<sx+3;j++) {
				if(map[i][j] == num)return false;
			}
		}
		
		return true;
	}
}
