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

public class bj_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> dequeA = new LinkedList<Integer>();
		Deque<Integer> dequeB = new LinkedList<Integer>();
		StringTokenizer st;
		Iterator<Integer> itr;
		st = new StringTokenizer(br.readLine()," ");
		int number = Integer.parseInt(st.nextToken());
		for(int i=1;i<=number;i++) {
			dequeA.addLast(i);
			dequeB.addLast(i);
		}
		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		int cmp1=0,cmp2=0;
		int value1=0,value2=0;
		int count=0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			num[i]= Integer.parseInt(st.nextToken());
			if(dequeA.peekFirst()==num[i]) {
				dequeA.pollFirst();
				dequeB.pollFirst();
			}else {
				while(true) {
					value1=dequeA.pollFirst();
					dequeA.addLast(value1);
					cmp1++;
					if(dequeA.peekFirst()==num[i]) {
						dequeA.pollFirst();
						break;
					}
					
				}
				while(true) {
					value2=dequeB.pollLast();
					dequeB.addFirst(value2);
					cmp2++;
					if(dequeB.peekFirst()==num[i]) {
						dequeB.pollFirst();
						break;
					}
				}
				if(cmp1<=cmp2) {
					count+=cmp1;
					dequeB.removeAll(dequeB);
					itr=dequeA.iterator();
					while(itr.hasNext()) {
						dequeB.addLast(itr.next());
					}
				}else {
					count+=cmp2;
					dequeA.removeAll(dequeA);
					itr=dequeB.iterator();
					while(itr.hasNext()) {
						dequeA.addLast(itr.next());
					}
				}
				cmp1=0;
				cmp2=0;
			}
		}
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
}
