package study_0228;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stackA = new Stack<Character>();
		Stack<Character> stackB = new Stack<Character>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());

			char[] arr = st.nextToken().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '<') {
					if (!stackB.isEmpty()) {
						stackA.push(stackB.pop());
					} 
				} else if (arr[i] == '>') {
					if (!stackA.isEmpty()) {
						stackB.push(stackA.pop());
					} 
				} else if (arr[i] == '-') {
					 if(!stackB.isEmpty()) {
						stackB.pop();
					}
				} else {
					stackB.push(arr[i]);
				}
			}
			while(true) {
				if(!stackA.isEmpty()) {
					stackB.push(stackA.pop());
				}else {
					break;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				if(!stackB.isEmpty()) {
					sb.append(stackB.pop());	
				}else {
					break;
				}
				
			}
			sb.reverse();
			bw.write(sb+"\n");
			sb.delete(0, sb.length());
		}
		bw.flush();
		bw.close();
	}
}

