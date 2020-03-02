package study_0301;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_2567_new {
	static int MAX=101;
	static boolean[][]board= new boolean[MAX][MAX];
	static int dx[] = { -1,1,0,0 };
	static int dy[] = { 0,0,-1,1 };
	static int n, answer;

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input();
		solve();
		bw.write(answer+"\n");
		bw.flush();
		bw.close();
		
	}
	static void check(int i, int ii) {
		if (board[i][ii])return;
		for (int dir = 0; dir < 4; ++dir) {
			int nx = i + dx[dir];
			int ny = ii + dy[dir];
			if (nx < 0 || nx >= MAX || ny < 0 || ny >= MAX)continue;
			if (!board[nx][ny])continue;
			answer++;
		}
	}

	static void solve() {
		for (int i = 0; i < MAX; ++i) {
			for (int ii = 0; ii < MAX; ++ii) {
				check(i, ii);
			}
		}
	}

	static void paper_set(int nx, int ny) {
		for (int i = nx; i < nx + 10; ++i) {
			for (int ii = ny; ii < ny + 10; ++ii) {
				if (board[i][ii])continue;
				board[i][ii] = true;
			}
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int nx, ny;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			ny=Integer.parseInt(st.nextToken());
			nx=Integer.parseInt(st.nextToken());
			paper_set(nx, ny);
		}
	}
}
