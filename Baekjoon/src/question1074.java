package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1074 {
	
	
	static int count =0;
	static int r, c;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		r = Integer.parseInt(temp[1]);
		c = Integer.parseInt(temp[2]);
		int size = (int)Math.pow(2,n);
		
		
		
		search(0, 0, size);		
	}
	public static void search(int y, int x, int size) {
		
		if(size == 1) {
			if(y==r && x==c)System.out.println(count);
			
			count++;
			return;
		}else {
			
			search(y, x, size/2);
			search(y, x+size/2, size/2);
			search(y+size/2, x, size/2);
			search(y+size/2, x+size/2, size/2);
			
		}
		
		
	}
}
