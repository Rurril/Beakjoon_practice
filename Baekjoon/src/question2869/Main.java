package question2869;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] temp = br.readLine().split(" ");
		int[] input = new int[temp.length];
		
		for(int i =0; i < temp.length; i++) {
			input[i] = Integer.parseInt(temp[i]);
		}
		
		double result = (input[2] - input[0]) / ((double)input[0] - input[1]);
//		System.out.println(result);
		System.out.println((int)Math.ceil(result) +1); ;
		
		
	}
	
}
