package com.algo.self_200429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1;t<=tc;t++) {
			int sum=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Integer[] arr = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<arr.length;i++) {
				
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr,Collections.reverseOrder());
			for(int i=1;i<=arr.length;i++) {
				if(i%3==0) {
					continue;
				}else {
					sum+=arr[i-1];
				}
			}
			System.out.println("#"+tc + " " + sum);
		}

	}

}
