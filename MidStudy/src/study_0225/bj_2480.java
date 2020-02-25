package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_2480{


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num;
		num= Integer.parseInt(st.nextToken());
		if((num%4==0 && num%100!=0) || num%400==0 ) System.out.println("1");
		else System.out.println("0");
		
	}



}
