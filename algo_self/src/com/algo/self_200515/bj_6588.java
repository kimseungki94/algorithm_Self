package com.algo.self_200515;

import java.io.*;
import java.util.*;

public class bj_6588 {
	static int count;
	static int[] array;
	static boolean[] visited = new boolean[1000001];
	static int[] edit = new int[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		search(1000000);

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			// visited = new boolean[num + 1];
			if (num == 0) {
				break;
			} else {
				L: for (int i = 0; i <= num / 2; i++) {
					int temp = num - edit[i];
					if (visited[temp] == false) {
						bw.write(num + " = " + edit[i] + " + " + temp + "\n");
						bw.flush();
						count = 0;
						break L;
					}
				}
			}

		}
	}

	private static void search(int a) {
		for (int i = 2; i <= a; i++) {
			if (visited[i] == true) {
				continue;
			} else {
				if (judge(i) == false) {
					if (i % 2 != 0) {
						edit[count++] = i;
					}
					for (int j = i * 2; j <= a; j += i + j) {
						visited[j] = true;
					}
				} else {
					visited[i] = true;
				}
			}
		}
	}

	private static boolean judge(int a) {
		if (a == 1 || a == 0) {
			return true;
		} else if (a == 2) {
			return false;
		} else {
			for (int i = 2; i * i <= a; i++) {
				if (a % i == 0) {
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}
}
