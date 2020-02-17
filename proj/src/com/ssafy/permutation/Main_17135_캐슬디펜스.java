package com.ssafy.permutation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	private static int N;
	private static int M;
	private static int D;
	private static boolean[][] map;
	private static boolean[][] copymap;
	private static int[] trr;
	private static int[] arr;
	private static int m;
	private static int maxkill;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 3 <= N <= 15
		M = Integer.parseInt(st.nextToken()); // 3 <= M <= 15
		D = Integer.parseInt(st.nextToken()); // 1 <= D <= 10

		map = new boolean[N][M];
		copymap = new boolean[N][M];
		m = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1")) {
					map[i][j] = true;
					m++; // 총 몬스터
				}
			}
		}

		trr = new int[3];
		arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = i;
		}
		maxkill = 0;
		comb(M, 3);

		System.out.println(maxkill);
	}

	private static void comb(int n, int r) {
		if (r == 0) {
			// 맵 복사
			for (int i = 0; i < map.length; i++) {
				copymap[i] = map[i].clone();
			} // 깊은 복사

			int kill = 0;
			int time = 0;
			for (int i = copymap.length - 1; i >= 0; i--) {
				kill += killMonster(i, time);
				time++;
			}
			if (maxkill < kill) {
				maxkill = kill;
			}
		} else if (n < r) { //
			return;
		} else {
			trr[r - 1] = arr[n - 1];
			comb(n - 1, r - 1);
			comb(n - 1, r);
		}
	}

	private static int killMonster(int n, int time) {
		int kill = 0;
		int[][] temp = new int[3][3];
		boolean[] flag = new boolean[3];
		int len = n - D < 0 ? 0 : n - D;
		for (int k = 0; k < trr.length; k++) {
			for (int j = 0; j < copymap[0].length; j++) {
				for (int i = n; i >= len; i--) {
					if (copymap[i][j]) {
						int dist = Math.abs(trr[k] - j) + Math.abs(N - i - time);
						if (dist <= D) {
							if (temp[k][2] == 0 || temp[k][2] > dist) {
								temp[k][0] = i;
								temp[k][1] = j;
								temp[k][2] = dist;
								flag[k] = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (flag[i] && copymap[temp[i][0]][temp[i][1]]) {
				kill++;
				copymap[temp[i][0]][temp[i][1]] = false;
			}
		}
		return kill;
	}
}