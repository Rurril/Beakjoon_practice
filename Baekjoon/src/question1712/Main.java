package question1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a;
		int b; // cost
		int c; // price
		int x;
		
		String[] input = br.readLine().split(" ");
	
		a = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);
		c = Integer.parseInt(input[2]);
		
		if(b >= c)System.out.println(-1);
		else {
			int result = a/(c-b) +1;
			System.out.println(result);
		}
		
		
				
		
		
	}
	
	
}
