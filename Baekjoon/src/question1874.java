package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class question1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		boolean flag = true;
		ArrayList<String> al = new ArrayList();
		Stack<Integer> st = new Stack();
		
		
		for(int i=1;i<=n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(true) {
				
				if(!st.empty()) {
					if(st.peek() == num) {
						
						st.pop();
						al.add("-");						
						break;
					}
				}
				
				if(count > n) {
					flag = false;
					break;
				}
				
				st.add(count++);
				al.add("+");
				
				
			}
		}
		
		if(flag) {
			for(int i=0;i<al.size();i++) {
				System.out.println(al.get(i));
			}
		}else System.out.println("NO");
		
		
	}
}
