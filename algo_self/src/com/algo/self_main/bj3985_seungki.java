package com.algo.self_main;

import java.util.Scanner;

public class bj3985_seungki {
	public static int N;
	public static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L + 1]; // 케이크 차지 현황
		int[] people_before = new int[N + 1]; // 처음 기대했던 케이크 양
		int[] people_after = new int[N + 1]; // 실제로 받은 케이크 양
		for (int i = 1; i <= N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			people_before[i] = end - start + 1;
			for (int j = start; j <= end; j++)
				if (cake[j] == 0)
					cake[j] = i;
		}

		// 실제 받은 케이크 양 저장
		for (int i = 1; i <= L; i++) {
			if (cake[i] != 0)
				++people_after[cake[i]];
		}

		// 기대, 실제 각각의 max 인덱스 계산
		int max_before = 0, before = 0;
		int max_after = 0, after = 0;
		for (int i = 1; i <= N; i++) {
			if (people_before[i] > max_before) {
				max_before = people_before[i];
				before = i;
			}
			if (people_after[i] > max_after) {
				max_after = people_after[i];
				after = i;
			}
		}

		System.out.println(before);
		System.out.println(after);
	}

}
