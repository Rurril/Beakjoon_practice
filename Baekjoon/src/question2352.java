package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2352 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		String[] temp = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(temp[i-1]);
		}
		
		Arrays.fill(dp, 1);
		dp[0] =0;
		int max =0;
		for(int i=1;i<=n;i++) {
			
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j])dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max,  dp[i]);
		}
		
//		for(int i=1;i<=n;i++) {
//			System.out.print(dp[i] + " ");
//		}System.out.println();
		
		System.out.println(max);
	}
}
