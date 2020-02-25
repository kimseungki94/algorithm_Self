package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_2562{


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max=0,min=0;
		int[] num = new int[9];
		for(int t=0;t<9;t++) {
			st = new StringTokenizer(br.readLine());
			num[t]=Integer.parseInt(st.nextToken());
		}
		
		min=num[0];
		for(int t=0;t<9;t++) {
			if(max<num[t]) {
				max=num[t];
				min=t;
			}
			
		}
		System.out.println(max);
		System.out.println(min+1);
		
	}
}
