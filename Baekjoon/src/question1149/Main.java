package question1149;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			String[] temp = new String[3];
			temp = br.readLine().split(" ");
			
			house[i][0] = Integer.parseInt(temp[0]);
			house[i][1] = Integer.parseInt(temp[1]);
			house[i][2] = Integer.parseInt(temp[2]);
		}
	
		for(int i=2;i<=n;i++) {
			house[i][0] += Math.min(house[i-1][1], house[i-1][2]);
			house[i][1] += Math.min(house[i-1][0], house[i-1][2]);
			house[i][2] += Math.min(house[i-1][0], house[i-1][1]);
		}
		
		System.out.println(Math.min(house[n][0], Math.min(house[n][1], house[n][2])));
	}
	
}
