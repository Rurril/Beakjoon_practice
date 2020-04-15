package Test;
import java.io.*;
import java.util.*;
public class question10610 {
	//너무 복잡하게 생각했다... 그냥 30의 배수이려면 0이 하나는 있어야하고, 모든 자리의 합이 3의 배수여야 하는 건데,,, 정수론.. 문제.
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		String[] temp = br.readLine().split("");
		long[] arr = new long[temp.length];
		boolean flag = false;
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(temp[i]);
			if(arr[i] == 0)flag = true;
		}
		
		if(flag) {
			long total =0;
			for(int i=0;i<arr.length;i++) {
				total = (total + arr[i])%3;
			}
			
			if(total%3 == 0) { //3으로 나누었을 때 나머지가 0이어야지 3의 배수.
				
				Arrays.sort(arr);
				
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[arr.length-i-1]);
				}
				
				
				
			}else {
				System.out.println(-1);
			}
		}else {// 0이 하나라도 없으면 불가능.
			System.out.println(-1);
		}
		
		

	}
	
	
	
}
