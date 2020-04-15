package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class quesiton1929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[2];
		
		for(int i=0;i<2;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		boolean[] check = new boolean[arr[1]+1];
		check[1] = true;
		
		for(int i=2;i<arr[1];i++) {
			for(int j=2;j*i<=arr[1];j++) {
				check[i*j] = true; //소수가 아니라는 뜻. 
			}
		}
		
		for(int i=arr[0];i<=arr[1];i++) {

			
			if(!check[i])System.out.println(i);
		}
		
	}

}
