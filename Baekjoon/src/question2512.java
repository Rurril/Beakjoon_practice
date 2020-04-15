package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		String[] temp = br.readLine().split(" ");
		
		long total = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
			total += arr[i];
		}
		Arrays.sort(arr); //이분탐색을 위한 정렬.
		
		long m = Long.parseLong(br.readLine());
		
		int max = arr[n-1];
		int min = 1;
		int middle;
		

		if(total < m)System.out.println(arr[n-1]);
		else if(total >= m) {
			
			while(max >= min) {
				long sum =0;
				middle = (max+min)/2;
				
//				System.out.print(max + " " + min);
				
				for(int i=0;i<n;i++) {
					
					if(arr[i] < middle)sum += arr[i];
					else sum += middle;
							
				}
//				System.out.println(" " +sum);
				
				if(m >= sum)min = middle +1;
				else if(m < sum)max = middle -1;
				
				
			}
			
			System.out.println(max);
	
		}
		
		
	}
}
