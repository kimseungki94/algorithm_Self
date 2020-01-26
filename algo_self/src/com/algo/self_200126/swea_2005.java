package com.algo.self_200126;

import java.util.Scanner;

public class swea_2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int testcase = 0;
		testcase = sc.nextInt();
		for (int z = 1; z <= testcase; z++) {
			N = sc.nextInt();
			System.out.println("#"+z);
			int[][] num = new int[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					num[i][j] = 0;
				}
			}
			int number = 0;
			if (N >= 1 && N <= 10) {
				for (int i = 0; i < N; i++) {
					for (int j = i; j >= 0; j--) {
						if (i >= 2 && j >= 1) {
							if (num[i - 1][j - 1] != 0 && num[i - 1][j] != 0) {
								num[i][j] = num[i - 1][j - 1] + num[i - 1][j];
							} else {
								num[i][j] = 1;
							}
						} else {
							num[i][j] = 1;
						}
						System.out.print(num[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println();
			}
		}
		
		
	}

}
