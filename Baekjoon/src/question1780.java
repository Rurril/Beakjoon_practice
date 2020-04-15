package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1780 {
	
	static int[][] map;
	static int zero = 0;
	static int minus = 0;
	static int plus = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		split(0, 0, n);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
		
		
	}
	public static void split(int x, int y, int size) {
		
		boolean flag = true;
		loop:
		for(int i = 0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(map[x][y] != map[x+i][y+j]) {
					flag = false;
					break loop; //2중 포문을 빠져나오는 방법. 
				}
			}
		}
		
		if(flag) {
//			System.out.println(x + " " + y + " " + size + " map : " + map[x][y]);
			
			if(map[x][y] == 1)plus++;
			else if(map[x][y] == 0)zero++;
			else minus++;
		}else {
			// 총 9등분해서 진행. 
			split(x, y, size/3);
			split(x, y+size/3, size/3);
			split(x, y+(size*2)/3, size/3);
			split(x+size/3, y, size/3);
			split(x+size/3, y+size/3, size/3);
			split(x+size/3, y+(size*2)/3, size/3);
			split(x+(size*2)/3, y, size/3);
			split(x+(size*2)/3, y+size/3, size/3);
			split(x+(size*2)/3, y+(size*2)/3, size/3);
		}
		
	}
}
