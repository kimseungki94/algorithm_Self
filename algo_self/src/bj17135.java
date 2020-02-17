import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17135 {
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
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		copymap = new boolean[N][M];
		m = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1")) {
					map[i][j] = true;
					m++; 
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

			for (int i = 0; i < map.length; i++) {
				copymap[i] = map[i].clone();
			} 

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
//			trr[r - 1] = arr[n - 1];
//			comb(n - 1, r - 1);
//			comb(n - 1, r);
			np(arr);
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
	
	private static boolean np(int[] numbers) {
		//totalCount++;
		// 1. 뒷쪽부터 탐색하며 교환이 필요한 위치(i-1) 찾기
		int i = M - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) {
			--i;
		}
		if (i == 0) {
			return false; // i가 꼭지고 더이상 이전원소가 없음... (즉, 내림차순된 순열...)
			// 2. i-1위치와 교환할 한단계 큰 j위치를 찾기(j위치는 맨뒤부터 탐색..)
		}
		int j = M - 1;
		while (numbers[i - 1] >= numbers[j]) {
			--j;
		}
		// 3. i-1위치와 j위치 swap
		int temp = numbers[i - 1];
		numbers[i - 1] = numbers[j];
		numbers[j] = temp;

		j = M - 1;
		// 4. i-1위치 뒤쪽(i위치) 으로부터 끝까지 가장 작은 순열로 재배치...
		// i위치부터 끝은 내림차순 된 모습 이를통해 오름차순으로 뒤집을 수 있다.
		while (i < j) {
			temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
			++i;
			--j;
		}
		return true;
	}
}