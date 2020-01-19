package question1260;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Main { //1260 번 문제 bfs/dfs.
	
	static int node;
	static int edge;
	static int startNode;
	static boolean[][] map;
	static boolean[][] map2;
	
	static LinkedList result = new LinkedList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// DFS방식으로 수행하고나서 BFS방식으로 수행하는 것을 출력하면 됨.
				
		String[] temp = br.readLine().split(" ");
		node = Integer.parseInt(temp[0]);
		edge = Integer.parseInt(temp[1]);
		startNode = Integer.parseInt(temp[2]);
		
		map = new boolean[node+1][node+1];
		map2 = new boolean[node+1][node+1];
		
		
		for(int i=0; i<edge;i++) {
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			
			map[start][end] = true;
			map[end][start] = true;
			map2[start][end] = true;
			map2[end][start] = true;
		}
	
		
//		for(int i =1;i<=node;i++) {
//			for(int j=1;j<=node;j++) {
//				System.out.print(map2[i][j]);
//			}
//			System.out.println();
//			
//		}
		
		dfs(startNode);
		
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i));
			if(i==result.size()-1)System.out.println();
			else {
				System.out.print(" ");
			}
		}
		
		result.clear();
		
		
		bfs(startNode);
		
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i));
			if(i==result.size()-1)System.out.println();
			else {
				System.out.print(" ");
			}
		}
	}
	
	public static void bfs(int input) {
		Queue q = new LinkedList();
		q.add(input);
		
		
		while(!q.isEmpty()){
			
			int pop = (int)q.remove();
			result.add(pop);
			
			
			for(int i=1;i<=node;i++) {
				if(q.contains(i))continue;
				if(result.contains(i))continue;
				
				if(map2[pop][i]) {	
					q.add(i);
					
					map2[pop][i] = false;
					map2[i][pop] = false;
				}
			}
		}
	}
	
	public static void dfs(int input) {
		if(result.contains(input))return;
		
		result.add(input);
		
		for(int i=1;i<=node;i++) {
			
			if(map[input][i]) {
				if(result.contains(i))continue;;
				
				map[input][i] = false;
				map[i][input] = false;
				
				dfs(i);
				
			}	
		}
		return;
	}
}
