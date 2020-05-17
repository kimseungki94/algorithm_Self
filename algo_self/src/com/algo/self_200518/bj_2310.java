package com.algo.self_200518;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_2310{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int E=0,S=0,M=0;
		int e=0,s=0,m=0;
		int year=0;
		st = new StringTokenizer(br.readLine(), " ");
			E=Integer.parseInt(st.nextToken());
			S=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			
		L:while(true) {
			if(E==e && S==s && M==m) {
				bw.write(year+"\n");
				break L;
			}
			e+=1;
			s+=1;
			m+=1;
			year++;
			if(e==16) e=1;
			if(s==29) s=1;
			if(m==20) m=1;
		}
		bw.flush();
	}
	
}