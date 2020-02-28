package study_0228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_5430_new {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<String> deque = new LinkedList<String>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String[] command;
		String[] num;
		boolean visited;
		int N = Integer.parseInt(st.nextToken());
		for(int t=0;t<N;t++) {
			boolean reverse=false;
			deque = new LinkedList<String>();
			visited = false;
			st = new StringTokenizer(br.readLine());
			command = st.nextToken().split("");
			st = new StringTokenizer(br.readLine());
			num = new String[Integer.parseInt(st.nextToken())];
			st = new StringTokenizer(br.readLine());
			String tempstr = st.nextToken();
			num=tempstr.replace("[", "").replace("]", "").split(",");
			if(num[0].equals("")) {
				bw.write("error"+"\n");
				visited=true;
				continue;
			}
			for(int i=0;i<num.length;i++) {
				deque.addLast(num[i]);
			}
			L:for(int i=0;i<command.length;i++) {
				if(command[i].equals("R")) {
					reverse=!reverse;
					//temp 덱으로 뒤집기
				}else if(command[i].equals("D")) {
					if(deque.size()==0) {
						bw.write("error"+"\n");
						visited=true;
						break L;
					}else {
						if(reverse) {
							deque.pollLast();
						}else {
							deque.pollFirst();
						}
					}
				}
			}
			if(!visited) {
				sb.append("[");
				int SIZE=deque.size();
				if(reverse) {		
					for(int i=0;i<SIZE;i++) {
							sb.append(deque.pollLast()+",");
					}
				
				}else {
					for(int i=0;i<SIZE;i++) {
						sb.append(deque.pollFirst()+",");
				}	
				}
				if(SIZE != 0) {
					sb.delete(sb.length()-1, sb.length());	
				}
				sb.append("]"+"\n");	
				
				bw.write(sb.toString());
				sb.delete(0, sb.length());
			}
		}
		
		
		bw.flush();
		bw.close();
	}
}



