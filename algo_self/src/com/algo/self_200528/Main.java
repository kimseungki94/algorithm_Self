package com.algo.self_200528;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			if(N==0) {
				break;
			}else {
				arr = new int[N];
				for(int k=0;k<N;k++) {
					arr[k]=Integer.parseInt(st.nextToken());
				}
				judge(0,0);
				System.out.println();
			}
			
		}
		
	}
	private static void judge(int prev, int index) {
		if(index==N) {
			for(int k=0;k<N;k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
			return;
		}
		if(index<N) {
			if(prev>arr[index]) {
				return;
			}else {
				judge(arr[index],index+1);
			}
		}
		
	}

}
