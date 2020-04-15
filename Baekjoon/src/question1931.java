package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class question1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] conference = new int[n][2];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			conference[i][0] = Integer.parseInt(temp[0]);
			conference[i][1] = Integer.parseInt(temp[1]);
		}

		Arrays.sort(conference, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1] == arg1[1]) {
                    return arg0[0] - arg1[0];
                } else {
                    return arg0[1] - arg1[1];
                }
            }
        });    
		
//		for(int i=0;i<n;i++) {
//			System.out.println(conference[i][0] + " " + conference[i][1]);
//		}
		
		int count = 1;
		
		int end = conference[0][1];
		for(int i=1;i<n;i++) {
			
//			System.out.println(start + " " + end);
			
			if(conference[i][0] >= end) {
				end = conference[i][1];
				count++;
			}
			
		}
		
		System.out.println(count);
		
	}
}
