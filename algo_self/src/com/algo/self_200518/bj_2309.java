package com.algo.self_200518;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2309{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = null;
		int[] people = new int[9];
		int sum=0;
		//st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<9;i++) {
			people[i]=Integer.parseInt(br.readLine());
			sum+=people[i];
		}
		Arrays.sort(people);
		L:for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-(people[i]+people[j])==100) {
					for(int k=0;k<9;k++) {
						if(k==j || k==i) continue;
						bw.write(people[k] + "\n");
						
					}
					
					break L;
				}
			}
		}
		bw.flush();
	}
	
}