package com.algo.self_200514;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	static int[][] map, dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static int N,count = 0,max =1;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int k = 1; k <= 100; k++) {
			count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(map[i][j]>k && !visited[i][j]) {
						DFS(i, j, k); 
						count++;
					}
				}	
			}
			visited = new boolean[N][N];
			if(max<count) {
				max = count;
			}			
		}
		
	
		System.out.println(max);
	
	}

	public static void DFS(int x, int y,int k) {
	
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			
			if(judge(nx,ny) && map[nx][ny] > k && !visited[nx][ny]) {
				DFS(nx,ny,k);
			}
		}
		
	}

	public static boolean judge(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}