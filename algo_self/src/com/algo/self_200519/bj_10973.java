package com.algo.self_200519;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_10973 {
	static boolean visited=true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int i=N-1;
		
		
		while(i>0 && arr[i-1]<arr[i]) i-=1;
		int j=N-1;
		if(i<=0) {
			visited=false;
		}else {
			while(j>0 && arr[i-1]<arr[j]) {
				j-=1;
			}
			int temp=0;
			if(j<=0) {
				visited=false;
			}else {
				temp=arr[i-1];
				arr[i-1]=arr[j];
				arr[j]=temp;
			}
			j=N-1;
			while(i<j) {
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
			
		}
		if(visited) {
			for(int t=0;t<N;t++) {
				bw.write(arr[t]+" ");
			}
			bw.write("\n");
		}else {
			bw.write("-1"+"\n");
		}
		
		
		bw.flush();
	}

}
