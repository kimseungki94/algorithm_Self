package com.algo.self_200323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class swea {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int K = 0;
		double result = 0;
		String[] array= null;
		int[] arr = null;
		for(int t=0; t<T; t++) {
			result = 0;
			array = br.readLine().split(" ");
			N = Integer.parseInt(array[0]);
			K = Integer.parseInt(array[1]);
			array = br.readLine().split(" ");
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(array[i]);
			}
			Arrays.sort(arr);
			for(int i=arr.length-K; i<arr.length; i++) {
				result = (result+arr[i])/2;
			}
			bw.write("#"+(t+1)+" "+result+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}