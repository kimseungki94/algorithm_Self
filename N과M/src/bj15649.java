import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649 {
	static int[] num;
	static int N;
	static int limit;
	static boolean[] visited;
	static int[] store;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		str = null;

		N = Integer.parseInt(st.nextToken()); // 수
		limit = Integer.parseInt(st.nextToken()); // 제한된 수
		num = new int[limit];
		visited = new boolean[N+1];
		dfs(0);
	}


	private static void dfs(int index) {
		if(index==limit) {
			for(int i=0;i<limit;i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}	
			for(int j=1;j<=N;j++) {
				if(visited[j]==false) {
					num[index]=j;
					visited[j]=true;
					dfs(index+1);
					visited[j]=false;
				}	
			}
		
		
	}

}
