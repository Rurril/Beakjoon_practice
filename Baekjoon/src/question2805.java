package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]); // 나무의 수.
		int m = Integer.parseInt(temp[1]); // 가져가야 하는 최소의 길이.
		
		int[] trees = new int[n];
		
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			trees[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(trees);
		
		int max = trees[trees.length-1];
		int min = 0;
		int mid = 0;
		
		while(max >= min) {
			
//			System.out.println(max +  " " + min);
			mid = (min+max)/2;
			
			int rest = 0; // 자르고 남은 나무 길이.
			long sumOfRest = 0; // 잘라낸 나무 길이들의 합. - int 배열을 넘어갈 수 있기 때문에 long으로 선언
			
			
			for(int i=0;i<trees.length;i++) {
				rest = trees[i] - mid;// 이분탐색으로 적절한 톱날의 높이를 찾아간다. 중간 값으로 나무들을 잘라보고
                						// 범위를 좁혀나간다.
				
				if(rest < 0)rest = 0;
				sumOfRest += rest; 
			}
			
			if(sumOfRest >= m)min = mid +1;// 톱으로 잘라낸 나무 길이들의 합이 최소한으로 가져가야되는 나무 길이보다 클 때
			else if(sumOfRest < m)max = mid -1;// 톱으로 잘라낸 나무 길이들의 합이 최소한으로 가져가야 되는 나무 길이보다 작을 때
			
		} 
		
		System.out.println(max);    // 톱날의 높이를 설정할 수 있는 높이에서 최대값
		
		
	}
}
