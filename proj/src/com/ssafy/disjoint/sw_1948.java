package com.ssafy.disjoint;

import java.util.Scanner;

public class sw_1948 {
	static int c = 1;

	public static void main(String[] args) {
//1/31, 2/28, 3/31, 4/30, 5/31, 
//6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int[] month = new int[13];
			month[1] = 31;
			month[2] = 28;
			month[3] = 31;
			month[4] = 30;
			month[5] = 31;
			month[6] = 30;
			month[7] = 31;
			month[8] = 31;
			month[9] = 30;
			month[10] = 31;
			month[11] = 30;
			month[12] = 31;

			int count = 0;
			int start_month = sc.nextInt();
			int start_day = sc.nextInt();
			int end_month = sc.nextInt();
			int end_day = sc.nextInt();

			while (!(start_month == end_month) || !(start_day == end_day)) {
				if (start_month != end_month) {
					count += month[start_month];
					start_month++;
				} else {
					if (start_day != end_day) {
						count+=end_day-start_day;
						start_day=end_day;
					}
				}
			}
			System.out.println("#"+(t+1)+" "+(count+1));
		}
	}
}
