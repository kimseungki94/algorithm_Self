package com.algo.self_200515;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String init = br.readLine();
		int len = init.length();
		array = new int[len];
		
		for(int i=0;i<len;i++) {
			array[i]=init.charAt(i)-'0';
		}
		//자리수가 하나인경우
		if(len==1) {
			bw.write(array[0]+"\n");
		}
		//자리수가 짝수일경우
		if(len%2==0) {
			//중간기준 왼쪽이 오른쪽보다 클때
			if(array[len/2]<array[(len/2)-1]) {
				for(int i=0;i<len/2;i++) {
					array[len-1-i]=array[i];
				}
			}
			//중간기준 왼쪽이 오른쪽보다 작을때
			else {
				
			}
			for(int i=len/2;i>=0;i--) {
				
			}
		}else {
			
		}
		for(int i=0;i<len;i++) {
			bw.write(array[i]+"\n");
		}
		bw.write("\n");
		
		
		while(true) {
			for(int i=0;i<array.length;i++) {
				sb.append(array[i]);
			}
			String b = sb.toString();
			String a = sb.reverse().toString();
			if(a.equals(b)) {
				bw.write(a+"\n");
				break;
			}else {
				array[array.length-1]=array[array.length-1]+1;
				if(array[array.length-1]==10) {
					L:while(true) {
						for(int i=1;i<=array.length;i++) {
							if(array[array.length-i]==10) {
								array[array.length-i]=0;
								array[array.length-i-1]+=1;
								if(array[array.length-i-1]==10) {
									continue;
								}else {
									break L;
								}				
							}
						}
					}
				}	
				sb.delete(0, sb.length());
			}
		}
		bw.flush();
		bw.close();
	}
}
