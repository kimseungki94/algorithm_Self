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

public class bj_5430 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		Deque<String> deque = new LinkedList<String>();
		Deque<String> tempdeque = new LinkedList<String>();
		StringTokenizer st;
		Iterator<String> itr;
		st = new StringTokenizer(br.readLine());
		String[] command;
		String[] num;
		boolean visited;
		int N = Integer.parseInt(st.nextToken());
		for(int t=0;t<N;t++) {
			visited = false;
			st = new StringTokenizer(br.readLine());
			command = st.nextToken().split("");
			st = new StringTokenizer(br.readLine());
			num = new String[Integer.parseInt(st.nextToken())];
			st = new StringTokenizer(br.readLine());
			String tempstr = st.nextToken();
			num=tempstr.replace("[", "").replace("]", "").split(",");
			//System.out.println(tempstr);
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
					itr = deque.iterator();
					//temp 덱으로 뒤집기
					for(int j=0;j<deque.size();j++) {
						tempdeque.addFirst(itr.next());
					}
					deque.removeAll(deque);
					itr = tempdeque.iterator();
					for(int j=0;j<tempdeque.size();j++) {
						deque.addLast(itr.next());
					}
					tempdeque.removeAll(tempdeque);
				}else if(command[i].equals("D")) {
					if(deque.size()==0) {
						bw.write("error"+"\n");
						visited=true;
						break L;
					}else {
						deque.pollFirst();
					}
				}
			}
			if(!visited) {
				String sstr = "[";
				int SIZE=deque.size();
				for(int i=0;i<SIZE;i++) {
					if(i==SIZE-1) {
						sstr+=deque.pollFirst();
					}else {
						sstr+=deque.pollFirst()+",";
					}
				}
				sstr+="]";
				
				sstr.replaceAll(" ", "");
				bw.write(sstr+"\n");
				sstr="";
			}		
			deque.removeAll(deque);
		}
		
		
		bw.flush();
		bw.close();
	}
}



