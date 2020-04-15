package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2740 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[][] arr_A = new int[n][m];
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				arr_A[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		temp = br.readLine().split(" ");
		//행의 개수는 위의 배열의 m - 열의 개수와 똑같다. 
		int k = Integer.parseInt(temp[1]);
		
		int[][] arr_B = new int[m][k];
		
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<k;j++) {
				arr_B[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int[][] result = new int[n][k];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				//result[i][j] 
				for(int l=0;l<m;l++) {
					result[i][j] += arr_A[i][l] * arr_B[l][j];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				System.out.print(result[i][j] + " ");
			}System.out.println();
		}
		
		
	}
}
