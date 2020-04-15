package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class question10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList al = new ArrayList();
		
		Stack<Integer> st = new Stack();
		for(int i=0;i<n;i++) {
			
			String[] temp = br.readLine().split(" ");
			
			if(temp.length == 2) {
				String order = temp[0];
				int num = Integer.parseInt(temp[1]);
				
				st.add(num);
			}else {
				
				if(temp[0].equals("top")) {
					
					if(st.size() == 0)al.add(-1);
					else al.add(st.peek());
				}else if(temp[0].equals("pop")) {
					if(st.size() == 0)al.add(-1);
					else al.add(st.pop());
				}else if(temp[0].equals("size")) {
					al.add(st.size());
				}else if(temp[0].equals("empty")) {
					if(st.empty())al.add(1);
					else al.add(0);					
				}
				
			}
		}
		
		for(int i=0; i< al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
}
