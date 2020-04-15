package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[t];
		
		for(int i=0;i<t;i++) {
			
			String[] temp = br.readLine().split(" ");
			
			int n = Integer.parseInt(temp[0]); // 문서의 개수.
			int m = Integer.parseInt(temp[1]); // 찾는 위치.
			int count = 0;
			temp = br.readLine().split(" ");
			int[] priority = new int[n];
			
			for(int j=0;j<n;j++)priority[j] = Integer.parseInt(temp[j]);
			
			Queue<Integer> q = new LinkedList();
			
			for(int j=0;j<n;j++)q.add(j);
			
			while(true) {		
				
				int num = q.poll();
				int pri = priority[num];
				boolean flag = true;
				boolean bFlag = false; 
								
				for(int j=0;j<n;j++) {
					if(priority[j] > pri) flag = false; //프린트할 수 없음.
				}
				
				if(flag) { // 우선순위가 가장 높으므로 프린트 가능.
					
					count++;
					priority[num] = -1; //뽑은 것은 중요도 최저이하로 낮춤.
					if(num == m)bFlag = true;
					
				}else { // 다시 뒤로 보낸다. 
					q.add(num);
				}
				
				if(bFlag)break;
				
				
			}
			result[i] = count;
			
		}
		
		for(int i=0;i<t;i++)System.out.println(result[i]);
		
	}
}
