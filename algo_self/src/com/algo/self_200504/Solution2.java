package com.algo.self_200504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2 {
   static char[][] map;
   static int X, Y, N;
   static Queue<Integer> q = new LinkedList<>();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t <= T; t++)
      {
         sb.append('#').append(t).append('\n');
         
         // 변수선언
         st = new StringTokenizer(br.readLine(), " ");
         // 가로 세로 선언
         Y = Integer.parseInt(st.nextToken());
         X= Integer.parseInt(st.nextToken());
         map = new char[Y][X];
         
        
         for(int i = 0; i < X; i++)
         {
            String str = br.readLine();
            //map 생성
            for(int k = 0; k < X; k++)
               map[i][k] = str.charAt(k);
         }
         // 화산탄의 횟수
         N = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine(), " ");
         
         // 화산탄 열 받기
         while(st.hasMoreTokens())
            q.add(Integer.parseInt(st.nextToken()) - 1);
         
         // 화산탄 횟수만큼 실행
         int row = 0, column, nR = 0, nC;
         while(!q.isEmpty())
         {
        	 row = 0;
        	 column = q.poll();
            nC = column;
            if(map[row][column] == '.')   // 윗칸이 비어있을때
            {
               map[row][column] = 'O';
               while(true)
               {
                  nR = row + 1;
                  // 바닥이나 장애물에 있으면 정지
                  if(nR >= Y || map[nR][nC] == 'X') 
                     break;
                  else if(map[nR][nC] == 'O')   // 화산탄이 밑에 있을때
                  {
                     // 왼쪽이 비어있을때
                     if(nC - 1 >= 0 && map[row][nC - 1] == '.' && map[nR][nC - 1] == '.')
                     {
                        map[row][column] = '.'; map[nR][--nC] = 'O'; 
                     }
                     // 오른쪽이 비어있을때
                     else if(nC + 1 < X && map[row][nC + 1] == '.' && map[nR][nC + 1] == '.')
                     {
                        map[row][column] = '.'; map[nR][++nC] = 'O';
                     }
                     else break;
                  }
                  else 
                  {
                     map[row][column] = '.';
                     map[nR][nC] = 'O';
                  }
                  // 위치 최신화
                  row = nR; column = nC;
               }
            } 
         } 
         
         // 3. 출력 
         for(int i = 0; i < Y; i++)
         {
            for(int j = 0; j < X; j++)
               sb.append(map[i][j]).append(' ');
            sb.append('\n');
         }
      }    
      // 결과
      br.close();
      System.out.print(sb);
   } 
} 