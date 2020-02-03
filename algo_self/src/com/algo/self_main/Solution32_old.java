package com.algo.self_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution32_old {
	static int[] dy = { 0, 0, 1, 0, -1 };
	static int[] dx = { 0, 1, 0, -1, 0 };
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int y = 0;
			int x = 0;
			int money =0;
			int moneykey=1;
			int nodongmoney=0;
			y = sc.nextInt();
			x = sc.nextInt();
			int[][] map = new int[y][x];
			int number = 0;
			number = sc.nextInt();
			int[][] player = new int[number][3];

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			for (int i = 0; i < number; i++) {
				for (int j = 0; j < 3; j++) {
					player[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < number; i++) {
				for (int j = 0; j < 2; j++) {
					player[i][j] -= 1;
				}
			}
			int limit = 0;
			limit = sc.nextInt();
			int[][] trap = new int[limit][2];
			for (int i = 0; i < limit; i++) {
				for (int j = 0; j < 2; j++) {
					trap[i][j] = sc.nextInt()-1;
				}
			}
			for (int i = 0; i < number; i++) { // 플레이어수
				nodongmoney=0;
				for (int j = 0; j < player[i][2]; j++) {
					System.out.println("j : " + j);
					System.out.println("y x : " + player[i][0] + " " + player[i][1]);
					if(player[i][0]<0 || player[i][0]>y || player[i][1]<0 || player[i][1]>x) {
						money=money-1000;
						moneykey=0;
						System.out.println("돈버림");
						break;
					}else {
						System.out.println(map[player[i][0]][player[i][1]]);
						//21
						int move = map[player[i][0]][player[i][1]]%10;
						System.out.println("음직임 : " +move);
						int direction =map[player[i][0]][player[i][1]]/10;
						System.out.println("방향 : " +direction);
						for(int z=0;z<move;z++) {
							player[i][0]=player[i][0]+dy[direction];
							player[i][1]=player[i][1]+dx[direction];
							
							if(player[i][0]<0 || player[i][0]>y || player[i][1]<0 || player[i][1]>x) {
								moneykey=0;
								break;
							}else {
								nodongmoney=map[player[i][0]][player[i][1]]*100;
								System.out.println("노동돈 : " +nodongmoney);
							}
							
							//요약.. 그 벗어나는거 예외처리하고 트랩에 걸린건 -1000원빼고 이거 최종적으로 돌릴때 수익 발생한거 
							//여기서 아무런 변수하나 주고 그 변수 충족할때만 돈 받을수 있게하면됨
							for(int k=0;k<limit;k++) {
								if(trap[k][0]==player[i][0] && trap[k][1]==player[i][1]) {
									moneykey=0;
									break;
								}
							}
						}
					}
				
					
					if(moneykey==1) {
						money=nodongmoney;
						System.out.println("내돈 :   "+money);
					}
					moneykey=1;
				}	
				}
				
			System.out.println("#머니 : "+ money);
		}
	}

}
