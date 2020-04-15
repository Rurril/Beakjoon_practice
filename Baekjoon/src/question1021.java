package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class question1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int[] arr = new int[m];
		temp = br.readLine().split(" ");
		
		for(int i=0;i<m;i++)arr[i] = Integer.parseInt(temp[i]);
		
		// 연산의 개수는 3가지. 
		
		Deque<Integer> de = new LinkedList();
		
		for(int i=1;i<=n;i++)de.add(i);
		
		int res = 0;
		for(int i=0;i<m;i++){
			int target = arr[i];
			int count = 0;
			
			while(true){
				
				// 원하는 값을 얻었으면 카운팅 계산 끝나고 그 값을 제거한다. 
				if(de.getFirst() == target) {
					res += Math.min(count, de.size()-count); //한 방향으로만 돌리고 계산은 각 방향에서 작은값.
					
//					System.out.println("res is  "  + res);
					de.removeFirst();
					break;
				}else { // 원하는 값을 얻지 못했다면 한 방향으로 돌린다.
					int tNum = de.removeFirst();
					de.addLast(tNum);
					count++;
				}
				
			}
		}
		System.out.println(res);
	}
}
