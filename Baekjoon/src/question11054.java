package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11054 {
	
	static int[] arr;
	static int[] dpU;
	static int[] dpD;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); 
		
		arr = new int[n];
		dpU = new int[n];
		dpD = new int[n];
		String[] temp = br.readLine().split(" ");
		
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		dpD[0] = 0;
		dpU[n-1] = 0;
		//(-->) 방향으로 찾기 -- 수열의 숫자가 오른쪽으로 작아져야함.
		for(int i=n-1;i>=0;i--) {
			
			for(int j=i+1;j<n;j++) {
				if(arr[j] < arr[i])
					dpU[i] = Math.max(dpU[i],  dpU[j]+1);
					
			}
		}
		//(<--) 방향으로 찾기 -- 수열의 숫자가 오른쪽으로 커져야함. 
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i])
					dpD[i] = Math.max(dpD[i], dpD[j]+1); // 배열 값이 arr[i]가 더 크다면 
			}
			
		}
		
		int result = 0;
		
		for(int i=0;i<n;i++) {
			result = Math.max(result, dpD[i] + dpU[i]);
		}
		
		System.out.println(result+1);
	}
	
}
