package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question3020 {
	
	static int n,h;
	static int[] border1;
	static int[] border2;
	static int max1,max2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		h = Integer.parseInt(temp[1]);
		
		border1 = new int[n/2];
		border2 = new int[n/2];
		
		
		for(int i=0;i<n;i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(i%2 ==0)border1[i/2] = num; // 아래에서 솟는 석순.
			else border2[i/2] = num; //위에서 나오는 종유석. 
			
		}
		br.close();
		Arrays.sort(border1);
		Arrays.sort(border2);
		
		max1 =border1[n/2-1];
		max2 =border2[n/2-1];
		
		for(int a : border1)System.out.print(a + " " );
		System.out.println();
		for(int a : border2)System.out.print(a + " " );
		System.out.println();
		int sum = n;
		int cnt = 0;
		for(int i=1;i<=h;i++) {
			
			int a = binarySearch1(i)+1; //부숴진 종유석 개수.
			System.out.println("test1");
			int b = binarySearch2(i)+1; //부숴진 석순 개수.
			System.out.println("test2");
			if(a+b == sum)cnt++;
			else if(a+b > sum){
				continue;
			}else if(a+b < sum) {
				sum = a+b;
				cnt = 1;
			}
		}
		
		System.out.println(sum + " "+ cnt);
		
		
	}
	
	static int binarySearch2(int height) { //height는 구간. 기준.
		
		//heigth 보다 같거나 작은 최댓값. 
		int min = 0;
		int max = (n/2)-1;
		int mid = 0;
		int ret = 0;
		while(max >= min) {
			
			if(max2 > height) { //무한 루프에 돌게 됨.		
				break; 
			}
			
			mid = (max + min)/2;
			
			if(border2[mid] > height)max = mid+1; // 
			else if(border2[mid] <= height) {
				min = mid-1; //석순기준으로 다 잘리는 것.
				ret = Math.max(ret, mid);
			}
			// height와 같거나 작은 것중 최댓값을 찾아야한다. 
		}
		
		
		return ret;
	}
	static int binarySearch1(int height) { // 종유석 잘리는 기준을 찾아야한다. 
		
		int min = 0;
		int max = (n/2)-1;
		int mid = 0;
		int ret = 0;
		while(max >= min) {
			
			if(max1 + height <= h) {
				break;
			}
			
			mid = (max + min)/2;
			
			if(border1[mid] + height > h) { //높이보다 크면 잘리는 것. 
				min = mid-1;
				ret = Math.max(ret, mid);
			}else if(border1[mid] + height <= h){
				max = mid+1;
			}
	
		}
		
		return ret;
	}
}
