package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String[] arr;
		String[] result = new String[t];
		
		for(int i =0; i<t;i++) {
			String temp  =br.readLine();
			arr = new String[temp.length()];
			arr = temp.split("");
			
			int count = 0; 
			boolean flag = true;
			for(int j=0; j<arr.length;j++) {
				if(arr[j].equals(")"))count--;
				else if(arr[j].equals("("))count++;
				
				if(count==-1) { // ) 이 먼저 등장하게 되면 성립이 되지 않으므로 break;
					flag = false;
					break;
				}
			}
			
			if(count == 0)result[i] = "YES";
			else result[i] = "NO";
		}
		for(int i=0; i<t;i++) {
			System.out.println(result[i]);
		}
	}
}
