package Test;
import java.io.*;
import java.util.*;
public class question16212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
