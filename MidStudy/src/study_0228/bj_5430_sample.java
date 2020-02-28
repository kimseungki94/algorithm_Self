package study_0228;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

 
public class bj_5430_sample {
	//R : 배열 순서 뒤집기
	//D : 첫 번째 꺼 버리기(배열 비어있으면 error출력)
	static String[] command;
	static String[] inputArr;
	static int[] arr;
	static boolean Reverse;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int t=0;t<T;t++) {
			deque.clear();
			Reverse = false;
			command = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			String inputStr = br.readLine();
			inputArr = inputStr.substring(1, inputStr.length()-1).split(",");
			
			for(int i=0; i<n; i++) {
				 	deque.add(Integer.parseInt(inputArr[i]));
			}
			
			for(int i=0; i<command.length; i++) {
				if(command[i].equals("R")) {
					Reverse = !Reverse;
				}else {
					if(!deque.isEmpty()) {
						if(Reverse) {
							deque.pollLast();
						}else {
							deque.pollFirst();

						}
					}else {
						sb.append("error");
						break;
					}
				}
				
				int dequeSize = deque.size();
				if(i == command.length-1) {
					sb.append("[");
					if(Reverse) {
						for(int j=0; j<dequeSize; j++) {
							sb.append(deque.pollLast()+",");
						}
					}else {
						for(int j=0; j<dequeSize; j++) {
							sb.append(deque.pollFirst()+",");
						}
					}
					if(dequeSize != 0) {
						sb.delete(sb.length()-1, sb.length());	
					}
					sb.append("]");
				}
			}
				sb.append("\n");

		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}