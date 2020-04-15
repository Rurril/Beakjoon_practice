package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2437 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int n = Integer.parseInt(br.readLine());
		
		int[] weight = new int[n];
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			weight[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(weight);
		int min = 1;
		for(int i=0;i<n;i++) {
			if(min < weight[i])break;
			
			min += weight[i];
		}
		System.out.println(min);
	}
}
