package com.algo.self_200402;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int per = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st=new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            long arr[] = new long[N + 1];
            arr[0] = 1;
            for (int i = 1; i <= N; i++) {
            	arr[i] = (arr[i - 1] * i) % per;
            }          
        }
    }
}