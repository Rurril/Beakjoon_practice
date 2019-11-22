package question1193;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int count = 1;
		
		if(number == 1) {
			System.out.println("1/1");
			return;
		}
		
		while(true) {
			
			if(number - count > 0) {
				number -= count;
				count++;				
			}else {
				
				break;
			}
		}
		
		int up;
		int down;
		// 여기서 중요해지는 것이 count가 짝수냐 홀수냐 그리고 number가 몇개가 남았냐.
		if(count % 2 == 1) {// count가 홀수다. 오르막길
//			System.out.println(count);
			up = count + 1 - number;
			down = count + 1 - up;
			
		}else {
			down = count + 1 - number;
			up = count + 1 - down;			
		}
		
		System.out.print(up);
		System.out.print("/");
		System.out.print(down);
		
		
	}
}
