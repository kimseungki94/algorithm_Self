package com.ssafy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyChewTest {

	static class Person{
		int no,cnt;
		public Person(int no, int cnt) {
			super();
			this.no = no;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {

		int N = 20;
		int person = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
//		Queue<Person> queue = new LinkedList<Person>();
		queue.offer(new int[]{person,1});
		
		int[] p;
		int availableCnt;
		while(N>0) {
			p = queue.poll();
			availableCnt = (N >= p[1])?p[1]: N;
			N -= availableCnt;
			if(N==0) {
				System.out.println("마지막 마이쮸를 가져간 사람 : "+p[0]+", 가져간 개수 : "+availableCnt);
			}else {
				System.out.println(p[0]+"번 사람이 "+availableCnt+"만큼 가져갑니다.: 남은개수 : "+N);
				p[1]++;
				queue.offer(p);
				queue.offer(new int[] { ++person, 1});
			}
		}
	}

}































