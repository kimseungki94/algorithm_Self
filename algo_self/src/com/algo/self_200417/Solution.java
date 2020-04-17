package com.algo.self_200417;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int i, j;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			int num = 0;
			map = new int[10][10];
			for (i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine());
				for (j = 0; j < 10; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			for (i = 0; i < 10; i++)
				for (j = 0; j < 10; j++)
					if (map[i][j] > 0) {
						num++;
						search(i, j);
					}
			bw.write("#"+t+" "+ num+"\n");
		}
		br.close();
		bw.flush();
		bw.close();

	}

	private static void search(int x, int y) {
		map[x][y] = 0;
		int i;
		int ax[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int ay[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
		int dx;
		int dy;

		for (i = 0; i < 8; i++) {
			dx = x + ax[i];
			dy = y + ay[i];
			if (isInRange(dx, dy) && map[dx][dy] > 0)
				search(dx, dy);
		}
	}

	private static boolean isInRange(int x, int y) {
		return (0 <= x && x < 10) && (0 <= y && y < 10);
	}
}
