package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_10093 {
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long a,b;
		long result1;
		st = new StringTokenizer(br.readLine());
		a=Long.parseLong(st.nextToken());
		b=Long.parseLong(st.nextToken());
		if(a==b) { 
			System.out.println("0");
			return;
		}
		else if((a<b && b-a==1) || (a>b && a-b==1)) {
			System.out.println("0");
			return;
		}else {
			result1 = b-a;
			if(result1<0) {
				result1=a-b-1;
				System.out.println(result1);
				for(long i=b+1;i<=a-1;i++) {
					System.out.print(i+ " ");
				}
			}else {
				result1 = b-a-1;
				System.out.println(result1);
				for(long i=a+1;i<=b-1;i++) {
					System.out.print(i+ " ");
				}
			}
		}
		
		
	}
}
