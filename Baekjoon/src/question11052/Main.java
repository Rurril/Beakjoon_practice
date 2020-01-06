package question11052;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] cost = new int[n];
		for(int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(temp[i]);
		}
		
		
		
	}
}
