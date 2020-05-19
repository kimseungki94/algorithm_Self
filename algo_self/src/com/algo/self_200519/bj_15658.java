package com.algo.self_200519;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_15658 {
    static int n;
    static int[] arr,giho;
    static long resultMax,resultMin;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        giho = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<4;i++)
            giho[i] = Integer.parseInt(st.nextToken());
        
        resultMax = Integer.MIN_VALUE;
        resultMin = Integer.MAX_VALUE;
        solve(1,arr[0]);
        bw.write(resultMax+"\n");
        bw.write(resultMin+"\n");
        bw.flush();
    }
    
    
    private static void solve(int idx,int sum) {
        if(idx>=n) {
            resultMax = Math.max(resultMax, sum);
            resultMin = Math.min(resultMin, sum);
            return;
        }
        
        for(int i=0;i<4;i++) {
            if(giho[i]==0) continue;
            giho[i]--;
            switch (i) {
            case 0: // +
                solve(idx+1,sum+arr[idx]);
                break; 
            case 1: // -
                solve(idx+1,sum-arr[idx]);
                break;
            case 2: // x
                solve(idx+1,sum*arr[idx]);
                break;
            case 3: // /
                solve(idx+1,sum/arr[idx]);
                break;
            }
            giho[i]++;
        }
    }
}