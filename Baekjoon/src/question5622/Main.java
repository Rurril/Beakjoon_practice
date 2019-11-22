package question5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		int time = 0;
		
		for(int i =0; i < a.length(); i++) {
			
			char temp = a.charAt(i);
			
			if(temp == 'A' || temp == 'B' || temp == 'C') time += 3;
			else if(temp == 'D' || temp == 'E' || temp == 'F') time += 4;
			else if(temp == 'G' || temp == 'H' || temp == 'I') time += 5;
			else if(temp == 'J' || temp == 'K' || temp == 'L') time += 6;
			else if(temp == 'M' || temp == 'N' || temp == 'O') time += 7;
			else if(temp == 'P' || temp == 'Q' || temp == 'R' || temp == 'S') time += 8;
			else if(temp == 'T' || temp == 'U' || temp == 'V') time += 9;
			else if(temp == 'W' || temp == 'X' || temp == 'Y' || temp == 'Z') time += 10;
			
			
		}
		
		System.out.println(time);
		
	}
}
