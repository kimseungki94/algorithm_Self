package com.algo.self_200128;

import java.util.Scanner;

public class jo_1291_김승기{
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s;
		int e;
		while (true) {
			s = sc.nextInt();
			e = sc.nextInt();
			if (s >= 2 && s <= 9 && e >= 2 && e <= 9) {

				for (int j = 1; j <= 9; j++) {
					for (int i = s; i >= e; i--) {
						System.out.printf("%d * %d = %2d  ", i, j, i * j);
						
					}
					System.out.println();
				}
			}else {
				System.out.println("INPUT ERROR!");
			}
			
		}

	}

}
