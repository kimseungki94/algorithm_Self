package com.algo.self_main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		int[][] load = new int[100][100];
		Scanner sc = new Scanner(System.in);

		boolean selection = true;

		for (int z = 0; z < 10; z++) {
			int test = sc.nextInt();
			int edit_column = 0;
			for (int w = 0; w < 100; w++) {
				for (int g = 0; g < 100; g++) {
					load[w][g] = 0;
				}
			}

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					load[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 100; i++) {
				
				int fix_column;
				if (load[0][i] == 1) {
					// 시작
					edit_column = i; // 시작 열을 저장하기위한 목적
					fix_column = i; // 변동이 자주되는 컬럼 (시작)
					for (int j = 1; j < 100; j++) {
						if (fix_column < 99) {
							if (load[j][++fix_column] == 1) {
								fix_column= fix_column-1;
								while (selection) {
									if (fix_column < 99) {
										if (load[j][++fix_column] == 0) {
											selection = false;
											fix_column = fix_column - 1;
										} else {
											continue;
										}
									} else {
										selection = false;
									}
								}
								selection = true;
							} else if (load[j][--fix_column] == 1) {
								fix_column= fix_column+1;
								while (selection) {
									if (fix_column > 0) {
										if (load[j][--fix_column] == 0) {
											selection = false;
											fix_column = fix_column + 1;
										} else {
											continue;
										}
									} else {
										selection = false;
									}
								}
								selection = true;

							} else {
								continue;
							}
						} else {
							continue;
						}
					}
					if (load[99][fix_column] == 2) {
						System.out.println("#" + test + " " + edit_column);
						break;
					}
				} else {
					continue;
				}
			}

		} // for문 10개
	}

}
