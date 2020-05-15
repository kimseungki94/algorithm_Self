package com.algo.self_200504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int doller4; // 4달러개수
	static int doller1; // 1달러개수
	static int cent10; // 10센트개수
	static int T; // 테스트캐이스 횟수
	static boolean judge; // 나누어 떨어지는지 아닌지 확인
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int hour = Integer.parseInt(st.nextToken());
			
			int sum = money*hour; // 받게 되야 할 총 급여
			dfs(sum); // 함수에 태웠습니다
			if(judge) { // judge가 true인건 나누어 떨어지지 않기 땜에 -1
				System.out.println("#"+t+" "+"-1");
			}else { // 재대로 된 경우 변수 출력
				System.out.println("#"+t+" "+doller4+" "+doller1+" "+cent10);
			}
			judge=false;
			doller4=0;
			doller1=0;
			cent10=0;
		}
	}

	private static void dfs(int sum) {
		if(sum>=400) { // 400이상일 경우 400만큼을 빼고 4달러에 +1
			sum=sum-400;
			doller4++;
			if(sum==0) return;
			dfs(sum);
		}else if(sum>=100 && sum<400) { // 400이하 100이상의 경우 100만큼을 빼고 1달러에 +1
			sum=sum-100;
			doller1++;
			if(sum==0) return;
			dfs(sum);
		}else if(sum>0 && sum<100 && sum%10==0) { // 100이하중 0보다 클경우에 10센트에 나누어 떨어지면 10센트에 +1
			sum=sum-10;
			cent10++;
			if(sum==0) return;
			dfs(sum);
		}else { // 나누어 떨어질 수 없는 금액이 나온다면 judge에 true값줌
			judge=true;
			return;
		}
		
	}
	
}
