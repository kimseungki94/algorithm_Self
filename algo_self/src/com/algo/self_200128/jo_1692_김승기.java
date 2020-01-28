package com.algo.self_200128;
import java.util.Scanner;

public class jo_1692_김승기{


		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int A = sc.nextInt();
			int B = sc.nextInt();
			int result;
			if(A>=100 && A<1000 && B>=100 && B<1000) {
				int sol1 = A*(B%10);
				int sol2 = A*(B/10%10);
				int sol3 = A*(B/100%10);
				
				
				System.out.println(sol1);
				System.out.println(sol2);
				System.out.println(sol3);
				result = sol1+sol2*10+sol3*100;
				System.out.println(result);
			}else {
				System.out.println();
			}
			
		}

}