package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class question10799_sub {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int count =0;
		
		for(int i=0;i<s.length();i++) {
			if(s.substring(i,i+1).equals("("))
                stack.push(i);
			else { // ) 닫히는 괄호일 경우. 
				if(stack.peek() == i-1) { //전에 있던 괄호가 (라는 의미이므로 레이져가 완성된다.
					stack.pop();
					count+=stack.size(); // 그전에 있던 (의 개수가 레이저에 의해 잘리는 바의 개수임
					
				}else { // 레이저가 아닌 )에도 막대기가 한 덩어리씩 남는다고 생각해서 정답에 1을 추가한다는 것. 
					stack.pop();
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	
}
