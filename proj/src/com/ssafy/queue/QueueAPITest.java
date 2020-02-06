package com.ssafy.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueAPITest {

	public static void main(String[] args) {

/*		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("김재환");
		queue.offer("이동욱");
		queue.offer("이지아");
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());*/
		
		Queue<String> queue  = new PriorityQueue<String>();
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("이동욱");
		queue.offer("김재환");
		queue.offer("이지아");
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		
		
		
	}

}




























