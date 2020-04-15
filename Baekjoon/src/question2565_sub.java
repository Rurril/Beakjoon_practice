package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class question2565_sub {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//결국 문제가 LIS의 응용이었던 거였음...
		// 한쪽으로 오름차순으로 정렬하여서 수가 커지는 방향으로 끊기지 않게 하는 것에 최댓값. 
		// 그리고 나머지는 제거하면 되는 일..
		
		int[] line = new int[501];
		int[] dp = new int[n];
		ArrayList<Integer> al = new ArrayList();
		// 교차되는 경우는 2가지 from은 작지만 to는 다른 선보다 큰 경우.
		// from 은 크지만 to는 다른 선보다 작은 경우.
		
		//다 확인하는것이 아니라 dp를 이용한다면...? 
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			line[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
		}
		
		for(int i=1;i<=500;i++) {
			if(line[i] != 0)al.add(line[i]);
		}
		
		for(int i=1;i<n;i++) {
			
			for(int j=i-1;j>=0;j--) {
				if(al.get(i) > al.get(j))dp[i] = Math.max(dp[i], dp[j]+1);
			} 
			
		}
		
		int result = 0;
		for(int i=0;i<n;i++) {
			result = Math.max(result,  dp[i]);
		}
		
		System.out.println(n - (result+1));
		
		
		
	}
}
