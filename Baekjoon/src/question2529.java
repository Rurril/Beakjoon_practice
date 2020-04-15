package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2529 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = br.readLine().split(" ");
		int[] order = new int[n+1];
		int[] ans = new int[n+1];
		Arrays.fill(ans,  -1);
		
		for(int i=1;i<=n;i++) {
			int input = order[i-1];
			
			if(arr[i-1].equals(">"))input--;
			else if(arr[i-1].equals("<"))input++;
			
			order[i] = input;
		}
		
		//order에 등급표를 매겨놓은 것과 같은 것. 
		
		
		
	}
}
