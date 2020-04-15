package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class question18870_sub {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] before = new int[n];
		ArrayList<Integer> after = new ArrayList();
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(temp[i]);
			before[i] = num;
			after.add(num);
		}
		
		ArrayList<Integer> after2 = new ArrayList<>(new HashSet<>(after));

		Collections.sort(after2);
		
		for(int i=0;i<n;i++) {
			
			int left = 0;
			int right = after2.size()-1;
			int target = before[i];
			
			while(left <= right){
				int mid = (left+right)>>1;
				
				if(after2.get(mid) < target)left = mid+1;	
				else if(after2.get(mid) >= target)right = mid-1;
								
			}
			
			bw.write(left + " ");
		}
		
		bw.flush();
		
		
	}
}
