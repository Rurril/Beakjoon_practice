package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question9753_sub {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[100001];
		Arrays.fill(isPrime, true);
				
		for (int i = 2; i * i < isPrime.length; i++) {
			for (int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}
				
		long[] prime = new long[9592];
		int j = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				prime[j++] = i;
			}
		}
		
//		List<Long> list = new ArrayList<>();
//		for(int i=0;i<prime.length;i++) {
//			for(int j=i+1;j<prime.length;j++) {
//				
//			}
//		}
		
	}
}
