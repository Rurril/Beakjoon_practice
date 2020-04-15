package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11047 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		int[] coin = new int[n];
		
		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		
		int order = coin.length-1;
		int count = 0;
		
		while(k>0) {
			
			if(k < coin[order]) {
				order--;
				continue;
			}else {
				k -= coin[order];
				count++;
			}
			
			
		}
		
		System.out.println(count);
	}
}
