package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class question11049 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<colRow> ll = new ArrayList();
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			ll.add(new colRow(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
		}
		int sum = 0;
		while(true) {
			
			if(ll.size()==1)break;
			
//			System.out.println("Test");
//			for(int i=0;i<ll.size();i++) {
//				System.out.println(ll.get(i).row + " " + ll.get(i).col);
//			}
			
			
			int min = Integer.MAX_VALUE;
			int order = -1;
			for(int i=0;i<ll.size()-1;i++) {
				if(ll.get(i).row * ll.get(i+1).col < min) { // 합쳐지는 행렬의 크기가 가장 작은것. 
					min = ll.get(i).row * ll.get(i+1).col;
					order = i;
				}
//				System.out.println(min);
			}
			int temp1 = ll.get(order).col;
			int temp2 = ll.get(order).row;
			int temp3 = ll.get(order+1).col;
			sum += temp1*temp2*temp3;
			ll.remove(order); // 한칸씩 땡겨서 다시 쓰기한다. 
			ll.set(order, new colRow(temp2, temp3));
		}
		
		System.out.println(sum);
	}
}

class colRow{
	
	int row;
	int col;
	
	colRow(int row, int col){
		this.row = row;
		this.col = col;
	}
}
