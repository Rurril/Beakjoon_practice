package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class question18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] before = new int[n];
		ArrayList<Integer> after = new ArrayList();
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			before[i] = Integer.parseInt(temp[i]);
			after.add(Integer.parseInt(temp[i]));
		}
		
		after.sort(null);
		
		int cnt = 0;
		while(true){
			
			int first = after.get(cnt);
			int second = after.get(cnt+1);
			
			if(first == second)after.remove(cnt);
			else cnt++;
			
			
			
			if(cnt == after.size()-1)break;
		}
		
//		for(int i=0;i<after.size();i++)System.out.print(after.get(i) + " ");
//		System.out.println();
		
		
		
		for(int i=0;i<n;i++) {
			
			int left = 0;
			int right = after.size()-1;
			int target = before[i];
			
			while(left <= right){
				int mid = (left+right)>>1;
				
				if(after.get(mid) < target)left = mid+1;	
				else if(after.get(mid) >= target)right = mid-1;
								
			}
			
			System.out.print(left + " ");
		}
		
	}
}
