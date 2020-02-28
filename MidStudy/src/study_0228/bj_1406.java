package study_0228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		Stack<String> stackA = new Stack<String>();
		Stack<String> stackB = new Stack<String>();
		String[] str = st.nextToken().split("");
		for(int i=0;i<str.length;i++) {
			stackB.push(str[i]);
		}
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		String str1,str2;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			str1= st.nextToken();
			if(str1.equals("P")) {
				str2=st.nextToken();
				stackB.push(str2);
			}else if(str1.equals("L")) {
				if(!stackB.isEmpty()) {
					stackA.push(stackB.pop());
				}
			}else if(str1.equals("D")) {
				if(!stackA.isEmpty()) {
					stackB.push(stackA.pop());
				}
			}else if(str1.equals("B")) {
				if(!stackB.isEmpty()) {
					stackB.pop();
				}
			}	
		}
		while(true) {
			if(!stackA.isEmpty()) {
				stackB.push(stackA.pop());
			}else {
				break;
			}
		}
		int SIZE=stackB.size();
		for(int i=0;i<SIZE;i++) {
			sb.append(stackB.pop());
		}
		bw.write(sb.reverse()+"\n");
		bw.flush();
		bw.close();
	}

}
