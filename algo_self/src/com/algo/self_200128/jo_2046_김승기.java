package com.algo.self_200128;
import java.util.Scanner;

public class jo_2046_김승기{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select1 = sc.nextInt();
		int select2 = sc.nextInt();
		
		if(select2==1) {
			for(int i=1;i<=select1;i++) {
				for(int j=0;j<select1;j++) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
		} else if(select2==2) {
			for(int i=1;i<=select1;i++) {
				if(i%2==1) {
					for(int j=1;j<=select1;j++) {
						System.out.print(j+" ");
					}
					
				}else if(i%2==0){
					for(int j=select1;j>=1;j--) {
						System.out.print(j+" ");
					}
				}else {
					break;
				}
				System.out.println();
			}
		} else if(select2==3) {
			for(int i=1;i<=select1;i++) {
				for(int j=1;j<=select1;j++) {
					System.out.print(i*j+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println();;
		}
	}
}
