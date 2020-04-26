package com.algo.self_200424;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_population {
	static int N,L,R;
	static int[][] m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=new int[N][N];
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				m[i][j]=Integer.parseInt(st.nextToken());
			}
			
		}
		while(true) {
			boolean change=false;
			if(!change) {
				
			}
		}
	}
}
