package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class question7662 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			
			
			
			int n = Integer.parseInt(br.readLine()); //명령어 개수. 
			
			for(int j=0;j<n;j++) {

				Queue<Integer> maxHeap = new PriorityQueue();
				Queue<Integer> minHeap = new PriorityQueue();
				String[] temp = br.readLine().split(" ");
				String command = temp[0];
				int num = Integer.parseInt(temp[1]);
				int cnt = 0;
				if(command.equals("I")) {
					cnt++;
					maxHeap.add(num*-1);
					minHeap.add(num);
				}else if(command.equals("D")) {
					
					if(cnt == 0) {
						maxHeap = new PriorityQueue();
						minHeap = new PriorityQueue();
						continue;
					}
					
					if(num == 1) { //최댓값에서 빼라는 것. 
						maxHeap.poll();
						cnt--;
					}else if(num == -1) { // 최솟값에서 뺴라는 것. 
						minHeap.poll();
						cnt--;
					}
				}
				
				
				// for문이 끝났을 때. 
				if(j==n-1) {
					if(cnt==0) { // 큐가 비었을 때. 
						bw.append("EMPTY" + "\n");
					}else {
						int max = maxHeap.poll()*-1;
						int min = minHeap.poll();
						bw.append(max + " " + min + "\n");
					}
				}
				
			}
			
			bw.flush();
			
			
			
			
		}
	}
}
