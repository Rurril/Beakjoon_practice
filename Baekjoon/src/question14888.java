package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question14888 {
	
	static int[] arr;
	static int[] operator = new int[4];
	static int n;
	static int max = -Integer.MAX_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] temp = br.readLine().split(" ");
		
		for(int i=0;i<n;i++)arr[i] = Integer.parseInt(temp[i]);
		temp = br.readLine().split(" ");
		for(int i=0;i<4;i++)operator[i] = Integer.parseInt(temp[i]);
		
		
		
		bf(arr[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	public static void bf(int res, int order) {
		
		if(order == n) {
			if(min >= res)min = res;
			if(max <= res)max = res;
			
			return;
		}
		
		if(operator[0] != 0) {
			
			res += arr[order];
			operator[0]--;
			bf(res, order+1);
			operator[0]++; // 복구시켜놓는다. 
			res -= arr[order];
		}
		
		if(operator[1] != 0) {
			
			res -= arr[order];
			operator[1]--;
			bf(res, order+1);
			operator[1]++;
			res += arr[order];
			
		}
		
		if(operator[2] != 0) {
			
			res *= arr[order];
			operator[2]--;
			bf(res, order+1);
			operator[2]++;
			res /= arr[order];
			
		}
		
		if(operator[3] != 0) {			
			res /= arr[order];
			operator[3]--;
			bf(res, order+1);
			operator[3]++;
			// 이 뒤에 res가 쓰일일이 없으므로 굳이 복구를 안해줘도 된다.
		}
	}
}
