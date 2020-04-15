package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question3020_sub {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int h = Integer.parseInt(temp[1]);
		
		int[] down = new int[h];
		int[] up = new int[h];
		
		for(int i=0;i<n;i+=2) {
			down[Integer.parseInt(br.readLine()) -1 ]++;
			up[Integer.parseInt(br.readLine()) -1 ]++;
		}
		
		int[] tDown = new int[h];
		int[] tUp = new int[h];
		
		tDown[h-1] = down[h-1];
		tUp[0] = up[h-1];
		
		for(int i = h-2; i>=0; i--)tDown[i] = tDown[i+1] + down[i];
		for(int i =1; i<h; i++)tUp[i] = tUp[i-1] + up[h-i-1];
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<h;i++) {
			int num = tDown[i] + tUp[i];
//			System.out.print(num + " ");
			min = Math.min(min, num);
		}
//		System.out.println();
		int cnt = 0;
		
		for(int i=0;i<h;i++) {
			if(min == tDown[i] + tUp[i])cnt++;
		}
		
		System.out.println(min + " " + cnt);
		
	}
}
