package question1697;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int x = Integer.parseInt(temp[1]);
		
		
	}
	
	class spot{
		int location;
		int time;
		
		spot(int location, int time){
			this.location = location;
			this.time = time;
		}
	}
	
}
