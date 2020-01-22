package com.algo.self_200121;

import java.util.Scanner;

public class algo_basic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int temp;
		int[] i_array = new int[T];
		for(int test_case = 0; test_case < T; test_case++) {
			i_array[test_case] = sc.nextInt();
		}
		
		for (int i = 1; i < i_array.length; i++) {

			int standard = i_array[i];  

			int j = i - 1;   

			

			while (j >= 0 && standard < i_array[j]) {

				i_array[j + 1] = i_array[j];  

				j--;

			}

			i_array[j + 1] = standard; 

		}

		for(int test_case = 0; test_case < T; test_case++) {
			System.out.println(i_array[test_case]);
		}
		System.out.println(i_array[T/2+1]-1);
	}

}
