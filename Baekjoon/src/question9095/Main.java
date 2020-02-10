package question9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] result = new int[n];
		
		
		for(int i=0;i<n;i++) {
			int target = Integer.parseInt(br.readLine());
			
			result[i] = func(target);
			
			
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(result[i]);
		}
	}
	
	public static int func(int target) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp == target)count++;
			if(temp > target)continue;
			
			q.offer(temp+1);
			q.offer(temp+2);
			q.offer(temp+3);
		}
		
		return count;
	}
}
