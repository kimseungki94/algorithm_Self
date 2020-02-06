package com.ssafy.search;

import java.util.LinkedList;
import java.util.Queue;

public class GraphSearchTest {

	private static int[][] adjMatrix;
	private static int N;
	private static boolean[] visited;
	public static void main(String[] args) {
		N = 7;
		adjMatrix = new int[][]{
			{0,1,1,0,0,0,0},
			{1,0,0,1,1,0,0},
			{1,0,0,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,1,0,0,1,0},
			{0,0,0,1,1,0,1},
			{0,0,0,0,0,1,0}
		};
		visited = new boolean[N];
		dfs(0);
		System.out.println();
/*		visited[0] = true;
		dfs2(0);
		System.out.println();*/
		bfs(0);
		System.out.println();
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		// 방문시 해야할일.
		System.out.printf("%c ",current+65);
		
		// 모든 인접정점 처리
		for (int j = 0; j < N; j++) {
			if(adjMatrix[current][j]>0 && !visited[j]) {
				dfs(j);
			}
		}
	}
	private static void dfs2(int current) {
		// 방문시 해야할일.
		System.out.printf("%c ",current+65);
		
		// 모든 인접정점 처리
		for (int j = 0; j < N; j++) {
			if(adjMatrix[current][j]>0 && !visited[j]) {
				visited[j] = true;
				dfs2(j);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		visited[start] = true;
		queue.offer(start);
		
		int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			// 방문시 해야할일.
			System.out.printf("%c ",current+65);
			
			// 모든 인접정점 처리
			for (int j = 0; j < N; j++) {
				if(adjMatrix[current][j]>0 && !visited[j]) {
					visited[j] = true;
					queue.offer(j);
				}
			}
		}
		
	}
	
}































