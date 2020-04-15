package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class question11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[21];
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split(" ");
			
			if(temp.length == 1) { // all과 empty 명령어가 있다.
				if(temp[0].equals("all")) {
					for(int j=1;j<=20;j++)arr[j] = true;
				}else if(temp[0].equals("empty")) {
					for(int j=1;j<=20;j++)arr[j] = false;
				}
			}else { // add, remove, check, toggle 명령어가 있다.
				
				int num = Integer.parseInt(temp[1]);
				
				if(temp[0].equals("add")) {
					arr[num] = true;
				}else if(temp[0].equals("remove")) {
					arr[num] = false;
				}else if(temp[0].equals("check")) {
					if(arr[num])bw.write("1\n");
					else bw.write("0\n");					
				}else if(temp[0].equals("toggle")) {
					arr[num] = arr[num] ? false : true;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
