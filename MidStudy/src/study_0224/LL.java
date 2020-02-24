package study_0224;

import java.util.LinkedList;

public class LL {
	public static void main(String[] args) {
		LinkedList<Integer> linklist = new LinkedList<Integer>();
		
		for(int i=0;i<24;i++) {
			linklist.add(1);
		}
		int count = 0;
		linklist.set(0, 0);
		while(true) {
		for (int i = 0; i < linklist.size(); i++) {
			
			
			if(linklist.get(i)==1 && count==2) {
				linklist.set(i, 0);
				count=0;
			}
			if(linklist.get(i)==1) {
				count++;
			}
			
		}
		if(count>10000) {
			break;
		}
		System.out.println(linklist.toString());
		}
	}
}
