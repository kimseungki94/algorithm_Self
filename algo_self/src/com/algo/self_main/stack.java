package com.algo.self_main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class stack {
	static long count = 0;
	static boolean select = true;

	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String text = bf.readLine();
		Stack<Character> stack = new Stack<Character>();
		char c;
		for(int i=0;i<text.length();i++) {
			c = text.charAt(i);
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case ')':
				stack.push(c);
				break;
			case '*':
				stack.push(c);
				break;
			case '/':
				stack.push(c);
				break;
			case '-':
				stack.push(c);
				break;
			case '+':
				stack.push(c);
				break;
			default:
				System.out.print(c+" ");
				break;
			}
			
		}
	}
	private static void name() {
		
	}
}