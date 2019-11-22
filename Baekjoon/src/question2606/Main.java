package question2606;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		int number = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		int[][] map = new int[number][number];
		boolean[] flag = new boolean[number];
		
		for(int i =0; i < edge;i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0])-1;
			int b = Integer.parseInt(temp[1])-1;
			map[a][b] = map[b][a] = 1;			
		}
		
		//이제 BFS 구간
		q.add(0);
		flag[0] = true;
		int result =0;
		while(!q.isEmpty()) {
			
			int node = q.poll();
			flag[node] = true;
//			System.out.println(node);
			for(int i=0; i < map.length; i++) {
				//System.out.println(flag[i] == false);
				
				if(flag[i]==false) {
					if(map[node][i] == 1) {
						if(!q.contains(i))q.add(i);						
					}
				}
			}		
			result++;
		}
		
		System.out.println(result-1);
	}
}
