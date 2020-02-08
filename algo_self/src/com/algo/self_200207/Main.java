package com.algo.self_200207;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int size;
	static String text;
	char temp;
	static int[] array = new int[2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> st= new Stack<String>();
		size = sc.nextInt();
		text = sc.next();
		
		Solve(0);
	}
	static private void Solve(int index) {
		if(index==size+1) {
			System.out.println();
			return;
		}
		
		if(text.charAt(index)=='+' || text.charAt(index)=='-' 
				|| text.charAt(index)=='*') {
			array[0] = text.charAt(index-1)-'0';
			array[1] = text.charAt(index-1)-'0';
			if(text.charAt(index)=='+') {
				array[0]=array[0]+array[1];
			}else if(text.charAt(index)=='-') {
				array[0]=array[0]-array[1];
			}
			else if(text.charAt(index)=='*') {
				array[0]=array[0]*array[1];
			}
		}else {
			
		}
		Solve(index+1);
		
		Solve(index+1);
	}

}
