package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11401 {
	static long n,k,mod;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Long.parseLong(temp[0]);
		k = Long.parseLong(temp[1]);
		mod = 1000000007;
		long[] factorial = new long[4000001];
		factorial[0] = 1;
		factorial[1] = 1;
		for(int i=1;i<=4000000;i++)factorial[i] = (factorial[i-1]*i)%mod;
		
		// n! * r!(n-r)!^p-2을 구해야 하므로 일단 뒤의 것 구하기.

		
		long result = factorial[(int)k]%mod * factorial[(int)(n-k)] % mod;
		
		//result^p-2 을 구해야 하는 것. 
		
		result = power(result, mod-2);
		result = (result * factorial[(int)n]) %mod;
		System.out.println(result);
		
		
	}
	
	public static long power(long a, long b) {
		
		if(b == 1)return a;
		
		long temp = power(a, b/2) %mod;
		
		if(b % 2 == 0) {
			return (temp*temp)%mod;
		}else {
			return ((temp*temp)%mod * a) % mod;
		}
		
		
	}
}
