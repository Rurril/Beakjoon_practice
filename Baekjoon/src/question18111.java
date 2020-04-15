package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class question18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int b = Integer.parseInt(temp[2]);
		int max = 0;
		int min = Integer.MAX_VALUE;
		int t_result = Integer.MAX_VALUE;
		int h_result = 0;
		int[][] map = new int[n][m];
		
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				int num = Integer.parseInt(temp[j]);
				map[i][j] = num;				
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}

		if(n == 0 || m == 0)System.out.println(0 + " " + 0);
		else {
			
			 for (int i = min; i <= max; i++)
			    {
			        int time = 0;
			        int block = b;
			        for (int j = 0; j < n; j++)
			        {
			            for (int k = 0; k < m; k++)
			            {
			                int height = map[j][k]-i;
			                if (height > 0)
			                {
			                    time = time + height * 2;
			                    block = block + height;
			                }
			                else if (height < 0)
			                {
			                    time = time - height;
			                    block = block + height;
			                }
			            }
			        }
			        if (block >=0)
			        {
			            if (time <= t_result)
			            {
			            	t_result = time;
			                h_result = i;
			            }
			        }
			    }		
			System.out.println(t_result + " " + h_result);
		}
			
	}
}	
