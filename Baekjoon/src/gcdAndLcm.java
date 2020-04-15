package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gcdAndLcm {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int a = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1]);
		
		long gcd = getGCD(Math.max(a, b), Math.min(a, b));
		long lcm = getLCM(a, b, gcd);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
	//lowest common multiple
	//greatest common devisor
	public static long getGCD(long a, long b) {
		while(b > 0) {
			long temp = a;
			a = b;
			b = temp%b;
		}
		return a;
	}
	
	public static long getLCM(long a, long b, long gcd) {
		return (a*b)/gcd;
	}

}
