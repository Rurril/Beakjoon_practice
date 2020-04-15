package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question11049_sub {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//https://blog.naver.com/PostView.nhn?blogId=phj8498&logNo=221340992241
		// 행렬곱셈순서 풀이 참고 블로그. 
		// 2차원 dp를 이용해서 풀었다. 
		int n = Integer.parseInt(br.readLine());
		int[][] m = new int[501][501];
		int[] d = new int[1001];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			
			d[i] = Integer.parseInt(temp[0]);
			d[i+1] = Integer.parseInt(temp[1]);
		}
		
		for (int len = 2; len <= n; len++)
        {
            for (int i = 1; i <= n - len + 1; i++)
            {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                {
                    int cost = m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j];
                    m[i][j] = Math.min(m[i][j], cost);
                }
            }
        }
        System.out.println(m[1][n]);

	}
}
