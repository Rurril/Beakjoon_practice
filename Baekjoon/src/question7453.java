package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question7453 {
	
	static int[] a;
	static int[] b;
	static int[] ab;
	static int[] c;
	static int[] d;
	static int[] cd;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 4개의 배열을 2개의 배열로 나누어 만들어서 진행하는 투포인터 알고리즘 적용. 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		b = new int[n];
		ab = new int[n*n];
		c = new int[n];
		d = new int[n];
		cd = new int[n*n];
		
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			a[i] = Integer.parseInt(temp[0]);
			b[i] = Integer.parseInt(temp[1]);
			c[i] = Integer.parseInt(temp[2]);
			d[i] = Integer.parseInt(temp[3]);
			
		}
		
		int order =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ab[order] = a[i] + b[j];
				cd[order] = c[i] + d[j];
				order++;
			}
		}
		
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		int left = 0;
		int right = n*n-1;
		long cnt = 0;
		
		
		while(right >= 0 && left < n*n) {
			
			System.out.println(left + " "  + right);
			
			long left_val = ab[left];
			long right_val = cd[right];
			
			if(left_val + right_val == 0) {
				
				System.out.println(" correct value is " + left_val + " " + right_val);
				
				long left_cnt = 0;
				while(left < ab.length && ab[left] == left_val) {
					left_cnt++;
					left++;
				}
				
				long right_cnt = 0;
				while(right >= 0 && cd[right] == right_val) {
					right_cnt++;
					right--;
				}
				
				cnt += left_cnt * right_cnt;
			}
			
			if(left_val + right_val <0)left++;
			else if(left_val + right_val > 0)right--;
			
		}
		
		System.out.println(cnt);
		
	}
}	
