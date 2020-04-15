package Test;

import java.io.IOException;
import java.util.Scanner;

public class question1629 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		System.out.println(power(a%c, b, c));
//		// b = 2^n 식으로 바꾸어서 시간 복잡도를 nlogn까지 떨어뜨릴 수 있다. 
//		int devide =(int) (Math.log(b) / Math.log(2)); // 로그 밑이 2인 수를 계산하게 했다.
//		

//
//		// TODO 
//		// 나누는 수 devide 그리수 몫과 나머지를 구해서 계산하면 최소 계산수로 최종값을 구할 수 있다.
//		// 마지막으로 mod 계산을 어떻게 적용을 해야지 가능한 것인지를 생각해서 계산하면 되는 것. 
//		int q = b / devide;
//		int r = b % devide;
//		// a^devide 을 q번 하고 a^r 을 곱하면 계산이 됨.
//		
//		int result = 1;
//		int r_temp = (int) Math.pow(a, devide);
//		r_temp = r_temp%c;
//		for(int i=0;i<q;i++) {
//			result = (result * r_temp) % c;
//		}
//		
//		result *= (int) Math.pow(a, r);
//		result = result %c;
//		
//		System.out.println(result);
//		
//		
		
	}
	public static long power(long a, long b, long c) {
		
		if(b == 1)return a;
		
		long temp = power(a, b/2, c) %c;
		
		// b가 짝수 일때
		if(b%2 == 0) {
			return(temp * temp) %c;
		}else// b가 홀수 일때
		{
			return((( temp * temp)%c ) * a) % c;
		}

		
		
	}
}
