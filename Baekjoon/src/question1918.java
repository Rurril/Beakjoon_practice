package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class question1918 {//중위 표기법을 후위 표기법으로 만드는 차량기지 알고리즘 참고했음. 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Queue<String> q = new LinkedList();
		Stack<String> st = new Stack(); //연산자 스택.
		for(int i=0;i<arr.length;i++) {
			if(!arr[i].equals("+") && !arr[i].equals("-") && !arr[i].equals("/") && !arr[i].equals("*") 
					&& !arr[i].equals("(") && !arr[i].equals(")") ) {				
				q.add(arr[i]); // 출력 queue에다가 옮긴다.
			}else if(arr[i].equals(")")){ // 그 전에 있던 연산자 스택에서 꺼내오고, 괄호를 지울때까지 계속 팝해서 넣는다.
				
				while(!st.isEmpty()) {
					String temp = st.pop();
					if(temp.equals("("))	break;
					q.add(temp);
				}	
			}else if(arr[i].equals("(")){
				st.push(arr[i]);
			}
			else { //연산자끼리 우선순위가 정해져있기 때문에 같은 우선순위가 나온다면, 전에 있던 것을 먼저 팝해야한다.
				while(!st.isEmpty() && getPriority(st.peek()) >= getPriority(arr[i])) {
					q.add(st.pop());
				}
				st.push(arr[i]);
			}
				
		}
		
		while(!st.isEmpty()) {
			q.add(st.pop());
		}
		
		while(!q.isEmpty()) {
			System.out.print(q.remove());
		}
		
	}
	
	public static int getPriority(String a) {
		if(a.equals("("))return 0;
		else if(a.equals("+") || a.equals("-"))return 1;
		else return 2;
	}
}
