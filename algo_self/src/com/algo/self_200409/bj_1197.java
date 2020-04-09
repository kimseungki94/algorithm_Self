package com.algo.self_200409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj_1197 {
	static int V;
	static int E;
	static int[][] edges;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;
		edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i][0] = from;
			edges[i][1] = to;
			edges[i][2] = cost;
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[2] >= b[2] ? 1 : -1;
			}
		});
		int sum = 0;
		int edgeCount = 0;
		for (int i = 0; i < E; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			int cost = edges[i][2];
			if (find(from) != find(to)) {
				union(from, to);
				sum += cost;
				if (++edgeCount == V - 1)
					break;
			}
		}
		System.out.println(sum);
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;
		int root = find(parent[x]);
		parent[x] = root;
		return root;
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[y] = x;
	}
}
