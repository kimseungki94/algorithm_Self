package com.algo.self_200514;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static char[][] map;
	static int[] dx = {0,0,-1,1}; // 상 하 좌 우
	static int[] dy = {-1,1,0,0}; // 상 하 좌 우 
	static boolean[][][] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map = new char[N][M];
		v = new boolean[N][M][1<<6];
		String s = "";
		Data start = null;
		for(int i=0;i<N;i++) {
			s = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j] == '0') {
					start = new Data(j,i,0,0);
				}
			}
		}
		int result = bfs(start);
		System.out.println(result);
		sc.close();
	}
	static int bfs(Data start) {
		Queue<Data> q = new LinkedList<>();
		//큐에 삽입 방문체크 큐가 빌때까지 로직검사, 다시 필요하면 큐에 삽입
		q.offer(start);
		v[start.y][start.x][0]=true;
		Data d;
		while(!q.isEmpty()) {
			int size = q.size();
			int key=0;
			for(int i=0;i<size;i++) {
				d = q.poll();
				if(map[d.y][d.x]=='1') {
					return d.cnt;
				}
				for(int m=0;m<4;m++) {
					int nx = d.x + dx[m];
					int ny = d.y+dy[m];
					// 1. 범위벗어난것 무시
					
					if(nx<0||nx>=M || ny>=N || ny<0) {
						continue;
					}
					// 2. 벽이면 무시
					
					if(map[ny][nx]=='#') {
						continue;
					}
					// 3. 방문했던곳이면 무시
					if(v[ny][nx][key]) {
						continue;
					}
					// 4. 키가 있으면 줍기
					if('a'<=map[ny][nx] && map[ny][nx] <='f') {
						key = (1 << (map[ny][nx]-'a'));
					}
					// 5. 문인데 키가없으면 무시..
					if('A'<=map[ny][nx] && map[ny][nx] <='F') {
						if((key & (1 << (map[ny][nx]-'a')))==0) {
							continue;
						}
						key = (1 << (map[ny][nx]-'a'));
					}
					
					// 6. 방문체크하고 큐에 재삽입
					v[ny][nx][key] = true;
					q.offer(new Data(nx,ny,key,d.cnt+1));
				}
			}
			
		}
		return -1;
	}
	static class Data{
		int x,y;
		int cnt;
		int key;
		public Data(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}

}
