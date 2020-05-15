package com.algo.self_200515;

import java.io.*;
import java.util.*;

public class bj_9613 {
	static int[] array;
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		// 테스트캐이스 횟수
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int testcase = Integer.parseInt(st.nextToken());
			array = new int[101];
			// 세부적인 테스트캐이스 횟수
				for(int s=0;s<testcase;s++) {
					array[s]=Integer.parseInt(st.nextToken());
				}
					for(int i=0;i<testcase-1;i++) {
						if(i+1<testcase) {
							for(int j=i+1;j<testcase;j++) {
								gcd(array[i],array[j]);
							}
						}else continue;		
					}
				bw.write(result+"\n");
				result=0;
			
		}	
		bw.flush();
		bw.close();
	}

	private static void gcd(int a, int b) {
		if(b==0) {
			result+= a;
			return;
		}else if(a==0 && a==0){
			result+=0;
			return;
		}else {
			int K = a%b;
			gcd(b,K);
		}
		
	}
}
