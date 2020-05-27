package com.algo.self_200527;

import java.io.*;
import java.util.*;

public class bj_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[20];
		
		for (int i = 0; i < 20; i++) {
			arr[i] = -1;
		}
		
		String command;
		int value;
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (command.equals("all") || command.equals("empty")) {
				if (command.equals("all")) {
					for (int i = 0; i < 20; i++) {
						arr[i] = i + 1;
					}
				} else {
					for (int i = 0; i < 20; i++) {
						arr[i] = -1;
					}
				}
			} else {
				value = Integer.parseInt(st.nextToken());
				if (command.equals("add")) {
					if (arr[value - 1] < 0) {
						arr[value - 1] = value;
					}
				} else if (command.equals("remove")) {
					if (arr[value - 1] > 0) {
						arr[value - 1] = -1;
					}
				} else if (command.equals("check")) {
					if (arr[value - 1] > 0) {
						bw.write("1\n");
					} else {
						bw.write("0\n");
					}
				} else if (command.equals("toggle")) {
					if (arr[value - 1] > 0) {
						arr[value - 1] = -1;
					} else {
						arr[value - 1] = value;
					}
				}
			}
		}
		bw.flush();
		bw.close();
	}

}
