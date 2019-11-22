package question15649;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 수열을 뽑아내는 문제다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] array = new int[n];
		int[] result = new int[m];
		for(int i =0; i < n; i++) {
			array[i] = i+1;
		}
		
		
		
		func(array, result, m);
		
		
	}
	
	public static void func(int[] array, int[] result, int m) {
		
		if(m==0) {
			if(result[0]==0)return;
			
			for(int i=result.length-1; i >= 0; i--) {	
				System.out.print(result[i]);
				if(i!=0)System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i < array.length; i++) {
			if(array[i]==0)continue;
			
			result[m-1] = array[i];
			array[i] = 0;
			m--;
			func(array,result,m);
			array[i] = i+1;
			m++;
			result[m-1] = 0;
			
		}
		
	}

}
