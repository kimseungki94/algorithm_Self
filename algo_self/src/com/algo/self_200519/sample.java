package com.algo.self_200519;

import java.io.*;

import java.util.*;

public class sample {
    static int[] parents;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= testcase; t++) {
        	st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int[][] arr = new int[E][3];
            parents = new int[V + 1];
            Arrays.fill(parents, -1);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    int i = a[2] - b[2];
                    return i;
                }
            });

            int count = 0;
            long result = 0;
            for (int i = 0; i < E; i++) {
                boolean uni = union(arr[i][0], arr[i][1]);
                if (uni) {
                    result += arr[i][2];
                    count++;
                }
                if (count == V - 1) {
                    break;
                }

            }
            bw.write("#" + t + " " + result+"\n");
       
        }
    }

	private static boolean union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parents[bRoot] = aRoot;
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if (parents[a] < 0)
            return a;
        else {    // path compression 
            return parents[a] = find(parents[a]);
        }
    }
}
