package question2644;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n;
	static int m;
	static int start;
	static int end;
	static int[][] map;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		start = Integer.parseInt(temp[0]);
		end = Integer.parseInt(temp[1]);
		m = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		result = new int[n+1];
		for(int i=0;i<m;i++) {
			String[] temp2 = br.readLine().split(" ");
			int x = Integer.parseInt(temp2[0]);
			int y = Integer.parseInt(temp2[1]);
		
			map[x][y] = 1;
			map[y][x] = 1;
			
		}
		
		
		bfs(start);
//		for(int i=0;i<n;i++){
//			System.out.print(result[i+1]);
//		}
//		System.out.println();
		if(result[end] ==0)System.out.println(-1);
		else {
			System.out.println(result[end]);
		}
		
	}
	
	public static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] pass = new boolean[n+1];
		q.add(start);
		
		while(!q.isEmpty()) {
			
			int node = q.poll();
//			System.out.println("adding process" + node);
			for(int i=1;i<=n;i++) {
				if(pass[i])continue; // 이미 촌수 계산을 거쳐갔다는 뜻.
//				System.out.println("node is this " + node);
				if(map[node][i]==1) { //관계가 이어져 있다는 뜻. - 부모 자식 관계.
					q.add(i);
					pass[node] = true;
					result[i] = result[node] +1;
				}
			}
		}
	}
}
