package com.ssafy.disjoint;

import java.util.Scanner;

public class sw_2005 {
	static int c = 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int count = 0;
			int size = sc.nextInt();
			int[][] store = new int[size][size];

				for (int i = 0; i < size; i++) {
					for (int j = 0; j <= i; j++) {
						store[i][j] = 1;
					}
				}
				System.out.println("#"+(t+1));
				for (int i = 0; i < size; i++) {
					for (int j = 0; j <= i; j++) {
						if (i + 1 < size && j + 1 < size) {
							store[i + 1][j + 1] = store[i][j] + store[i][j + 1];
						}
						System.out.print(store[i][j]+" ");
					}
					System.out.println();
				}
			
		}
	}
}
