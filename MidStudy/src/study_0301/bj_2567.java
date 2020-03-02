package study_0301;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_2567 {
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[101][101];
		boolean[][] visited = new boolean[101][101];
		int x, y;
		int count = 0;
		for (int T = 0; T < N; T++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			for (int i = y; i <= y + 10; i++) {
				for (int j = x; j <= x + 10; j++) {
					map[i][j]++;
				}
			}
		}
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				bw.write(map[i][j] + " ");
				if (map[i][j] == 2) {
					count++;
				}

			}
			bw.write("\n");
		}

		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}

}
