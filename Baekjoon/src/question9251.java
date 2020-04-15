package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split("");
		String[] b = br.readLine().split("");
		
		int n = a.length;
		int m = b.length;
		int[][] map = new int[n][m];
		int[] dp = new int[n];
		int[] mins = new int[n];
		Arrays.fill(mins, -1);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i].equals(b[j]))map[i][j] = 1;
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				
				if(i==0 && map[i][j] == 1) {
					mins[0] = j;
					break;
				}
				
				if(map[i][j] ==1 && mins[i-1] < j){
					mins[i] = j; //전 배열 값보다 크지만 가장 작은 값을 넣는다.
					break; // 더 큰 값이 들어가지 못하게 끝. 
				}	
			}	
		}
		
		for(int i=1;i<n;i++) {
			for(int j=i;j>=0;j--) {
				
				if(mins[i] > mins[j])dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result+1);
	}
}
