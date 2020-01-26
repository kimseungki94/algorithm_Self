package com.algo.self_200126;

import java.util.Scanner;

public class swea_1926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		int sum = 0;
		number = sc.nextInt();
		if (number >= 10 && number <= 1000) {
			for (int i = 1; i <= number; i++) {
				int count=0;
				if (i >= 100) {
					if ((i % 100) / 10 == 3 || (i % 100) / 10 == 6 || (i % 100) / 10 == 9) {
						System.out.print("-");
						count++;
					}
				}
				if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
					System.out.print("-");
					count++;
				}
				if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
					System.out.print("-");
					count++;
				}
				if(count==0) {
					System.out.print(i);
				}
				System.out.print(" ");
			}
		} else {
			System.out.println();
		}

	}

}
