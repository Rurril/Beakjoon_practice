package question10250;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String[] result = new String[t];
		
		for(int i =0; i < t; i++) {
			
			String[] temp = br.readLine().split(" ");
			int height = Integer.parseInt(temp[0]);
			int width = Integer.parseInt(temp[1]);
			int number = Integer.parseInt(temp[2]);
			
			int count = 1;
			
			while(true) {
				if(number > height) {
					number -= height;
					count++;
				}else break;
			
			}
			String between = "";
			if(count <10)between = "0";	
			result[i] = (number + between + count);
			
		}
		
		for(int i=0; i< t; i++) {
			System.out.println(result[i]);
		}
		
	}
}
