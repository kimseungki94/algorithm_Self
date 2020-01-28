package com.algo.self_200128;
import java.util.Scanner;

public class jo_1307_김승기 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int length = sc.nextInt();
	        int[][] rect = new int[length][length];
	        int cha = 64;
	        cha =64+(length*length)%26;
	        for(int i=0;i<length;i++) {
	            for(int j=0;j<length;j++) {
	                if(cha==64) {
	                    cha=90;
	                }
	                rect[j][i]=cha;
	                cha--;
	            }
	        }
	        for(int i=0;i<length;i++) {
	            for(int j=0;j<length;j++) {
	                System.out.print((char)rect[i][j] + " ");
	            }
	            System.out.println();
	        }
	         
	    }
}
