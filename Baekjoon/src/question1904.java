package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1904 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[1000001];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i=3;i<=n;i++) {
			arr[i] = (arr[i-1] + arr[i-2])%15746;
			System.out.println(arr[i]);
		}
		
	}
}
