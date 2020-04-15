package Test;
import java.util.*;
class question16433 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		String[][] map = new String[N][N];
		int temp = (R+C)%2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if((i+j)%2 == temp)map[i][j] = "v";
				else map[i][j] = ".";
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
	}

}
