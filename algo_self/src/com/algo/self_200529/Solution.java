package com.algo.self_200529;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int r, c, time;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tnum = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int t = 1; t <= tnum; t++) {
			q = new LinkedList<>();
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			visit = new boolean[r][c];
			map = new int[r][c];
			q.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			visit[q.peek().x][q.peek().y] = true;
			time = Integer.parseInt(st.nextToken());

			for (int i = 0; i < r; i++) {
				 st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i < time; i++) {
				bfs();
			}

			bw.write("#" + t + " " + calc()+"\n");
			bw.flush();
		}
	}

	private static void bfs() {
		int size = q.size();
		for (int s = 0; s < size; s++) {
			Node n = q.poll();
			ArrayList<Integer> list = new ArrayList<>();
			switch (map[n.x][n.y]) {
			case 1:
				list.add(0);
				list.add(1);
				list.add(2);
				list.add(3);
				break;
			case 2:
				list.add(0);
				list.add(1);
				break;
			case 3:
				list.add(2);
				list.add(3);
				break;
			case 4:
				list.add(1);
				list.add(2);
				break;
			case 5:
				list.add(0);
				list.add(2);
				break;
			case 6:
				list.add(0);
				list.add(3);
				break;
			case 7:
				list.add(3);
				list.add(1);
				break;
			}

			isPossible(n.x, n.y, list);
		}
	}

	private static void isPossible(int x, int y, ArrayList<Integer> list) {

		for (int dir : list) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != 0 && !visit[nx][ny]) {

				if (isConnect(dir, map[nx][ny])) {
					visit[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
	}

	private static boolean isConnect(int dir, int there) {
		switch (dir) {
		case 0:
			if (there == 1 || there == 2 || there == 4 || there == 7) {
				return true;
			}
			break;
		case 1:
			if (there == 1 || there == 2 || there == 5 || there == 6) {
				return true;
			}
			break;
		case 2:
			if (there == 1 || there == 3 || there == 6 || there == 7) {
				return true;
			}
			break;
		case 3:
			if (there == 1 || there == 3 || there == 4 || there == 5) {
				return true;
			}
			break;
		}
		return false;
	}

	private static int calc() {
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (visit[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

}

