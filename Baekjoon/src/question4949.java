package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class question4949 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> al = new ArrayList();
		while(true) {
			
			String[] arr = br.readLine().split("");
			Stack<String> st = new Stack();
			boolean flag = true;
			
			if(arr.length == 1 && arr[0].equals("."))break;
			
			
			for(int i=0;i<arr.length;i++) {
				String temp = arr[i];
				
				if(temp.equals("(")) {
					st.add(temp);
				}else if(temp.equals("[")) {
					st.add(temp);
				}else if(temp.equals(")")) {
					if(st.empty()) {
						flag = false;
						break;
					}
					
					if(st.pop().equals("("))continue;
					else {
						flag = false;
						break;
					}
				}else if(temp.equals("]")) {
					if(st.empty()) {
						flag = false;
						break;
					}
					
					if(st.pop().equals("["))continue;
					else {
						flag = false;
						break;
					}
				}
			}
			
			if(flag) {
				al.add("yes");
			}else {
				al.add("no");
			}
			
		}
		
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		
		
	}
}
