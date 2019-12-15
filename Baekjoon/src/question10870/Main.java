package question10870;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[21];
		
		list[0] = 0;
		list[1] = 1;

		
		for(int i = 2; i <= 20; i++) {
			list[i] = list[i-1] + list[i-2];						
		}
		
		System.out.println(list[n]);
		
	}
}
