package com.algo.self_200128;
import java.util.Scanner;

public class jo_1304_김승기{
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int basic = 1;
        int sum1 = sc.nextInt();
        int[][] num = new int[sum1][sum1];
 
        if (sum1 > 0 && sum1 <= 100) {
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num.length; j++) { 
                    num[i][j] = basic;
                     
                }
                basic += 1;
            }
            for (int i = 0; i < num.length; i++) {
                int solve=0;
                for (int j = 0; j <num.length; j++) {
                    System.out.printf("%d ",num[i][j]+solve);
                    solve+=num.length;
                }
                System.out.println();
            }
        }
 
    }
}
