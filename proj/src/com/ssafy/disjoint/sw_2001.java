package com.ssafy.disjoint;
import java.util.Scanner;

public class sw_2001 {
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int count=0;
			int size = sc.nextInt();
			int at_size = sc.nextInt();
			int[][] map = new int[size][size];
			int[][] attack = new int[at_size][at_size];
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int temp=0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					
					for(int k=i;k<i+at_size;k++) {
						for (int k2 = j; k2 < j+at_size; k2++) {
							if(k>=size || k2>=size) {
								temp+=0;
							}else {
								temp+=map[k][k2];
							}			
						}
					}
					if(count<temp) {
						count=temp;
					}
					temp=0;
				}
				
			}
			
			System.out.println("#"+(t+1)+" "+count);
		}
	}
}