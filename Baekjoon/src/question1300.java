package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question1300 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

   
        // x : x까지의 수가 k개 이상인 가장 작은 수

        int left = 1;
        int right = (int) Math.min((long) N * N, (long) 1000000000);
        int mid;
        int ans = 0;

        while (left <= right) {

            mid = (left + right) / 2;

            int cnt = getCnt(mid, N);

            if (cnt >= K) { // 같거나 작은 값을 더 많이 포함한다는 것이므로 right를 줄임으로써 mid값을 줄여야한다.

                ans = mid;
                right = mid - 1;
                
            } else { // 카운트 값이 모자라므로 mid를 키워서 더 많은 cnt값을 얻어야 한다. 

                left = mid + 1;
            }
        }

        System.out.println(ans);
	
		
	}
	static int getCnt(int x, int N) {

        int cnt = 0;

        for (int i = 1; i <= N; i++) {

            cnt += Math.min(x / i, N);
        }

        return cnt;

	}
	
}
