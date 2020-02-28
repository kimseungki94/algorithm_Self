package study_0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_10845 {

	public static void main(String[] args) throws IOException {
		Queue<String> queue = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String str1,str2;
		int value=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken();
			
			if(str1.equals("push")) {
				str2=st.nextToken();
				value=Integer.parseInt(str2);
				
				queue.add(str2);
				
			}else if(str1.equals("pop")) {
				if(queue.size()==0) {
					bw.write("-1"+"\n");
				}else {
					bw.write(queue.peek()+"\n");
					queue.poll();
				}
				
			}else if(str1.equals("back")) {
				if(queue.size()==0) bw.write("-1"+"\n");
				else bw.write(value+"\n");	
			}else if(str1.equals("front")) {
				if(queue.size()==0) bw.write("-1"+"\n");
				else bw.write(queue.peek()+"\n");
			}else if(str1.equals("size")) {
				bw.write(queue.size()+"\n");
			}else if(str1.equals("empty")) {
				if(queue.size()==0) {
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
