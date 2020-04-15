package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question14503 {
	
	static int n,m;
	static int[][] map;
	static int[][] isClean;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]); //행의 길이.
		m = Integer.parseInt(temp[1]); //렬의 길이.
		map = new int[n+2][m+2];
		isClean = new int[n+2][m+2];
		temp = br.readLine().split(" ");
		
		int y = Integer.parseInt(temp[0]) +1;
		int x = Integer.parseInt(temp[1]) +1;
		int d = Integer.parseInt(temp[2]); // 방향.
		
		for(int i=0;i<map.length;i++)Arrays.fill(map[i], 1);
		for(int i=0;i<isClean.length;i++)Arrays.fill(isClean[i], 1);
				
		
		
		
		for(int i=1;i<=n;i++) { // 1은 벽이고 0은 빈칸. 
			temp = br.readLine().split(" ");
			for(int j=1;j<=m;j++) {
				map[i][j] = Integer.parseInt(temp[j-1]);
				isClean[i][j] = 0;
				
				if(map[i][j] == 1)isClean[i][j] = 1; // 벽이거나 깨끗함을 확인한다. 
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
		
		int count =0;
		while(true) { // 시뮬레이션 스타트.
			
//			System.out.println(y + " " + x + " " + count);
			
			
			if(isClean[y][x] == 0) {
				isClean[y][x] = 1;
				count++;				
			}
			// 북쪽 : 0 동쪽 : 1 남쪽 : 2 서쪽 : 3
			int ty = 0; 
			int tx = 0;
			if(d==0) {
				ty = y;
				tx = x-1;
			}else if(d==1) {
				ty = y-1;
				tx = x;
			}else if(d==2) {
				ty = y;
				tx = x+1;
			}else if(d==3) {
				ty = y+1;
				tx = x;
			}
			
			if(isClean[ty][tx] == 0) {// 벽이 아니거나 깨끗하지 않은 경우 2-a.				
				d = (d+3)%4; // 방향 전환. 
				y = ty;
				x = tx; // 그 위치로 방향과 위치를 바꾸고 1로 돌아감. 
				continue;
			}else if(isClean[y+1][x] == 1 && isClean[y-1][x] ==1 
					&& isClean[y][x+1] == 1 && isClean[y][x-1] == 1) { 
				// 네 방향 모도 청소를 완료했거나 벽인 경우 2-c. -- 뒤로 이동 or 2-d.
				if(d==0) {
					ty = y-1;
					tx = x;
				}else if(d==1) {
					ty = y;
					tx = x+1;
				}else if(d==2) {
					ty = y+1;
					tx = x;
				}else if(d==3) {
					ty = y;
					tx = x-1;
				}

				if(map[ty][tx] == 1) { // + 뒤에가 벽인 경우. 2-d. -- 작동 중지. 
					break;
				}else {
					y = ty;
					x = tx;
					continue;
				}
			}else if(isClean[ty][tx] == 1) { // 그 위치에 공간이 없는 경우 2-b.
				d = (d+3)%4; // 방향 전환.		
				continue;
			}else {
//				for(int i=1;i<=n;i++) {
//					for(int j=1;j<=m;j++) {
//						System.out.print(map[i][j]);
//					}System.out.println();
//				}
//				for(int i=1;i<=n;i++) {
//					for(int j=1;j<=m;j++) {
//						System.out.print(isClean[i][j]);
//					}System.out.println();
//				}
//				break;
				System.out.println("여기 들어와버림.");
				break;
			}
			
			
			
			
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				System.out.print(isClean[i][j] + " ");
			}System.out.println();
		}
		
		System.out.println(count);
		
		
	}
}
