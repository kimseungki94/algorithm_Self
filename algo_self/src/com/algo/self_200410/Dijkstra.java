package com.algo.self_200410;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for(int i=0;i<E;i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		int[] D = new int[V];
		Arrays.fill(D,Integer.MAX_VALUE); // 가장 작은 값을 기억할 변수
		boolean[] check = new boolean[V];
		// 다익스트라 시작점이 a정점이라면 D[a]=0;
		D[0]=0;
		for(int i=0;i<V-1;i++) {
			
			int min = Integer.MAX_VALUE;
			int index = -1; // 그 위치를 기억할 변수
			for(int j=0;j<V;j++) {
				if(!check[j] && min > D[j]) {
					min=D[j];
					index=j;
				}
			}
			//연결이 없는 경우 끝
			if(index == -1) {
				break;
			}
			//새로운 친구로부터 갈수있는 경로들을 업데이트
			//처리된 놈으로 체크
			for(int j=0;j<V;j++) {
				//아직 처리하지 않았으면서(!check[j], 경로가존재하고(adj[index][j]!=0,D[index] + adj[index][j] < D[j]
				if(!check[j] && adj[index][j]!=0 && D[index] + adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j];
				}
			}
			//처리된 놈으로 체크
			check[index] = true;
		}
		System.out.println(Arrays.toString(D));
	}
	
}
