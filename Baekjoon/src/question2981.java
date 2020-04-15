package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2981 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		
		for(int i=0;i<n;i++)arr[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(arr);
		long max = arr[1];
		
		
		for(int j=2;j<max;j++) {
			for(int i=1;i<n;i++) {
				if(arr[0]%j != arr[i]%j)break;
							
				
				if(i==n-1) { // 다 나머지가 같다는 의미이므로.
					System.out.print(j + " ");
				}
			}
		}
		
		
	}
}
