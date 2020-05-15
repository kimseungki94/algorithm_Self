package com.algo.self_200506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] team1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] team2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
	static int[][] map;
	static int[][] result;
	static int[] final_result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		map = new int[6][3];
		result = new int[6][3];
		final_result = new int[4];

		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(t, 0);
		}
		for(int i=0; i<final_result.length;i++) {
			System.out.print(final_result[i] + " ");
		}
			
		System.out.println();

	}

	static void dfs(int index, int limit) {
		if (limit == 15) {
			if (final_result[index] != 1) {
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++)
						if (map[i][j] != result[i][j])
							return;
				}

				final_result[index] = 1;
				return;

			} else
				return;
		}

		int index1 = team1[limit];
		int index2 = team2[limit];

		result[index1][0]++;
		result[index2][2]++;
		dfs(index, limit + 1);
		result[index1][0]--;
		result[index2][2]--;

		result[index1][1]++;
		result[index2][1]++;
		dfs(index, limit + 1);
		result[index1][1]--;
		result[index2][1]--;

		result[index1][2]++;
		result[index2][0]++;
		dfs(index, limit + 1);
		result[index1][2]--;
		result[index2][0]--;

	}
}