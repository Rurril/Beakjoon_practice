package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question10830 {
	
	static int n;
	static long b;
	static long[][] base;
	static long mod = 1000;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		b = Long.parseLong(temp[1]);
		base = new long[n][n];
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				base[i][j] = (Long.parseLong(temp[j]))%mod;
			}
		}
		
		long[][] result = power(base, b);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)System.out.print(result[i][j] + " ");
				
			System.out.println();
		}
		
	}
	public static long[][] power(long[][] arr, long b) {
		
		if(b == 1) {
			return arr;
		}
		
		if(b % 2 == 1) {
			long[][] temp = power(arr,b/2);
			temp = multiple(temp, temp);
			return multiple(temp, base);
			
		}else {
			long[][] temp = power(arr,b/2);
			return multiple(temp, temp);
		}
				
		
	}
	public static long[][] multiple(long[][] a, long[][] b){
		
		long[][] res = new long[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					res[i][j] += (a[i][k] * b[k][j])%mod;
					res[i][j] = res[i][j]%mod;
				}
			}
		}
		return res;
		
	}
}
