package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1992 {
	
	static int[][] map;	
	static String result = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[129][129];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		split(0, 0, n);
		
		System.out.println(result);
		
		
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
			
			if(map[x][y] == 1)result += "1";
			else result += "0";
		}else {
			result += "(";
			split(x, y, size/2);
			split(x, y+size/2, size/2);
			split(x+size/2, y, size/2);
			split(x+size/2, y+size/2, size/2);
			result += ")";
		}
		
	}
}
