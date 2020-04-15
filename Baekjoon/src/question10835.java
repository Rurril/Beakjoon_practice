package Test;
import java.io.*;
import java.util.*;
public class question10835 {
	
	static int n;
	static int[][] dp;
	static int[] left;
	static int[] right;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
//		ArrayList<Integer> left = new ArrayList<Integer>();
//		ArrayList<Integer> right = new ArrayList<Integer>();
		left = new int[n];
		right = new int[n];
		dp = new int[n][n];
		
		
		for(int i=0;i<n;i++) {
			Arrays.fill(dp[i], -1); // 배열 안에 있는 값들을 모두 -1로 채워넣는다. 
		}
		
		
		String[] temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			left[i]= Integer.parseInt(temp[i]);
		}
		
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			right[i]= Integer.parseInt(temp[i]);
		}
		
		// 끝나는 것은 왼쪽이나 오른쪽 둘 중 하나가 비었을 때.
		
		System.out.println(sol(0,0));
		
	}
	
	static int sol(int l, int r) {
        // 한쪽 카드 전부 소비
        if(l == n || r == n)
            return 0;
 
        // 이미 값이 있으면 중복해서 또 연산할 필요 없음
        if(dp[l][r] != -1)
            return dp[l][r];
 
        // 카드 두개 다 버리거나, 왼쪽 카드를 버리는 경우 중 큰 수
        dp[l][r] = Math.max(sol(l+1, r+1), sol(l+1, r)); // 와 DP 문제 이런식으로 푸는 거 오진다... 
        // 이렇게 재귀 방식으로 풀어서 쭉 내려가게 하는 거네... 
 
        // 만약 오른쪽 카드가 더 작다면 연산을 한번 더 해줌. 이 경우에는 오른쪽 카드 값을 더해서 계산
        if(left[l] > right[r])
            dp[l][r] = Math.max(dp[l][r], sol(l, r+1) + right[r]);
        
        return dp[l][r];
    }
}
