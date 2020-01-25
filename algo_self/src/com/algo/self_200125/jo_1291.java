package com.algo.self_200125;

import java.util.Scanner;

public class jo_1291 {

	public static void main(String[] args) throws Exception {
		int s = 0;
		int e = 0;

		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		e = sc.nextInt();
		
		while (true) {
			if (s >= 2 && s <= 9 && e >= 2 && e <= 9 && e < s) {
				for (int j = 1; j <= 9; j++) {
					for (int i = s; i >= e; i--) {
						System.out.printf("%d * %d = %2d   ",i,j,j*i);
					}
					System.out.println();
				}
				break;
			} else if(s < 2 || s > 9 || e < 2 || e > 9 || e > s) {
				System.out.println("INPUT ERROR!");
				s = 0;
				e = 0;
				s = sc.nextInt();
				e = sc.nextInt();
				continue;
			} else {
				break;
			}
		}
	}
}
