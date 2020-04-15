package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2565 {
	
	static int[][] map;
	static int[][] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		map = new int[501][501];
		line = new int[n][2];
		// 교차되는 경우는 2가지 from은 작지만 to는 다른 선보다 큰 경우.
		// from 은 크지만 to는 다른 선보다 작은 경우.
		
		//다 확인하는것이 아니라 dp를 이용한다면...? 
		for(int i=0;i<n;i++) {
		
			String[] temp = br.readLine().split(" ");
			line[i][0] = Integer.parseInt(temp[0]);
			line[i][1] = Integer.parseInt(temp[1]);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)continue;
				
				if(line[i][0]>line[j][0] && line[i][1] < line[j][1]){
					map[line[i][0]][line[j][0]] = 1;
					map[line[j][0]][line[i][0]] = 1;
				}
				else if(line[i][0]<line[j][0] && line[i][1] > line[j][1]) {
					map[line[i][0]][line[j][0]] = 1;
					map[line[j][0]][line[i][0]] = 1;
				}
			}
		}
		
		
	}
	
	public static void deleteLine() {
		
	}
}
