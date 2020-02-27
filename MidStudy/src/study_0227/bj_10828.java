package study_0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_10828 {

	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String str1,str2;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken();
			if(str1.equals("push")) {
				str2=st.nextToken();
				stack.push(str2);
			}else if(str1.equals("pop")) {
				if(stack.size()==0) {
					bw.write("-1"+"\n");
				}else {
					bw.write(stack.peek()+"\n");
					stack.pop();	
				}
				
			}else if(str1.equals("top")) {
				if(stack.size()==0) bw.write("-1"+"\n");
				else bw.write(stack.peek()+"\n");
			}else if(str1.equals("size")) {
				bw.write(stack.size()+"\n");
			}else if(str1.equals("empty")) {
				if(stack.size()==0) {
					bw.write("1"+"\n");
				}else {
					bw.write("0"+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
