package com.algo.self_200128;
import java.util.Scanner;

public class jo_1430_김승기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int result;
		int[] num = new int[10];
		int number=1;
		if(A>=100 && B>=100 && C>=100 && A<1000 && B<1000 && C<1000) {
			result = A*B*C;
			double count=Math.log10(result);
			for(int z=0;z<=(int)count;z++) {		
				for(int i=0;i<10;i++) {
					
					if(i==(result/number)%10) {
						num[i]+=1;
					}	
				}
				number*=10;
			}
			for(int i=0;i<10;i++) {
				System.out.println(num[i]);
			}
		}
	}


}
