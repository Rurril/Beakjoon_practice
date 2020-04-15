package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class question1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue();
		StringBuilder sb = new StringBuilder();
		
		// 기본적으로 priorityQueue가 heap을 기반으로 만들어지다보니 구현되어있는 것을 사용하면 빠르다.
		// (잘 몰랐지만, 코드 분석하고 블로그들을 뒤져보면서 알게 되었다. )
		// 우선순위 큐는 설정 없이 사용했을 때, 최소힙처럼 작용한다.
		// 이렇게 우선순위 큐를 이용해서 쉽게 풀었지만, 한 번 나중에 구현해보도록 하겠다. 
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(br.readLine());
			if(k==0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				}else {

					sb.append(q.poll() + "\n");
				}
			}else {

				q.add(k);
			}
			
		}
		System.out.println(sb.toString());
	}
}
