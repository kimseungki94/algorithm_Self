package study_0226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] sex = new int[N];
		int[] grade = new int[N];
		int[][] member = new int[2][7];
		int limit=Integer.parseInt(st.nextToken());	
		int count=0;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			sex[i]=Integer.parseInt(st.nextToken());
			grade[i]=Integer.parseInt(st.nextToken());
			member[sex[i]][grade[i]]++;
		}
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				
				if(member[i][j]==0) {
					continue;
				}else {
					if(member[i][j]%limit==0) count+=(member[i][j]/limit);
					else if(member[i][j]%limit!=0) count+=(member[i][j]/limit)+1;
				}
			}
		}

		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
}
