package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//조합의 개수를 구하는 거네.
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		long[][] pascal = new long[1001][1001];
		pascal[1][1] = 1;
		pascal[1][2] = 1;		
		for(int i=2;i<=1000;i++) { // 파스칼의 삼각형을 구성. 
			pascal[i][1] = 1;
			pascal[i][i] = 1;
			for(int j=2;j<1000;j++) {
				pascal[i][j] = (pascal[i-1][j] + pascal[i-1][j-1])%10007;
			}
		}
		
//		for(int i=1;i<=100;i++) {
//			for(int j=1;j<=100;j++) {
//				System.out.print(pascal[i][j]+  " ");
//			}System.out.println();
//		}
		
		System.out.println(pascal[n][k+1]); // k+1하는 것은, [i][1]에 는 안 뽑는 경우의 수가 들어있음. 
	
	}

}
