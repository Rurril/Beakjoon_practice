package question11053;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int d[] = new int[n+1];
 
        d[1] = 1;
 
        String[] temp = new String[n];
		temp = br.readLine().split(" ");
		int[] list = new int[n];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(temp[i-1]);
		}
		
        for (int i = 2; i <= n; i++) {
            d[i] = 1;
            
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && d[i] <= d[j])
                    d[i] = d[j] + 1;
                else if (arr[i] == arr[j])
                    d[i] = d[j];
            }
        }
 
        int max = 0;
        for (int i = 1; i <= n; i++)
            max = Math.max(d[i], max);
 
        System.out.println(max);
 
    }
}
