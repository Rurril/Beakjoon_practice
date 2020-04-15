package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] aArr = new int[n];
		for(int i=0;i<n;i++)aArr[i] = Integer.parseInt(temp[i]);
		
		Arrays.sort(aArr); //이진 탐색을 위한 오름차순 정렬.
		
		int m = Integer.parseInt(br.readLine());
		temp = br.readLine().split(" ");
		int[] bArr = new int[m];
		for(int i=0;i<m;i++)bArr[i] = Integer.parseInt(temp[i]);
		
		for(int i=0;i<m;i++) {
			int flag = 0;
			
			int max = n; //배열 기준으로 max 값을 선정한거네.
			int min = 0;
			int middle;
			
			while(max >= min) {
				
				middle = (max+min)/2;
//				System.out.println(max + " " + min + " " + middle);
				
				//while문 로직상 배열의 0번쨰 값은 확인이 불가능해서 강제로 삽입. 
				if(bArr[i] == aArr[0]) {
					flag =1;
					break;
				}
				
				if(bArr[i] == aArr[middle]) {
					flag = 1;
					break;
				}
				
				if(bArr[i] > aArr[middle])min = middle +1;
				else if(bArr[i] < aArr[middle])max = middle -1;
			}
			System.out.print(flag + " ");
		}
		
		
	}
}
