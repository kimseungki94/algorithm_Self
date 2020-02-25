package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_10804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[21];
		int[] start = new int[21];
		int[] end = new int[21];
		
		for(int i=1;i<=20;i++) {
			arr[i]=i;
		}	
		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
			int temp=0;
			for(int j=start[i];j<=end[i];j++) {
				for(int k=end[i];k>j;k--) {
					temp=arr[k];
					arr[k]=arr[k-1];
					arr[k-1]=temp;
					
				}
			}
					
		}
		
		
	}
}
