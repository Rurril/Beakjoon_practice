package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question9663_sub {
	static int n;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 각 행에는 하나의 열에만 퀸이 놓여질 수 있다. 
		// 1 열부터 N열까지 돌면서 각 1행 N열에 퀸을 놓았을때 가능한 경우를 확인하다. 
		
		for(int i=1;i<=n;i++) {
			int[] col = new int[n+1]; // n * n 행렬이기에 열도 인덱스를 n까지 갖을 수 있게 한다. 
			
			// 1행 i열에 퀸을 놓았다. 
			col[1] = i;
			// 1행 i열에 퀸을 놓았을 경우 가능한 횟수를 dfs로 구한다.
			dfs(col, 1);				
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int[] col, int row) {
		if(row == n) {
			count++;
		}else {
			// 1열 부터 N 열까지 반복하면서 (row+1, i)에 퀸을 놓을 수 있는 경우가 있는지 확인한다.
			// 있으면 다음행의 dfs를 호출한다.
			for(int i = 1; i <= n; i++) {
				col[row+1] = i;
				if(isPossible(col, row+1)) {
					dfs(col, row+1);
				}
			}						
		}
	}
	
	public static boolean isPossible(int[] col, int row) {
		// 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
		
		for(int i=1; i<row;i++) {
			// i행과 row 행의 열 값이 같으면 퀸을 놓을 수 없다.
			if(col[i] == col[row]) return false;
			
			// i행과 row 행의 열 값이 대각선에 위치하는 절대값이면 안된다.
			if(Math.abs(i - row) == Math.abs(col[i] - col[row]))return false;
			// 대각선의 정의를 abs(row1 - row2) == asb(col1 - col2) 로 간단하게 끝내버렸다... 와우. 
		}
		return true; 
	}
	
}
