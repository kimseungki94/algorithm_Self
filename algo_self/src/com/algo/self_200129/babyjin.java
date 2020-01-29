package com.algo.self_200129;
import java.util.Scanner;

public class babyjin {
	static boolean[][] selected = new boolean[7][10];
	static int[] numbers;
	static int N=9, R=6;
	static int[] data = new int[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numbers = new int[R]; // 뽑힌 R개의 수 저장...
		permutation(0);
	}
	// x번째 수 뽑아 기존 순서 뒤에 붙이기
	private static void permutation(int index) {
		Scanner sc = new Scanner(System.in);
		if (index == R) { // 순열 완성
			int run = 0;
			int tri = 0;
			int limit = 0;
			for (int i = 0; i < 6; i++) {
				data[numbers[i]] += 1;
			}
			for (int i = 0; i < 10; i++) {
				if (data[i] >= 3 && data[i] < 6) {
					run++;
					for (int j = 0; j < 6; j++) {
						if (limit == 3) {
							break;
						} else {
							if (selected[j][i] == true) {
								selected[j][i] = false;
								limit++;
							}
						}
					}
				} else if (data[i] == 6) {
					run = 2;
					for (int j = 0; j < 7; j++) {
						selected[j][i] = false;
					}
				}
			}
			for (int j = 0; j <= 9; j++) {
				for (int i = 0; i < 6; i++) {

					if (selected[i][j] == true) {
						int answer1 = 0;
						int answer2 = 0;
						if (j <= 7) {
							for (int k = 0; k < 6; k++) {
								if(selected[k][j+1]==true) answer1++;
							}
							for (int k = 0; k < 6; k++) {
								if(selected[k][j+2]==true) answer2++;
							}
						}
						if(answer1==1 && answer2==1) {
							tri++;
						}
					}
				}
			}
			if(run==1 && tri==1) {
				System.out.println("baby-jin맞음");
			}else if(run==2) {
				System.out.println("baby-jin맞음");
			}else if(tri==2) {
				System.out.println("baby-jin맞음");
			}else {
				System.out.println("baby-jin아님");
			}
			return;
		}
		numbers[index] = sc.nextInt(); // but 순열일땐 이렇게 해야됨.. // i를 index번째 수로 사용
		selected[index][numbers[index]] = true; // 1번째 배열 카드 자리수 2번째 배열 저장된수
		permutation(index + 1); // index+1번째 수 구하기!
	}
}