package study_0226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int limit=0;
		int count=1;
		for(int i=0;i<arr.length;i++) {
			arr[i]++;
		}
		System.out.print("<");
		L:while(true) {
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==1 && count!=K) count++;
				else if(arr[i]==1 && count==K) {
					limit++;
					if(limit==arr.length) {
						count=1;
						bw.write((i+1)+">");
						arr[i]=0;
						break L;
					}else {
						count=1;
						System.out.print((i+1)+", ");
						arr[i]=0;
					}	
				}
				else if(arr[i]==0) continue;		
			}
		}
		bw.flush();
        bw.close();
	}
}
