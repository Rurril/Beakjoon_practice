package Test;
import java.io.*;
public class question11060 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		int point = 0;
		int count = 0;
		
		while(true) {
			
			
			
			count++;
			System.out.println("point is this " + point);
			
			if(arr[point] == 0) { //더 이상 움직이지 못하는 경
				count = -1;
				break;
			}
			
			int maxPoint =0;
			
			for(int j=0; j<arr[point];j++) { // 어디 칸으로 점프하는 것이 제일 나은지 확인.
				
				
				if(point + arr[j] == n-1)break; // 끝에 도달했다면.
								
				if(maxPoint < j+arr[point+j])maxPoint = point + j + arr[point+j]; //max 도달값. 
				
			}
			
			if(maxPoint>=10)break;
			
			point = maxPoint;
			
		}
		System.out.println(count);
		

	}
}
