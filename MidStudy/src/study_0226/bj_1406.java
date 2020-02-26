package study_0226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Character> arraylist = new ArrayList<Character>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int curser;

		for (int t = 0; t < N; t++) {
			curser = 0;
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '<') {
					if (curser == 0) {
						continue;
					} else {
						curser--;
					}
				} else if (arr[i] == '>') {
					if (curser == arraylist.size()) {
						continue;
					} else {
						curser++;
					}
				} else if (arr[i] == '-') {
					 if(curser!=0) {
						arraylist.remove(curser - 1);
						curser--;
					}
				} else {
					arraylist.add(curser, arr[i]);
					curser++;
				}

			}
			for (int j = 0; j < arraylist.size(); j++) {
				bw.write(arraylist.get(j));
			}
			bw.write("\n");
			arraylist.removeAll(arraylist);
		}
		bw.flush();
		bw.close();
	}

}
