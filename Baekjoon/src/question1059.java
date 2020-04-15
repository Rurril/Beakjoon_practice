package Test;
import java.io.*;
import java.util.*;
public class question1059 {
	
//	static int[][] map;
	static int start;
	static int end;
	static int item;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] set = new int[n+1];
		String[] temp = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			set[i] = Integer.parseInt(temp[i]);
		}
		
		item = Integer.parseInt(br.readLine());
		
		boolean flag = false;
		for(int i=0;i<n;i++) {
			if(set[i] == item)flag = true;
		}
		
		if(flag) { // 같은 숫자가 껴있다면, 셋은 존재할 수가 없으므로 그냥 0 출력
			System.out.println(0);
		}else {
			set[n] = item;
			Arrays.sort(set);
			int order = 0;
			
			for(int i=0;i<n+1;i++) { // 아 만약에 같은 숫자가 나오게 되면...? 
				if(set[i] == item)order = i;
			}
			
			start = set[order-1];
			end = set[order+1];
			
			int count =0;
		
			for(int i=start+1;i<end;i++) {
				for(int j=i+1;j<end;j++) {
					
					if(i<=item && item <= j) {
						count++;
//						System.out.println(i + " " +j);
					}

				}
			}
			System.out.println(count);

		}
		
		
	}

}
