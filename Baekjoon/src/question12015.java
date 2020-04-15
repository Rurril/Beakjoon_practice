package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question12015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];		
		
		String[] temp = br.readLine().split(" ");
		arr[0] = Integer.parseInt(temp[0]);
		int size =1;
		
		for(int i=1;i<n;i++) {
			int h = Integer.parseInt(temp[i]);
			
//			for(int j=0;j<n;j++)System.out.print(arr[j] + " " );
//			System.out.println();
			
			if(arr[size-1] < h)arr[size++] =h; //마지막에 넣은 숫자와 비교.
			else { // 만약에 같은 값이라면 같은 값으로 가도록 이분탐색을 설정해야 한다.
				int left =0;
				int right =size;
				int m =0;
				while(left <= right) {
					m = (left+right)/2;
					if(arr[m] < h)left = m+1;
					else right = m-1;
				}
				
				arr[left] = h;
			}

			
		}
		
		System.out.println(size);
	}
}
