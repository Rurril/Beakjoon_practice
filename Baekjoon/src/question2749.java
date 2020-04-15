package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question2749 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long mod = 1000000;
		long cycle = 1500000; 
		n %= cycle;		
		
		long fibA = 1;
		long fibB = 1;
		
		if(n==1 || n==2) {
			System.out.println(1);
		}else {
			for(long i=3;i<=n;i++) {
				long temp = fibA;
				fibA = (fibA + fibB)%mod;
				fibB = temp;
			}
			System.out.println(fibA);
		}
		
		
		
		
	}
}	
