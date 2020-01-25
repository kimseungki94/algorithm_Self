/**************************************************************
    Problem: 1856
    User: skkim0832
    Language: Java
    Result: Success
    Time:407 ms
    Memory:21984 kb
****************************************************************/
package com.algo.self_200125;

import java.util.Scanner;

public class jo_1856 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int basic=1;
        int sum1 = sc.nextInt();
        int sum2 = sc.nextInt();
        int[][] num = new int[sum1][sum2];
 
        if (sum1 > 0 && sum1 < 100 && sum2 > 0 && sum2 < 100) {
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[0].length; j++) {
                    num[i][j]=basic;
                    basic+=1;
                }   
            }   
            for (int i = 0; i < num.length; i++) {
                if(i%2==0) {
                    for (int j = 0; j < num[0].length; j++) {
                        System.out.print(num[i][j]+ " ");
                    }   
                }else {
                    for (int j = num[0].length-1; j >= 0; j--) {
                        System.out.print(num[i][j]+ " ");
                    }   
                }
                System.out.println();
            }
        }
    }
}
