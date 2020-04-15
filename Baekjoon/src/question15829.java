package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question15829 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long r = 31;
		long mod = 1234567891;
		
		String word = br.readLine();
		
		long result = 0;
		for(int i=0;i<n;i++) {
			long temp = word.charAt(i)-96;
			
			long pow = 1;
			for(int j=0;j<i;j++) {
				pow = (pow*r)%mod;
			}
			result += (temp*pow)%mod;
			result %= mod;
		}
		
		System.out.println(result);
		
	}
}
