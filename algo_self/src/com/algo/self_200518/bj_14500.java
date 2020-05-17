package com.algo.self_200518;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_14500 {
	static int MAX = 0;
	static int sum = 0;
	static int N, M;
	static boolean compare = true;
	static int[][] map = new int[500][500];
	// 에메랄드 막대기
	static int[] esquare_y = { 0, 0, 0, 0 };
	static int[] esquare_x = { 0, 1, 2, 3 };
	// 에메랄드 막대기 90도회전
	static int[] esquare90_y = { 0, 1, 2, 3 };
	static int[] esquare90_x = { 0, 0, 0, 0 };
	// 노랑 정사각형
	static int[] ysquare_y = { 0, 0, 1, 1 };
	static int[] ysquare_x = { 0, 1, 1, 0 };

	// 주황색도형
	static int[] osquare_y = { 0, 1, 2, 2 };
	static int[] osquare_x = { 0, 0, 0, 1 };
	// 주황색도형 90도회전
	static int[] osquare_90y = { 0, 1, 0, 0 };
	static int[] osquare_90x = { 0, 0, 1, 2 };
	// 주황색도형 180도회전
	static int[] osquare_180y = { 0, 0, 1, 2 };
	static int[] osquare_180x = { 0, 1, 1, 1 };
	// 주황색도형 270도회전
	static int[] osquare_270y = { 0, 0, 0, -1 };
	static int[] osquare_270x = { 0, 1, 2, 2 };

	// 뒤집은주황색도형
	static int[] osquare_Ry = { 0, 0, -1, -2 };
	static int[] osquare_Rx = { 0, 1, 1, 1 };
	// 뒤집은주황색도형 90도회전
	static int[] osquare_90Ry = { 0, 0, 0, 1 };
	static int[] osquare_90Rx = { 0, 1, 2, 2 };
	// 뒤집은주황색도형 180도회전
	static int[] osquare_180Ry = { 0, 1, 2, 0 };
	static int[] osquare_180Rx = { 0, 0, 0, 1 };
	// 뒤집은주황색도형 270도회전
	static int[] osquare_270Ry = { 0, 1, 1, 1 };
	static int[] osquare_270Rx = { 0, 0, 1, 2 };

	// 녹색도형
	static int[] gsquare_y = { 0, 1, 1, 2 };
	static int[] gsquare_x = { 0, 0, 1, 1 };
	// 녹색도형 90도회전
	static int[] gsquare_90y = { 0, 0, -1, -1 };
	static int[] gsquare_90x = { 0, 1, 1, 2 };
	// 녹색도형 180도회전
	static int[] gsquare_180y = { 0, 1, 1, 2 };
	static int[] gsquare_180x = { 0, 0, -1, -1 };
	// 녹색도형 270도회전
	static int[] gsquare_270y = { 0, 0, 1, 1 };
	static int[] gsquare_270x = { 0, 1, 1, 2 };
	// 분홍도형
	static int[] psquare_y = { 0, 0, 1, 0 };
	static int[] psquare_x = { 0, 1, 1, 2 };
	// 분홍도형 90도회전
	static int[] psquare_90y = { 0, 1, 1, 2 };
	static int[] psquare_90x = { 0, 0, 1, 0 };
	// 분홍도형 180도회전
	static int[] psquare_180y = { 0, 0, -1, 0 };
	static int[] psquare_180x = { 0, 1, 1, 2 };
	// 분홍도형 270도회전
	static int[] psquare_270y = { 0, 1, 1, 2 };
	static int[] psquare_270x = { 0, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 에메랄드
				judge(i, j, esquare_y, esquare_x);
				judge(i, j, esquare90_y, esquare90_x);

				// 노랑
				judge(i, j, ysquare_y, ysquare_x);

				// 오렌지
				judge(i, j, osquare_y, osquare_x);
				judge(i, j, osquare_90y, osquare_90x);
				judge(i, j, osquare_180y, osquare_180x);
				judge(i, j, osquare_270y, osquare_270x);
				
				// 뒤집힌 오렌지
				judge(i, j, osquare_Ry, osquare_Rx);
				judge(i, j, osquare_90Ry, osquare_90Rx);
				judge(i, j, osquare_180Ry, osquare_180Rx);
				judge(i, j, osquare_270Ry, osquare_270Rx);
				
				// 녹색
				judge(i, j, gsquare_y, gsquare_x);
				judge(i, j, gsquare_90y, gsquare_90x);
				judge(i, j, gsquare_180y, gsquare_180x);
				judge(i, j, gsquare_270y, gsquare_270x);

				// 분홍
				judge(i, j, psquare_y, psquare_x);
				judge(i, j, psquare_90y, psquare_90x);
				judge(i, j, psquare_180y, psquare_180x);
				judge(i, j, psquare_270y, psquare_270x);

			}
		}
		bw.write(MAX + "\n");
		bw.flush();

	}

	private static void judge(int y, int x, int[] squareY, int[] squareX) {
		for (int i = 0; i < 4; i++) {
			if (y + squareY[i] >= N || x + squareX[i] >= M) {
				compare = false;
			}
			if (y + squareY[i] < 0 ||  x + squareX[i] < 0) {
				compare = false;
			}
		}
		if (compare == true) {
			for (int i = 0; i < 4; i++) {
				sum += map[y + squareY[i]][x + squareX[i]];
			}
		}
		if (MAX < sum) {
			MAX = sum;
			sum = 0;
		} else {
			sum = 0;
		}
		compare = true;
	}

}
