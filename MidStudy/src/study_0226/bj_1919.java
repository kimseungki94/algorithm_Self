package study_0226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[] store1 = new int[26];
		int[] store2 = new int[26];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String str2 = st.nextToken();

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			store1[((int) arr1[i] - 97)] += 1;
		}
		for (int i = 0; i < arr2.length; i++) {
			store2[((int) arr2[i] - 97)] += 1;
		}
		for (int i = 0; i < store1.length; i++) {
			if (store1[i] != store2[i]) {
				if (store1[i] - store2[i] < 0) {
					count += (store1[i] - store2[i]) * -1;
				} else {
					count += (store1[i] - store2[i]);
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}
}
