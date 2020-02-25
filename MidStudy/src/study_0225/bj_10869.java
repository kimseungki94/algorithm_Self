package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_10869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a,b,c;
		a= Integer.parseInt(st.nextToken());
		b= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		if(a>=b && a>=c) System.out.println("A");
		else if(a>=80 && a<=89) System.out.println("B");
		else if(a>=70 && a<=79) System.out.println("C");
		else if(a>=60 && a<=69) System.out.println("D");
		else System.out.println("F");
	}

}
