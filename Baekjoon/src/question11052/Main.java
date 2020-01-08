package question11052;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main { // 카드구매하기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(temp[i-1]);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
//				System.out.println("i is : " + i + " and : " + dp[i]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
