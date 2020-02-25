package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_2490{


	
	public static void main(String[] args) throws IOException {
		char[] result = new char[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=0;t<3;t++) {
			
			st = new StringTokenizer(br.readLine());
			int count=0;
			int[] num = new int[4];
			num[0]= Integer.parseInt(st.nextToken());
			num[1]= Integer.parseInt(st.nextToken());
			num[2]= Integer.parseInt(st.nextToken()); 
			num[3]= Integer.parseInt(st.nextToken());
			for(int i=0;i<num.length;i++) {
				if(num[i]==0) {
					count++;
				}
			}
			
			if(count==1) result[t]='A';
			else if(count==2) result[t]='B';
			else if(count==3) result[t]='C';
			else if(count==4) result[t]='D';
			else if(count==0) result[t]='E';
		}
		for(int t=0;t<3;t++) {
			System.out.println(result[t]);
		}
	}


}
