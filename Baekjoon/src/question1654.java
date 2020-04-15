package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int k = Integer.parseInt(temp[0]); // 갖고 있는 랜선의 개수.
		int n = Integer.parseInt(temp[1]); // 만들어야 하는 랜선의 개수.
		
		long[] length = new long[k];

		for(int i=0;i<k;i++)length[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(length);
		
	
		long max = length[k-1];
		long min = 1; // 길이는 자연수라고 했으므로, 최소 값은 1이 되어야한다... 
		long middle;
			
		while(max >= min) {
			
			middle = (max+min)/2;
			int cnt =0;
			for(int i=0;i<k;i++) {
				cnt += length[i]/middle;
			}
			
			if(cnt >= n)min = middle +1;
			else if(cnt < n)max = middle -1;
				
						
		}
		
		System.out.println(max);
		
		
		
	}
}
