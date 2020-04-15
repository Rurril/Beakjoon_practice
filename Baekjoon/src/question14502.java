package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class question14502 {
	
	static int[][] map;
	static int[][] map2;
	static int n;
	static int m;
	static ArrayList<int[]> pos = new ArrayList();
	static ArrayList<int[]> comb = new ArrayList();
	static Queue<int[]> virus = new LinkedList();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		map = new int[n][m];
		map2 = new int[n][m];
		
		for(int i=0;i<n;i++) {
			
			temp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
		findLocation(); // 0으로 벽이 들어갈 수 있는 곳 구해놓기.
		int[] arr = new int[3];
		combination(arr, 0, pos.size(), 3, 0);
		
		int max = 0;
		for(int i=0; i<comb.size();i++) { // 조합의 개수만큼 반복.
			makeWall(comb.get(i));
			int numberOfSafetyZone = bfs();
			max = Math.max(max, numberOfSafetyZone);
		}
		
		System.out.println(max);
		
	}
	public static void findLocation() {
				
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] ==0) {
					int[] temp = {i,j};
					pos.add(temp);
				}
			}
		}
		
//		System.out.println(pos.size()); //이상 없음.
		// 각 좌표지점들을 입력했으면 이것으로 콤비네이션 값을 구해야한다.
		
	}
	
	public static void combination(int[] arr, int index, int n, int r, int target) { 
		
		if(r == 0) printArray(arr, index);
		else if (target == n) return; 
		else { 
			arr[index] = target; 
			combination(arr, index + 1, n, r - 1, target + 1); 
			combination(arr, index, n, r, target + 1); } 
		
	}//end combination()

	public static void printArray(int[] arr, int length) {
		int[] temp = new int[3];
		temp[0] = arr[0];
		temp[1] = arr[1];
		temp[2] = arr[2];
		
		comb.add(temp);
	}
	public static void makeWall(int[] combination) {
//		Queue<Integer> q = new LinkedList();
		
		for(int i=0;i<n;i++) { //map2에다가 새롭게 만들어서 저장.
			for(int j=0;j<m;j++) {	
				map2[i][j] = map[i][j];
				
				if(map[i][j] == 2) {
					int[] virusLocation = {i, j};
					virus.add(virusLocation);
				}
			}
		}
		
		for(int i=0;i<3;i++) {	
			int num = combination[i];
			int y = pos.get(num)[0];
			int x = pos.get(num)[1];	
			map2[y][x] = 1;
		}
	}
	
	public static int bfs() {
		// map2를 가지고 안전구역을 구해야하는데 그 전에 bfs를 통해서 바이러스 확산.
		int[] tx = {1, -1, 0, 0};
		int[] ty = {0, 0, 1, -1};
		int nextY;
		int nextX;
		
		while(!virus.isEmpty()) {
			int[] temp = virus.poll();
			
			for(int i=0;i<4;i++) {
				nextY = temp[0] + tx[i];
				nextX = temp[1] + ty[i];
				if(nextY < n && nextY >=0 && nextX < m && nextX >=0 && map2[nextY][nextX]==0) { 
					//맵 바깥을 벗어나면 안되며, 바이러스가 있거나 벽이 있다면 안된다.
					map2[nextY][nextX] = 2;
					int[] virusLocation = {nextY,nextX};
					virus.add(virusLocation);
					
				}
				
			}
		}
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(map2[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		int safetyZone = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map2[i][j] == 0)safetyZone++;
			}
		}
		return safetyZone;
		
	}
}
