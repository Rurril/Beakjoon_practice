package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class question5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String[] res = new String[t];
		for(int i=0;i<t;i++) {
			
			String[] func = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> de = new LinkedList();			
			String[] temp = br.readLine().replace("[", "").replace("]", "").split(",");
			

			for(int j=0; j<n; j++) {
				if(n==0)break;				
				de.add(Integer.parseInt(temp[j]));
			}
			
			boolean flag = true;
			boolean error = false;
			for(int j=0;j<func.length;j++) {
				
				if(func[j].equals("R")) {
					flag = flag ? false : true; // 반대로 바꾼다.
					
				}else if(func[j].equals("D")) {
					
					if(de.size() < 1) {
						res[i] = "error";
						error = true;
						break;
					}
					
					if(flag) {
						de.removeFirst();
					}else {
						de.removeLast();
					}
				}				
			}
			
			
			
			if(!error){
				
				int size = de.size();
				int num = 0;
				
				res[i] = "[";
				for(int j=0;j<size-1; j++) {
					
					
					if(flag)num = de.removeFirst();
					else num = de.removeLast();
					
					res[i] += Integer.toString(num) + ",";
				}
				if(flag)num = de.removeFirst();
				else num = de.removeLast();
				
				res[i] += Integer.toString(num) + "]";
				
			}

			
		}
		for(int i=0;i<t;i++) {
			System.out.println(res[i]);
		}
		
		
		
	}
}
