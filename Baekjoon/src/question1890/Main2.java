package question1890;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
	 static int N;
	 
	    public static void main(String[] args) throws Exception {
	 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	        N = Integer.parseInt(br.readLine());
	        int[][] arr = new int[N + 1][N + 1];
	        long[][] dp = new long[N + 1][N + 1];
	        String str[];
	        for (int i = 0; i < N; i++) {
	            str = br.readLine().split(" ");
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = Integer.parseInt(str[j]);
	 
	            }
	        }
	        dp[0][0]=1;
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if(i==N-1&&j==N-1) continue;
	                int next = arr[i][j];
	                if (i + next < N) {
	                    dp[i + next][j] += dp[i][j];
	                }
	                if (j + next < N) {
	                    dp[i][j + next] += dp[i][j];
	                }
	                //print(dp);
	                //System.out.println();
	            }
	        }
	        
	        for(int i=0;i<N;i++) {
	        		for(int j=0;j<N;j++) {
	        			System.out.print(dp[i][j]);
	        		}
	        		System.out.println();
	        }
	        System.out.println(dp[N-1][N-1]);
	    }
}
