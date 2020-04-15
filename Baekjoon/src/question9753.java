package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class question9753 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[50001]; // 소수 아닌것에 체크 배열.
		
		arr[0] = true;
		arr[1] = true;
		arr[2] = false;
		
		
		for(int i=2;i<=50000;i++) {
			if(arr[i] == false) {
				for(int j=i*2; j<=50000;j+=i) {		
					arr[j] = true; 
				}
			}			
		}
		
		ArrayList<Long> prime = new ArrayList();
		ArrayList<Long> duo = new ArrayList();
		for(int i=1;i<=50000;i++) {
			if(!arr[i])prime.add((long)i); // 소수 구하기.
		}
				
		for(int i=0;i<prime.size();i++) {
			for(int j=i+1;j<prime.size();j++) {
				
				long k = prime.get(i)*prime.get(j);
				duo.add(k);
				if(k>100000)break; // 10만 넘은 최소수까지 리스트에 들어간 것이므로. 
			}
		}
				
		duo.sort(null);
		
		// 찾는 과정을 이분탐색으로 만든 것 만으로도 채점에 걸리는 속도가 10분의 1로 줄어들었다.
		// 정렬된 배열에서 이분탐색을 사용하는 것은 당연한 것인 듯 싶다. 
		long[] result = new long[t];
		
		for(int i=0;i<t;i++) {
			
			int n = Integer.parseInt(br.readLine());
			int left = 0;
			int right = duo.size()-1;
			
			while(right>= left) {
				
				int mid = (right+left)/2;
//				System.out.println(left + " " + right + " " + duo.get(mid));
				if(duo.get(mid) >= n)right = mid-1;
				else if(duo.get(mid) < n)left = mid+1;
							
			}
			
			
			result[i] = duo.get(left);
			
		}
		
		for(int i=0;i<t;i++)System.out.println(result[i]);
		
	}
}
