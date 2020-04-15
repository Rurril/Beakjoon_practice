package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] bar = br.readLine().split("");
		
		int numberOfBar= 0;
		for(int i=0;i<bar.length;i++) {
			if(bar[i].equals("(")) {
				int left = 0;
				int right = 0;
				int laser = 0;
				if(bar[i].equals("(") && bar[i+1].equals(")"))continue;
				
				left++;
				for(int j=i+1;j<bar.length;j++) {
					if(bar[j].equals("(") && bar[j+1].equals(")"))laser++;
					
					if(bar[j].equals("("))left++;
					else if(bar[j].equals(")"))right++;
					
					if(left==right)break;
				}
				
				if(laser!=0)numberOfBar += (laser+1);
			}
		}
		
		System.out.println(numberOfBar);
	}
}
