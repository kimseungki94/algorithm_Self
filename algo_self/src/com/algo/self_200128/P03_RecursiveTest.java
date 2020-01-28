package com.algo.self_200128;

import java.util.Scanner;

public class P03_RecursiveTest {
	static int[] numbers;
	static int N,R,C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt(); 
		N=6;
		
		C=sc.nextInt();
		numbers = new int[R]; // 뽑힌 R개의 수 저장...
		permutation(0);
	}
	// x번째 수 뽑아 기존 순서 뒤에 붙이기
	private static void permutation(int index) {
		if(index == R) { // 순열 완성
			int sum=0;
			for(int i=0;i<R;i++) {
				sum+=numbers[i];
			}
			if(sum==C) {
				for(int i=0;i<R;i++) {
					System.out.print(numbers[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
			numbers[index] =i;
			permutation(index+1); 
		}
	}
}
