package com.algo.self_200125;

import java.util.Scanner;

public class jo_1303 {
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int sum1 = sc.nextInt();
	    int sum2 = sc.nextInt();
	    int sample=1;
	    if (sum1 > 0 && sum1 < 100 && sum2 > 0 && sum2 < 100) {
	        for (int i = 1; i <= sum1; i++) {
	            for (int j = 1; j <= sum2; j++) {
	                System.out.printf("%d ",sample);
	                sample++;
	            }
	            System.out.println();
	             
	        }
	    }
	}
}
