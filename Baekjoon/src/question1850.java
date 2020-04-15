package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1850 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		long[] arr = new long[2];
		
		for(int i=0;i<2;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		long number = gcd(arr[0], arr[1]);
		
		for(int i=0; i<number;i++) {
			System.out.print(1);
		}
	}
	
	public static long gcd(long n, long m) { // 최대 공약수를 구하는 가장 간단한 코드인듯... 대
		if(m==0)return n;
		return gcd(m, n%m);
	}
}
