package itDa;
import java.util.ArrayList;

public class ColorfulBoxesAndBalls {
	
	int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		
		//전체 탐색으로 구해야하는 부분.
			
		ArrayList<Integer> al = new ArrayList<Integer>();
		int count = 0;
		while(!(numRed < 0 || numBlue < 0)) { //둘 중 하나라도 true라면 끝!
			int value = numRed*onlyRed + numBlue*onlyBlue + count*bothColors; 
			al.add(value);
			
			numRed--;
			numBlue--;
			count += 2;			
		}
		
		al.sort(null);
		return al.get(al.size()-1);
	}
	
	public static void main(String[] args) {
		ColorfulBoxesAndBalls d = new ColorfulBoxesAndBalls();
		int a = d.getMaximum(9, 1, -1, -10, 4);
		System.out.println(a);
	}
}
