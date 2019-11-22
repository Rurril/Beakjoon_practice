package question2775;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[t];
		int[][] apart = new int[15][15];
		
		for(int i = 1; i < 15; i++) {
			apart[0][i] = i;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				if(j == 1) {
					apart[i][j] = 1;
					continue;
				}				
				apart[i][j] = apart[i-1][j] + apart[i][j-1];			
			}
		}
			
		
		for(int i =0; i< t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			result[i] = apart[k][n];
		}
		
		for(int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
			
			
	
	}
	
}
