package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P05_SwapTest2 {
	static int[] numbers; // 원래 나열된 수들을 통해 스와핑을 함!
	static int N,R,totalCount;
	static boolean[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=4;
		numbers = new int[] {1,2,3,4};
		R=sc.nextInt();
		selected = new boolean[N+1];
		permutation(0);
		System.out.println("총 순열의 경우의 수 : "+totalCount);
	}
	
	// index자리에 올 수를 뽑아 기존 뒤에 붙이기...
	
	private static void permutation(int index) {
		if(index==R) {
			totalCount++;
			for(int i=0;i<R;i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		
		for (int k = index; k < N; k++) { // k : 교환할 대상 자리.. 자기자리에 자기를 포함한 스와핑
			swap(index,k);
			permutation(index+1);
			swap(index,k);
			
		}
		
	}

	private static void swap(int i, int j) {
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}

}
