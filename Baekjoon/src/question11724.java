package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question11724 {
	
	static int[][] map;
	static boolean[] check;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]); // node의 개수.
		m = Integer.parseInt(temp[1]); // edge의 개수.
		map = new int[n+1][n+1];
		check = new boolean[n+1];
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			int s = Integer.parseInt(temp[0]);
			int e = Integer.parseInt(temp[1]);
			
			map[s][e] = 1;
			map[e][s] = 1;
						
		}
		
		Queue<Integer> q = new LinkedList();
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(!check[i]) {
				check[i] = true;
				cnt++;
				q.add(i);
				while(!q.isEmpty()) {
					
					int node = q.poll();
					
					for(int j=1;j<=n;j++) {
						
						if(map[node][j] == 1 && !check[j]) {
							q.add(j);
							check[j] = true;
						}
					}
				}
				
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
