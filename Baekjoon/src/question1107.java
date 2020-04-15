package Test;

import java.io.IOException;
import java.util.Scanner;
public class question1107 {
	
	
	static boolean[] broken = new boolean[10];
	static int n;
	static int m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
//		String[] temp = br.readLine().split(" "); //이 부분이 0개가 주어지면 런타임 에러가 날 수가 있구나;;; 이럴수가. 
		
		
		for(int i=0;i<m;i++) {
			broken[sc.nextInt()] = true; // 망가진 버튼이라는 의미.
		}
		
		int min = Math.abs(n-100);//처음부터 클릭해서 구한 방법. 
		
		for(int i=0;i<1000000;i++) {
			int channel = i;
			int length = canMove(channel);
			
			if(length > 0) { //클릭해서 갈 수 있다는 것. 
				int clickNumber = Math.abs(n-channel) + length;
				min = Math.min(min, clickNumber);
			}
		}
		
		sc.close();
		System.out.println(min);
		
	}
	public static int canMove(int channel) {
		
		int length = 0;
		
		if(channel == 0) return broken[0] ? 0 : 1; // 이렇게 ? 연산자 사용하는거 알고 있는데, 쓸 생각을 못하고 있었다.
		// 훨씬 간결하고 보기 좋은 코드가 될 수 있음. 
		
		while(channel > 0) {
			int mod = channel%10;
			
			if(broken[mod])return 0; // 갈 수 없는 불가능이라는 뜻.
			length++; // 채널의 길이가 버튼을 누르는 숫자이므로. 
			channel /= 10;
		}
		
		return length;
	}
}
