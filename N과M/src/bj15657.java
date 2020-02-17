import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15657 {
	static int[] num;
	static int N;
	static int limit;
	static boolean[] visited;
	static int[] store;
	static String str;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = null;
		N = Integer.parseInt(st.nextToken()); // 수
		limit = Integer.parseInt(st.nextToken()); // 제한된 수
		num = new int[limit];
		visited = new boolean[N + 1];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		store = new int[N];
		for(int i=0;i<N;i++) {
			store[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(store);
		sb = new StringBuilder();
		dfs(0, "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString().trim());
		bw.close();
	}

	private static void dfs(int index, String str) {
		if (index == limit) {
			String temp = sb.toString();
			if(temp.contains(str.trim())) {
				return;
			}else {
				sb.append(str.trim() + "\n");
			}
			
			// System.out.println();
			return;
		}
		for (int j = 0; j < N; j++) {
			if (visited[j] == false) {
				num[index] = store[j];
				visited[j]=true;

				
				dfs(index + 1, str + " " + store[j]);

				visited[j]=false;
			}
		}
	}

}
