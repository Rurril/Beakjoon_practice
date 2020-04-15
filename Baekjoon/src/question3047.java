package Test;
import java.io.*;
import java.util.*;
public class question3047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];		
		String[] temp = br.readLine().split(" ");
		
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(arr);
		
		String[] abc = br.readLine().split("");
		
		
		for(int i=0;i<3;i++) { //a,b,c case 3개로 나누어서 분리 출력 끝.
			if(abc[i].equals("A")) {
				System.out.print(arr[0] + " ");
			}else if(abc[i].equals("B")) {
				System.out.print(arr[1] + " ");
			}else if(abc[i].equals("C")) {
				System.out.print(arr[2] + " ");
			}
		}
		
	}
}
