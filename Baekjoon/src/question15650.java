package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question15650 {
	
	static int n,m;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] temp  =br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int[] arr = new int[m];
		func(1, n,m, arr);
	}
	public static void func(int start, int end, int num, int[] arr) { //s부터 n까지 m개를 뽑아라. 
		
		if(num==0) {
			for(int i=0;i<m;i++)System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=start;i<=end;i++) {
//			System.out.println("this " + (m-num));
			arr[m-num] = i;
			func(i+1, end, num-1, arr);			
		}
		
	}
}
