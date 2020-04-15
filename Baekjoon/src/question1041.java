package Test;
import java.io.*;
import java.util.*;
public class question1041 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		long[] numbers = new long[6];
		long[] mins = new long[3];
		String[] temp = br.readLine().split(" ");
		
		for(int i=0;i<6;i++) {
			numbers[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=0;i<3;i++) {
			mins[i] = Math.min(numbers[i], numbers[5-i]); //마주보는 값 중에서 작은 것을 선택해야함.
		}
		Arrays.sort(numbers);
		Arrays.sort(mins);
		
		long threeBlock = 4;
		long twoBlock = 4 + (n-2)*8;
		long oneBlock = 5*n*n -16*n +12;
		
		//이 부분이 작은 숫자들을 구하는게 아니라, 주사위다 보니까 마주보는 값 중에서 작은 값들을 선택해야하는 구나...
		long min3 = mins[0] + mins[1] + mins[2];
		long min2 = mins[0] + mins[1];
		long min1 = mins[0];
		
		long result =0;
		if(n==1) {
			for(int i=0;i<5;i++) {
				result+= numbers[i];
			}
		}else {
			result = threeBlock*min3 + twoBlock*min2 + oneBlock*min1;
		}
		
		
		System.out.println(result);
	}
}
