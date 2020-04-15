package Test;
import java.io.*;
public class question5585 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int change = 1000-n;
		int count = 0;
		while(change!=0) {
			
			if(change>=500) {
				change -= 500;
				count++;
			}else if(change >= 100 && change <500) {
				change -= 100;
				count++;
			}else if(change >= 50 && change <100) {
				change -= 50;
				count++;
			}else if(change >= 10 && change < 50) {
				change -= 10;
				count++;
			}else if(change >= 5 && change < 10) {
				change -= 5;
				count++;
			}else if(change >= 1 && change < 5) {
				change--;
				count++;
			}
		}
		System.out.println(count);
		
	}
}
