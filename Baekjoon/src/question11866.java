package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q1 = new LinkedList();
		
		Queue<Integer> res = new LinkedList();
		
		for(int i=1;i<=n;i++) {
			q1.add(i);
		}
		
		int count =0;
		while(true) {
			
			if(q1.isEmpty())break;
			
			count++;
			int deadOrAlive = q1.poll();
			System.out.println(deadOrAlive);
			
			if(count == k) {
				res.add(deadOrAlive);
				count = 0;
			}else {
				q1.add(deadOrAlive);
			}
		}
		
		System.out.print("<");
		for(int i=0;i<n-1;i++) {

			System.out.print(res.poll() + ", ");
		}
		System.out.println(res.poll() + ">");
		
	}
}
