package question2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	static String[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new String[n+1][n+1];
		
			
		
	}
	
	public void func(int x, int y, int n) {
		n = n/3;
		
		for(int i = 1; i <= 3; i++) { //각 1~3까지 들어가도록 .
			for(int j = 1; j <= 3; j++) {
				if(n != 1)func(i,j,n);
			}
		}
		
		
		if(n == 1) return;
		
		
		
	}
	
	
}
