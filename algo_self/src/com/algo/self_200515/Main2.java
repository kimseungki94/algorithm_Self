package com.algo.self_200515;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	static int[] array,temp_array;
	static int[] temple;
	public static void main(String[] args) throws IOException {
		int Mid_num = 0;
		String Check_text="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder left = new StringBuilder();
		StringBuilder br_left = new StringBuilder();
		
		String init = br.readLine();
		
		int len = init.length();
		int check = len/2;
		
		String Left = init.substring(0, check);
		left.append(Left);
		
		String Right;
		String Mid;
		
		
		if(len%2==0) {
			Right = init.substring((len+len%2)/2, check+(len+(len%2))/2);
			Mid=null;
			
		}else {
			 Right = init.substring((len+(len%2))/2, check+(len+(len%2))/2);
			 Mid = init.substring(len/2,(len/2)+1);
			 Mid_num = Integer.parseInt(Mid);
		}
		System.out.println(left);
		System.out.println(Right);
		System.out.println(Mid);
		// 왼 중 우 대입 끝
		
		
		// c++ reverse(Left.begin(), Left.end()); 부분
		left.reverse();
		System.out.println(left);
		boolean flag = false;
		if(Left.length()%2==1) {
			flag = true;
		}
		boolean comp = false;
		for(int i=0;i<Right.length();i++) {
			if(Left.charAt(i)>Right.charAt(i)) {
				comp=true;
				break;
			}else {
				continue;
			}
		}
		int[] left_array = new int[Left.length()];
		for(int i=0;i<Left.length();i++) {
			left_array[i]=init.charAt(i)-'0';
		}
		
		
		
		
		
		System.out.println("초기 br : "+left);

		System.out.println("초기 left : "+Left);
		
		if(len>1) {
			if(comp) {
				left.reverse();
				Check_text+=left;
				if(Mid!=null) {
					Check_text+=Mid;
				}
				left.reverse();
				Check_text+=left;
			}else {
				left.reverse();
				System.out.println("왼쪽 : " +Left);
				if(Mid==null) {
				}else if(Mid.length()==0 || Mid.equals("9")) {
					for(int i=Left.length()-1;i>=0;i--) {
						left_array[i] +=1;
						if(left_array[i]==10) {
							left_array[i]=0;
						}else break;
						
						if(left_array[0]==0) {
							br_left.append(1).append(left);
							left.delete(0, left.length());
							left.append(br_left);
						}
					}
				}
				Check_text += left;
				if(Mid==null) {
				}else if(Mid.length()!=0) {
					if(Mid == "9") {
						Check_text+="0";
					}else {
						Mid_num+=1;
						Check_text+=Mid_num;
					}
				}
				
				left.reverse();
				if((left.length()%2==0 && flag) || (left.length()%2==1) && !flag) {
					Check_text = Check_text.substring(0,Check_text.length()-1);
				}
				Check_text+=left;
			}
			System.out.println(Check_text);
		}else {
			if(init.equals("9")) {
				System.out.println("11");
			}else {
				System.out.println(Integer.parseInt(init)+1);
			}
		}
		for(int i=0;i<len/2;i++) {
			
		}
		array = new int[len];
		for(int i=0;i<len;i++) {
			array[i]=init.charAt(i)-'0';
		}
		
		for(int i=0;i<len;i++) {
			sb.append(array[i]);
		}	
		
		bw.flush();
		bw.close();
	}
}
