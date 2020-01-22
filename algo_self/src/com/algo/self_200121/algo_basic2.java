package com.algo.self_200121;

import java.util.Scanner;

public class algo_basic2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int temp;
		int[] i_array = new int[T];
		for(int test_case = 0; test_case < T; test_case++) {
			i_array[test_case] = sc.nextInt();
		}
		for(int i = 0; i < T; i++) {
			for(int j = i; j < T; j++) {
				if(i_array[j]>i_array[j+1]) {
					temp=i_array[j];
					i_array[j]=i_array[j+1];
					i_array[j+1]=temp;
				}
			}
		}
		for(int test_case = 0; test_case < T; test_case++) {
			System.out.println(i_array[test_case]);
		}
	}

}
