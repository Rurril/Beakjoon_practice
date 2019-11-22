package question1316;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int count = 0;
		
		
		for(int i =0; i < n; i++) {
			String temp = br.readLine();
			
			ArrayList<Character> al = new ArrayList<Character>();
			for(int j=0; j < temp.length(); j++) {
				if(!al.contains(temp.charAt(j))) {//갖고 있지 않다면.
					al.add(temp.charAt(j));	
				}else {//갖고 있다면 2가지 경우의 수 중 하나이다.
					if(temp.charAt(j) == al.get(al.size()-1))continue;
					else {
						count--;
						break;
					}
				}
			}
			count++;
			
		}
		System.out.println(count);
	}
}
