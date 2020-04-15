package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		int[][] items = new int[n][2];
		
		for(int i=0; i<n;i++) {
			temp = br.readLine().split(" ");
			
			items[i][0] = Integer.parseInt(temp[0]); // 무게 입력
			items[i][1] = Integer.parseInt(temp[1]); // 가치 입력
		}
		
		
		
		
	}
}
