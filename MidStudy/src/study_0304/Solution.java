package study_0304;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static int n, m;
	static int[][] map;
	static int[][][][] dp; // 높이 x 높이 넓이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			dp = new int[n + 1][m + 1][n + 1][m + 1];
			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = dfs(0, 0, n, m);
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static int dfs(int y, int x, int h, int w) {
		// 종료
		if (w == 1 && h == 1) {
			return 0;
		}
		if (dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}
		// 실행
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		// 가로로 나누어서 비용을 구하는데 최소비용을 구한다..
		for (int i = 1; i < h; i++) {
			// 위쪽 비용
			dp[y][x][h][w] = dfs(y, x, i, w);
			// 아래쪽 비용
			dp[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum + dp[y][x][h][w] + dp[y + i][x][h - i][w]);
		}
		// 세로로 나누어서 최소비용을 구한다
		for (int i = 1; i < w; i++) {
			// 왼쪽 비용
			dp[y][x][h][w] = dfs(y, x, h, i);
			// 오른쪽 비용
			dp[y + i][x][h - i][w] = dfs(y, x + i, h, w - i);
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum + dp[y][x][h][w] + dp[y + i][x][h - i][w]);
		}
		// 재귀호출
		return dp[y][x][h][w];
	}
}
