package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question2447 {
	
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
			
		
		for(int i=0;i<n;i++) {
			Arrays.fill(map[i], ' ');
		}
		
		
		solve(0,0,n);
		for (int i = 0; i < n; i++) {
			 System.out.println(map[i]);
	    }
	}

	
    public static void solve (int x, int y, int n) {
        if (n == 1){
        	map[x][y] = '*';
            return;
        }
        int m = n/3;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i==1 && j==1){
                    continue;
                }
                solve(x+m*i, y+m*j, m);
            }
        }
    }
	
}
