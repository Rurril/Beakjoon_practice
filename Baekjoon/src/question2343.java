package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2343 {
	
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int min = 0;
		int max = 0;
		
		arr = new int[n];
		
		temp = br.readLine().split(" ");
		br.close();
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
			min = Math.max(min,  arr[i]);
			max += arr[i];
		}
		
		int ans = Integer.MAX_VALUE;
		
		while(max >= min) {
			
			int cnt =1;
			int mid = (max+min)/2;
			
			if(getCount(mid) > m) {
				min = mid +1;
			}else {
				ans = Math.min(ans,  mid);
				max = mid -1;
			}
					
		}
		System.out.println(ans);
		br.close();
		
		
	}
	
	static int getCount(int mid) {
		int ret = 1;
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
			if(sum > mid) {
				ret++;
				sum = arr[i];
			}
		}
		return ret;
	}
}
