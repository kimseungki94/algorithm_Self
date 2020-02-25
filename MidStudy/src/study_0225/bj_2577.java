package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result;
		int[] num = new int[3];
		int[] store = new int[10];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		result = num[0] * num[1] * num[2];
		String str = Integer.toString(result);
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 10; j++) {
				if ((int) arr[i] - '0' == j)
					store[j]++;
			}
		}
		for (int i = 0; i < 10; i++)
			System.out.println(store[i]);
	}
}
