package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class question1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		ArrayList<String> words = new ArrayList();
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int cnt =0;
		temp = new String[n+m];
		for(int i=0;i<n+m;i++) {
			temp[i] = br.readLine();
		}
		
		Arrays.sort(temp);
		
		for(int i=0;i<temp.length-1;i++) {
			if(temp[i].equals(temp[i+1])) {
				cnt++;
				words.add(temp[i]);
			}
		}
		System.out.println(cnt);
		for(int i=0;i<words.size();i++)System.out.println(words.get(i));
		
		
		
	}
}
