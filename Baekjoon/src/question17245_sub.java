package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question17245_sub {
	
	static int[] map = new int[10000001];
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		long sum = 0;
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(temp[j]);
				map[num]++; 
				sum += num;
			}
		}
		
		if(sum %2 == 0)sum /=2;
		else sum = sum/2 +1;
		
		// counting sort에서 끝나는게 아니라 배열 위치 선택을 이분탐색으로 하면 더 빠르겠네.
		long cnt = 0; //하지만 0에서 이미 끝난다면?
		long num = 0; 
		long computers =0;
		while(true) {
			computers += map[(int)cnt]*cnt;
			num += map[(int)cnt]; // 지금까지 층에서 확인한 컴퓨터 층. 
//			System.out.println(computers);
			if(computers + (n*n - num)*cnt >= sum)break;

			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
}
