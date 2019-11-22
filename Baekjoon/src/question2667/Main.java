package question2667;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
	
	static boolean pass[][];
	static String map[][];
	static int[] tx = {1, -1, 0, 0};
	static int[] ty = {0, 0, 1, -1};
	static int n;
	static int count = 0;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pass = new boolean[n][n];
		map = new String[n][n];
		
		for(int i =0; i< n; i++) { // write the map into map[][]
			map[i] = br.readLine().split("");			
		}
				
		for(int i=0; i<n; i++) {
			for(int j =0; j< n; j++) {				
				if(!pass[i][j] && map[i][j].equals("1")) {			
					result.add(1); // 새로운 단지를 투가합니다. 
					dfs(i, j);
					count++;
				}
			}
		}
		//마지막으로 오름차순을 정리를 한 번 해주어야한다.
		result.sort(null);
		System.out.println(result.size());
		for(int i =0; i< result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	// 지금와서 생각을 해보니까 queue를 이용해서 bfs로 해결하는 방법도 간단하게 나오겠다는 생각이 들었다. 
	public static void dfs(int x, int y) {
		pass[x][y] = true;
		
		for(int i=0; i< 4; i++) {
			if(x+tx[i] <0 || x+tx[i] == n || y+ty[i] < 0 || y+ty[i] == n)continue; // avoid index exception
			if(!pass[x+tx[i]][y+ty[i]] && map[x+tx[i]][y+ty[i]].equals("1")) {
									
				result.set(count, result.get(count)+1); // 단지수를 하나 추가시키기. 
				dfs(x+tx[i], y+ty[i]);
			}
		}
		return;
	}
}
