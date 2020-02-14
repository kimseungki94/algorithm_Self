import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		visited = new boolean[N + 1];
		dfs(0,0);
		sc.close();
	}

	public static void dfs(int index,int last) {
		if (index == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int j = 1; j <= N; j++) {
			if (visited[j] == false && last<j) {
				num[index] = j;
				visited[j] = true;
				last=j;
				dfs(index + 1,last);
				visited[j] = false;
			}
		}
	}
}