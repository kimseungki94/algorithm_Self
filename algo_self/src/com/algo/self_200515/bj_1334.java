package com.algo.self_200515;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_1334 {
	static int[] array,temp_array;
	static int[] temple;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String init = br.readLine();
		
		int len = init.length();
		boolean f = false;
		array = new int[len];
		temp_array = new int[len];
		temple = new int[len];
		
		for(int i=0;i<len;i++) {
			array[i]=init.charAt(i)-'0';
			temp_array[i]=init.charAt(i)-'0';
		}
		
		for(int i=0;i<len;i++) {
			sb.append(array[i]);
		}
		for(int i=0;i<len;i++) {
			temple[i]=9;
		}
		for(int i=0;i<len;i++) {
			sb2.append(temple[i]);
		}
		// 자리수 최상단 값이면
		if(sb.toString().equals(sb2.toString())) {
			for(int i=0;i<len;i++) {
				array[i]=0;
			}
			array[0]=1;
			sb.delete(0, sb.length());
			// 기존꺼와 자리수 비교
			for(int i=0;i<len;i++) {
				sb.append(array[i]);
			}
			sb.append(1);
			bw.write(sb+"\n");
		}else {
			for(int i=len-1;i>=len/2;i--) {
				array[i]=array[len-i-1];
			}
			for(int i=0;i<len;i++) {
				if(array[i]!=temp_array[i]) {
					f=array[i]>temp_array[i];
					break;
				}
				
			}
			for(int i=len/2;!f && i <len;i++) {
				if(array[i]>temp_array[i] || array[len-i-1] > temp_array[len-i-1]) {
					break;
				}
				if(array[i]==9) {
					if(len%2==1 || i != len/2) {
						array[len-i-1] = 0;
						array[i]=0;
						continue;
					}
				}
				if(array[i]<=temp_array[i]) {
					if(i!=len-i-1) {
						array[len-i-1]++;
						array[i]++;
						i--;
					}
				}
			}
			sb.delete(0, sb.length());
			for(int i=0;i<len;i++) {
				sb.append(array[i]);
			}
			bw.write(sb+"\n");
		}
		
		
		bw.flush();
		bw.close();
	}
}
