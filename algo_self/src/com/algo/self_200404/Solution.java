package com.algo.self_200404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {
    static class Node {
        int t,a,b;
        Node(int t,int a,int b){
            this.t=t;
            this.a=a;
            this.b=b;
        }
    }
 
    public static final long mod = 998244353;
    public static void main(String[] args) throws IOException {
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int T=1;T<=test;T++) {
            int n = sc.nextInt();
            Node[] arr = new Node[n+1];
            for(int i=2;i<=n;i++) {
            	//st = new StringTokenizer(br.readLine()," ");
                int t = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                Node node = new Node(t,a,b);
                arr[i]=node;
            }
            
            int m = sc.nextInt();
            long[] result = new long[m+1];
            for(int i=0;i<m;i++) {
                int x = sc.nextInt();
                long[] num = new long[n+1];
                num[0]=1; num[1]=x;
                
                for(int j=2;j<=n;j++) {
                    if(arr[j].t==1) num[j] = num[arr[j].a]+num[arr[j].b];
                    else if(arr[j].t==2) num[j]=arr[j].a*num[arr[j].b];
                    else num[j]=num[arr[j].a]*num[arr[j].b];
                    num[j]%=mod;
                }
                result[i]=num[n];
            }
            bw.write("#"+test+" ");
            
            for(int j=0;j<m;j++) {
            	bw.write(result[j]+" ");
            }
            bw.write("\n");
        }
        sc.close();
        bw.flush();
        bw.close();
    }
}