package question1026;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] array_A = br.readLine().split(" ");
		String[] array_B = br.readLine().split(" ");
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();	
		for(int i=0;i<n;i++) {
			a.add(Integer.parseInt(array_A[i])); 
			b.add(Integer.parseInt(array_B[i]));
		}
		
		
//		Collections.reverseOrder(b);
		Collections.sort(a);
		Collections.sort(b);
		Collections.reverse(b);
		
		int result = 0;
		for(int i=0;i<n;i++) {
//			System.out.println(a.get(i));
//			System.out.println(b.get(i));
			result += a.get(i)*b.get(i);
		}
		
		System.out.println(result);
		
	}
}
