package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question11066 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		int[] values;
		int[] results = new int[testCase];
		
		for(int i=0;i<testCase;i++) {
			int coin = Integer.parseInt(br.readLine());
			String[] temp = br.readLine().split(" ");
			
			values = new int[coin];
			int[] dp = new int[coin];
			for(int j=0;j<coin;j++) {
				values[j] = Integer.parseInt(temp[j]);				
			}
			
			Arrays.sort(values);
			
			for(int j=0;j<coin-1;j++) {

				dp[j+1] = dp[j] + values[j] + values[j+1];
				values[j+1] += values[j];
				values[j] = 0;
				Arrays.sort(values);

			}
			results[i] = dp[coin-1];
			
			
		}
		
		for(int i=0;i<testCase;i++) {
			System.out.println(results[i]);
		}
	}
}
