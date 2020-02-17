package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P04_BitmaskTest {
	static int[] numbers;
	static int N,R,totalCount;
	static boolean[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		R=sc.nextInt();
		numbers = new int[R];
		selected = new boolean[N+1];
		permutation(0,0);
		System.out.println("총 순열의 경우의 수 : "+totalCount);
	}
	
	// index자리에 올 수를 뽑아 기존 뒤에 붙이기...
	
	private static void permutation(int index,int selected) {
		if(index==R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int k = 1; k <= N; k++) {
			// k수 index 자리에 선택 시도
			// 1 << 2 는 인덱스 2에 시프팅을 함!
			// 1 << k
			if((selected & (1<<k)) == 0) {
				numbers[index] = k;
				permutation(index+1, selected | (1<<k));
			}
			
		}
		
	}

}
