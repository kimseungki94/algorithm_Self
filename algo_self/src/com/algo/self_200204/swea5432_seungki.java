package com.algo.self_200204;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class swea5432_seungki {
	static int count = 0;
	static int stick = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int test =sc.nextInt();
		for(int T=1;T<=test;T++) {
			count=0;
			String line=null;
			line = sc.next();
			final int SIZE = line.length();
			Stack<Character> stack = new Stack<Character>(); // 여는괄호 저장
			char[] store = new char[SIZE];
			L: for (int i = 0; i < SIZE; i++) {				
				char c = line.charAt(i);
				switch (c) {
				
				case '(':
					store[i]=c;
					stack.push(c);
						stick = stick + 1;
						break;
					
				case ')':
					if (stack.isEmpty()) {
						break L;
					}
					store[i]=c;
					if (store[i-1]==')') {
						stack.pop();
						stick = stick - 1;
						count+=1;
						
						break;
					} else  {
						stick = stick - 1;
						count += stick;
						
						
						break;
						
					}
				default:
					break L;
				}

			}

			System.out.println("#"+T+" "+count);
		}
		
		
	}

}
