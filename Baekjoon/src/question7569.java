package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class question7569 {
	
	static int m,n,h;
	static int[][][] map;
	static int[] tx = {1, -1, 0, 0, 0, 0};
	static int[] ty = {0, 0, 1, -1, 0, 0};
	static int[] tz = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[1]);
		int m = Integer.parseInt(temp[0]);
		int h = Integer.parseInt(temp[2]);
		
		map = new int[n+2][m+2][h+2];
		
		for(int i=0;i<n+2;i++) {
			for(int j=0;j<m+2;j++) {				
				Arrays.fill(map[i][j], -1);
				
			}
		}
		Queue<Dot3> q = new LinkedList();
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=n;j++) {				
				temp =br.readLine().split(" ");
				for(int k=1;k<=m;k++) {
					map[j][k][i] = Integer.parseInt(temp[k-1]);
					if(map[j][k][i] == 1)q.add(new Dot3(j,k,i,0));
				}
			}
		}
		int lastDay =0;
		
		while(!q.isEmpty()) {
			
			Dot3 dot = q.poll();
			
			
			for(int i=0;i<6;i++) {
				int x = dot.x + tx[i];
				int y = dot.y + ty[i];
				int z = dot.z + tz[i];
				int day= dot.day;

				if(map[y][x][z] == 0) {
					map[y][x][z] = 1;
					q.add(new Dot3(y,x,z,day+1));
					
					
				}
				lastDay = day;
			}			
		}
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=n;j++) {				
				for(int k=1;k<=m;k++) {
					if(map[j][k][i] == 0)lastDay = -1;
				}
			}
		}
	
		System.out.println(lastDay);
		
	}
}

class Dot3{
	int x,y,z;
	int day;
	
	Dot3(int y, int x, int z, int day){
		this.x =x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}