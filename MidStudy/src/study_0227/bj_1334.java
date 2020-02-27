package study_0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_1334 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb;
		long N = Long.parseLong(st.nextToken());
		System.out.println("a");
		while(true) {
			String str = Long.toString(N);
			sb = new StringBuilder(str);
			String b = sb.toString();
			String a = sb.reverse().toString();
			System.out.println(N);
			if(a.equals(b)) {
				bw.write(N+"\n");
				break;
			}else {
				N++;
				sb.delete(0, sb.length());
			}
		}
		
		bw.flush();
		bw.close();
	}

}
