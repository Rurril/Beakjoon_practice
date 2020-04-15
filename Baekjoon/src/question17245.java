package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question17245 {
	
	static int[][] map;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		long sum = 0;
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				sum += map[i][j];
			}
		}
		if(sum %2 == 0)sum /= 2;
		else sum = sum/2 +1; //홀수면 반 이상이려면 +1을 해주어야한다.
		int left = 0;
		int right = 10000000;
		
		while(right>= left) {
			int mid = (right+left)>>1;
//			System.out.println("mid " + mid);
			long cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					cnt += Math.min(map[i][j], mid);
				}
			}
			
//			System.out.println(cnt);
			// 몇 분이 지나야 켜지는 지를 구해야하는 것, 시간 = 높이.
			if(cnt > sum)right = mid-1;
			else if(cnt <= sum)left = mid+1;
		}
		
		System.out.println(left);
		
	}
}
