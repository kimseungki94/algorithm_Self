package com.algo.self_200502;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T=Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            char[] arr1 = br.readLine().toCharArray();
            char[] arr2 = br.readLine().toCharArray();
            System.out.println("#"+t+" ");
        }
       
    }
}