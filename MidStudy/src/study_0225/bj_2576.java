package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_2576{


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum=0,min=0;
		int[] num = new int[7];
		for(int t=0;t<7;t++) {
			st = new StringTokenizer(br.readLine());
			num[t]=Integer.parseInt(st.nextToken());
		}
		for(int t=0;t<7;t++) {
			if(min<num[t] && num[t]%2==1) {
				min=num[t];
			}
		}
		
		for(int t=0;t<7;t++) {
			if(min>num[t] && num[t]%2==1) {
				min=num[t];
			}
			if(num[t]%2==1) {
				sum+=num[t];
			}
			
		}
		if(min%2==0 || sum==0) {
			System.out.println("-1");
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
		
		
	}
}
