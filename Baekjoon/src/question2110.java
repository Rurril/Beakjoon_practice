package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]); // 집의 개수.
		int c = Integer.parseInt(temp[1]); // 공유기의 개수
		
		long[] arr = new long[n];
		
		for(int i=0;i<n;i++)arr[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(arr);
		
		long max = arr[n-1];
		long min = 1;
		long middle;
		
		while(max >= min) {
			int cnt = 1;
			long prev = arr[0];
			
			middle = (max + min)/2;
			
			for(long num : arr) {
				if(num - prev >= middle) { // 간격을 middle로 설정하고 이것보다 크다면 cnt 설치를 하는 식으로..
											// 아... 이렇게 푸는 방법이 있구나... 
					cnt++;
					prev = num;
				}
			}
			
			if(cnt >= c) min = middle +1; // 개수만큼 설치했지만, 그래도 더 큰 간격을 살펴봐야하므로. 
			else max = middle -1; // 너무 간격이 멀어서 설치 갯수가 부족한 경우. 
			
		}
		System.out.println(max);
		
		
	}
}
