package itDa;

public class programmers_week2 {
	public static void main(String[] args) {
		System.out.println(solution(6));
	}
	
	public static long solution(int N) {
		long answer = 1;
		
		long first = 1;
		long second = 1;
		
		for(int i=2;i<N;i++) {
			long temp1 = first;
			long temp2 = second;
			first = temp2;
			second = temp1+temp2;
		}
		answer = first*2 + second*4;
		return answer;
	}
}
