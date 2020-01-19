package itDa;

import java.util.ArrayList;

public class TargetNumber {
	
	public static int solution(int[] numbers, int target) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		int answer  = 0;
		
		al.add(numbers[0]);
		al.add(-numbers[0]);
		
		for(int i=1;i<numbers.length;i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
	
			for(int j=0; j<al.size();j++) {
				
				temp.add(al.get(j) + numbers[i]);
				temp.add(al.get(j) - numbers[i]);
				
			}
			
			al.clear();
			
			for(int j=0;j<temp.size();j++) {
				al.add(temp.get(j));
				
			}
			
		}
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i)==target)answer++;
		}
		
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	
}
