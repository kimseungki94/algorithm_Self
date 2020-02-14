import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int limit = 0;
	static int N = 0;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N + 1][M];
		int[] store = new int[N];
		int range = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[] monster = new int[N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				monster[i] += map[j][i];
			}
		}

		// N이 행 M이 열
		int sample = range - 1;
		for (int i = 0; i < M; i++) {
			for (int j = i - sample; j <= i + sample; j++) { // 여기가 열
				for (int k = 0; k < N; k++) {
					if (j >= 0 && j < M) {
						store[i] += map[k][j];
					}
				}

			}
		}
		int mon_no1 = 0;
		int mon_no2 = 0;
		int mon_no3 = 0;
		boolean[] visited = new boolean[N];
		int temp = 0;
		for (int i = 0; i < N; i++) {
			if (temp < store[i]) {
				mon_no1 = i;
				temp = store[i];
			}
		}
		// System.out.println(mon_no1);
		temp = 0;
		visited[mon_no1] = true;
		for (int i = 0; i < N; i++) {
			if (temp < store[i] && visited[i] == false) {
				mon_no2 = i;
				temp = store[i];
			}
		}
		// System.out.println(mon_no2);
		visited[mon_no2] = true;
		temp = 0;
		for (int i = 0; i < N; i++) {
			if (temp < store[i] && visited[i] == false) {
				mon_no3 = i;
				temp = store[i];
			}
		}
		// System.out.println(mon_no3);
		visited[mon_no3] = true;
		map[N][mon_no1] = 2;
		map[N][mon_no2] = 2;
		map[N][mon_no3] = 2;

		int count = 0;

		// N이 행 M이 열
		// System.out.println();
		// 1
		boolean selected = false;
		int bowmaster = 0;
		G: while (true) {
			for (int z = 0; z < N; z++) {
				int y[] = new int[4];
				int x[] = new int[4];
				boolean[] countvisited = new boolean[3];
				for (int i = 0; i < M; i++) {
					if (map[N][i] != 0) {

						// 0일때 i=1 N은 궁수있는곳 M은 6
						for (int j = i - sample; j <= i + sample; j++) { // 여기가 열
							// j = 0 j=1+1
							for (int k = 1; k <= range; k++) {
								if (j >= 0 && j < M && map[N - k][j] == 1 && bowmaster < 3) {
									// map[N - k][j] = 0;

									bowmaster++;
									y[i] = N - k;
									x[i] = j;
									System.out.println(y[i] + " " + x[i]);
									count++;
									break;
									// }
								}
							}
						}
					} else {
						// map[N - 1][i] = 0;
						continue;
					}

//				for(int m=0;m<3;m++) {
//					System.out.println(y[m] + "  g "+x[m] );
//					
//					if(map[y[m]][x[m]]==1) {
//						System.out.println("궁수");
//						count++;
//						map[y[m]][x[m]]=0;
//					}
//				}
//				for (int q = 0; q < M; q++) {
//					map[N - 1][q] = 0;
//				}

				}
//					for (int q = 0; q <= N; q++) {
//						for (int j = 0; j < M; j++) {
//							System.out.print(map[q][j] + " ");
//						}
//						System.out.println();
//					}
//					System.out.println();
				System.out.println();
				for (int m = 0; m < M; m++) {
					map[N - 1][m] = 0;
				}
				for (int m = 0; m < 3; m++) {
					map[y[m]][x[m]] = 0;
				}

				for (int q = N - 2; q >= 0; q--) {
					for (int j = 0; j < M; j++) {
						temp = 0;
						temp = map[q][j];
						map[q][j] = map[q + 1][j];
						map[q + 1][j] = temp;
					}
				}

//					for (int q = 0; q <= N; q++) {
//						for (int j = 0; j < M; j++) {
//							System.out.print(map[q][j] + " ");
//						}
//						System.out.println();
//					}
				// System.out.println();
				bowmaster = 0; // 보우마스터 초기화
			}

//			for (int q = 0; q < N; q++) {
//				for (int j = 0; j < M; j++) {
//					if (map[q][j] != 0) {
//						selected = false;
//					}
//				}
//			}
			if (selected == true) {
				break;
			}
			selected = true;
		}
		System.out.println(count);
	}

}