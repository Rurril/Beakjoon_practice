package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class question1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[t];
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][2];
			
			for(int j=0;j<n;j++) {
				String[] temp = br.readLine().split(" ");
				arr[j][0] = Integer.parseInt(temp[0]);
				arr[j][1] = Integer.parseInt(temp[1]);
			}
			
			Arrays.sort(arr,new Comparator<int[]>() { //Comparator 인터페이스 재정의

				@Override
				public int compare(int[] o1, int[] o2) {
										
					 if(o1[0]==o2[0])// 0번째 값이 같다면 1번째 값을 기준으로 정렬 - 여기선 그런경우 없음.
						return Integer.compare(o1[1], o2[1]);
						
					return Integer.compare(o1[0], o2[0]); // 나머지는 0번째 값을 기준으로 정렬. 
				
				}				
			});
			
			int cnt = n;
			int min = arr[0][1];
			
			for(int j=1;j<n;j++) {
				
				int rank = arr[j][1];
				
				if(min < rank)cnt--;
				else if(min > rank)min = rank;
				
			}
			
			
			result[i] = cnt;
			
			
		}
		
		for(int i=0;i<t;i++)System.out.println(result[i]);
	
		
	}

}
