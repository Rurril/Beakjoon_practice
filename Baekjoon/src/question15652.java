package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class question15652 {
	
	static int n,m;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		String [] temp  =br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		int[] arr = new int[m];
		func(1, n,m, arr);
		bw.write(sb.toString().trim());
		bw.close();
		br.close();
	}
	public static void func(int start, int end, int num, int[] arr) { //s부터 n까지 m개를 뽑아라. 
		
		if(num==0) {
			for(int i=0;i<m;i++)sb.append(Integer.toString(arr[i]) + " ");
			sb.append("\n");
			
			return;
		}
		
		for(int i=start;i<=end;i++) { // 1, 4, 2, res
			
			arr[m-num] = i;
			
			func(i, end, num-1, arr);			
		}
		
	}
}




