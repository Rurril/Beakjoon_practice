package Test;
import java.io.*;
import java.util.*;
public class question2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		list.sort(null);
		
		for(int i=0;i<N;i++) {
			System.out.println(list.get(i));
		}
		
	}

}
