package com.algo.self_200129;

import java.util.Scanner;

public class jo_1175_김승기 {
	static int[] numbers;
	static int N, R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		N = 6;
		C = sc.nextInt();
		numbers = new int[R];
		permutation(0);
	}

	private static void permutation(int index) {
		if (index == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += numbers[i];
			}
			if (sum == C) {
				for (int i = 0; i < R; i++) {
					System.out.print(numbers[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
			numbers[index] = i;
			permutation(index + 1);
		}
	}
}
