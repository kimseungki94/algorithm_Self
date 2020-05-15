package com.algo.self_200515;

import java.io.*;
import java.util.*;

public class bj_1978 {
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int t=1;t<=T;t++) {
			int num = Integer.parseInt(st.nextToken());
			judge(num);
		}	
		count = T-count;
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}

	private static void judge(int a) {
		if(a==1 || a==0) {
			count++;
			return;
		}else if(a==2){
			return;
		}else {
			for(int i=2;i*i<=a;i++) {
				if(a%i==0) {
					count++;
					return;
				}else {
					continue;
				}
			}
		}	
	}
}
