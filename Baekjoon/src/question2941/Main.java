package question2941;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		int count = 0;
		
		for(int i = a.length()-1; i>=0 ; i--) {
			
			if(a.charAt(i) == '-') {
				i--; // - 이전의 알파벳이 무엇인지는 중요한것이 아니라 카운트만이 중요한것.
			}else if(a.charAt(i) == '=') {
				i--;
				if(a.charAt(i) == 'z' && i > 0) {//dz= 인 경우가 있으므
					if(a.charAt(i-1) == 'd')i--;
				}
			}else if(a.charAt(i) == 'j' && i > 0) {
				if(a.charAt(i-1) == 'n' || a.charAt(i-1) == 'l')i--;
			}
			
			count++;
		}
		
		System.out.println(count);
	}
}
