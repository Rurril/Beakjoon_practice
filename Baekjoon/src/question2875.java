package Test;
import java.io.*;
public class question2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		String[] temp = br.readLine().split(" ");
		
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		int count =0;
		while(arr[0]>=2 && arr[1] >=1) {
			arr[0] -= 2;
			arr[1] -= 1;
			count++;
		}
		
		arr[2] = arr[2] - arr[1] - arr[0];
		
		while(arr[2] > 0) {
			arr[2] -= 3;
			count--;
		}
		
		System.out.println(count);
	}
}
