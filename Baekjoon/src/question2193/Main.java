package question2193;
//이친수 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long case_0 = 0;
		long case_1 = 1;
		
		for(int i=1;i<n;i++) {
			long temp_0 = case_1 + case_0;
			long temp_1 = case_0;
			case_0 = temp_0;
			case_1 = temp_1;
		}
		
		System.out.println(case_0+case_1);
	}
}
