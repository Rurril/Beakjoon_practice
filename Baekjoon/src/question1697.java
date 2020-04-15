package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		boolean[] check = new boolean[100001];
		Queue<Dot2> q = new LinkedList();
		q.add(new Dot2(n, 0));
		
		if(n > k) {
			System.out.println(n-k);
		}else {
			int min = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				Dot2 next = q.poll();
				
				int time =next.time;
				int location = next.location;
				check[location] = true;
				
				if(location == k) { // 바로 양 옆이라면 계산할필요 없이 끝. 
					 min = time;
					 break; // 가장 먼저 도달한 Dot이 최소값이므로. 
				}else {
					if(location < 100000)
						if(!check[location+1])q.add(new Dot2(location+1, time+1));
					if(location > 0)
						if(!check[location-1])q.add(new Dot2(location-1, time+1));
					if(location <= 50000) {
						if(!check[location*2])q.add(new Dot2(location*2, time+1));
					}
									
				}
				
			}
			
			System.out.println(min);
		}
		
		
		
	}
}

class Dot2 {
	int location;
	int time;
	
	Dot2(int location, int time){
		this.location = location;
		this.time = time;
	}
}
