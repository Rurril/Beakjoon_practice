package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] arr = br.readLine().split("");
		
		int result = 0;

		String temp = "";
		int testCase = 0; // 0은 시작, -1은 음수
		
		for(int i=0;i<arr.length;i++) {
			
//			System.out.println(result);
			
			if(i==arr.length-1) { //마지막 입력값 숫자. 
				if(testCase == -1)result -= Integer.parseInt(temp + arr[i]);
				else if(testCase == 0)result += Integer.parseInt(temp + arr[i]);
			}
			
			
			if(arr[i].equals("+")) {
				
				if(testCase == -1) {					
					result -= Integer.parseInt(temp);
					temp = "";
				}else if(testCase == 0){					
					result += Integer.parseInt(temp);
					temp = "";
				}
				
			}else if(arr[i].equals("-")){
				
				if(testCase == 0) {
					testCase = -1;
					result += Integer.parseInt(temp);;
					temp = "";
				}else if(testCase == -1) {					
					result -= Integer.parseInt(temp);
					temp = "";
				}
				
				
				
				
			}else { //숫자인 경우.
				temp += arr[i];
			}
			
		}
		
		System.out.println(result);
		
		
	}

}
