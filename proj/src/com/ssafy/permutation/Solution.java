package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] numbers; // 원래 나열된 수들을 통해 스와핑을 함!
	static int N, R, totalCount;
	static boolean[] selected;
	static int round=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String text = sc.next();
		char[] store = new char[text.length()];
		for(int i=0;i<text.length();i++) {
			store[i] = text.charAt(i);
			System.out.println(store[i]);
		}
		round = sc.nextInt();
	}
}
