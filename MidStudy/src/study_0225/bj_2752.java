package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_2752{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num=new int[3];
		num[0]= Integer.parseInt(st.nextToken());
		num[1]= Integer.parseInt(st.nextToken());
		num[2]= Integer.parseInt(st.nextToken());
		int temp=0;
		Arrays.sort(num);;
		for(int i=0;i<3;i++) {
			System.out.print(num[i]+" ");
		}
	}



}
