package com.algo.self_200515;

import java.io.*;
import java.util.*;

public class bj1934 {
	static int N, M,GCD,GMP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			gcd(N,M);
			GMP=(N*M)/GCD;
			bw.write(GMP+"\n");
			
		}	
		bw.flush();
		bw.close();
	}

	private static void gcd(int a, int b) {
		if(b==0) {
			GCD = a;
			return;
		}else {
			int K = a%b;
			gcd(b,K);
		}
		
	}
}
