package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2104 {
	
	static int n;
	static long[] arr = new long[100001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(temp[i-1]);
		}
		
		long result;
	}
	
	public static long devideAndConquer(int start, int end) {
		if(start == end)return arr[start] * arr[end];
		
		int mid = (start+end)/2;
		long ans = Math.max(devideAndConquer(start, mid), devideAndConquer(mid+1, end));
		long min = arr[mid];
		int left = mid;
		int right = mid;
		long sum = arr[mid];
		
		while(right - left < end - start) {
			
		}
		
		
		return 0;
	}
}
