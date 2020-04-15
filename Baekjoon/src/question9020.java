package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean[] check = new boolean[10001];
		check[1] = true;
		
		for(int i=2;i<=10000;i++) {
			for(int j=2;j*i<=10000;j++) {
				check[i*j] = true; //소수가 아니라는 뜻. 
			}
		}
		
		for(int i=0; i<n; i++) {
			int num = arr[i];
			int a = 0;
			int b = 0;
			
			for(int j=2; j<=num/2;j++) {
				if(!check[j]) {//소수라면.
					if(!check[num-j]) {// 뺴서 남은 수 또한 소수라면.
						a = j;
						b = num-j;
					}
				}
			}
			System.out.println(a +  " " + b);
		}
		
	}


}
