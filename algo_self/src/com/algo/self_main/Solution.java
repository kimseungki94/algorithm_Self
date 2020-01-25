package com.algo.self_main;

import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		int[][] ladder = new int[100][100];
		Scanner sc = new Scanner(System.in);

		for (int z = 0; z < 10; z++) {

			int test = sc.nextInt(); // 몇번할지에 대한 input

			// 100 x 100 이차원배열 초기화 및 저장
			for (int w = 0; w < 100; w++) {
				for (int g = 0; g < 100; g++) {
					ladder[w][g] = 0;
				}
			}

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			// 알고리즘 시작
			for (int i = 0; i < 100; i++) {

				int fix_column = 0;
				int fix_row = 0;
				if (ladder[99][i] == 2) {
					// 시작
					fix_column = i; // 변동이 자주되는 컬럼 (시작)
					int row = 98;
					int column = i;
					while(row!=0) {
						if(column==0) {
							if(ladder[row-1][column]==1 && ladder[row-1][column+1]==1) {
								row--;
								while(column<99 && ladder[row][column+1]!=0) {
									column++;
								}
								
							} else if(row<0||column>99){
								row--;
							}
							else {
								row--;
							}
						}else if(column==99){
							if(ladder[row-1][column]==1 && ladder[row-1][column-1]==1) {
								row--;
								while(column>0 && ladder[row][column-1]!=0) {
									column--;
								}
							}
							else {
								row--;
							}
						}else {
							if(ladder[row-1][column]==1 && ladder[row-1][column+1]==1) {
								row--;
								while(column<99 && ladder[row][column+1]!=0) {
									column++;
								}
								
							}else if(ladder[row-1][column]==1 && ladder[row-1][column-1]==1) {
								row--;
								while(column>0 && ladder[row][column-1]!=0) {
									column--;
								}
								
							}
							else {
								row--;
							}
						}
						fix_column=column;
					}
				}else {
					continue;
				}
				System.out.println("#"+test + " "+fix_column);
			}

		}
	}
}