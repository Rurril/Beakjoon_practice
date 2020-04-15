package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question1946_sub {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		while (T-- > 0) {
			int count = Integer.parseInt(reader.readLine());
			int[] array = new int[count + 1];
			for (int i = 1; i <= count; ++i) {
				StringTokenizer token = new StringTokenizer(reader.readLine());
				int paper 		= Integer.parseInt(token.nextToken()); 
				int interview 	= Integer.parseInt(token.nextToken());
				array[paper] 	= interview;
			}
			int prev = Integer.MAX_VALUE;
			int answer = 0;
			for (int i = 1; i <= count; ++i) {
				if (prev >= array[i]) {
					prev = array[i];
					++answer;
				}
			}
			System.out.println(answer);
		}
	}
}