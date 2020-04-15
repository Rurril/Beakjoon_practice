package Test;
import java.io.*;
import java.util.*;
public class question1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		ArrayList<Integer> decimal = new ArrayList();
//		decimal.add(1); // 1은 소수가 아니라는 것을 생각하고 있어야 한다.
		decimal.add(2);
		for(int i=3; i<=1000;i++) {
			for(int j=0; j<decimal.size();j++) {
				if(i%decimal.get(j) == 0)break;//나머지가 0이라면 나누어떨어진다는 의미이므로 소수가 아니다.
				
				if(j==decimal.size()-1)decimal.add(i);
				 
			}
		}
		
		int count = 0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i] == 1) {				
				continue;
			}
			
			for(int j=0; j<decimal.size();j++) {
				if(arr[i] == decimal.get(j)) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}
