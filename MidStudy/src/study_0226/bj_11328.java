package study_0226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_11328 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] store1 = new int[26];
		int[] store2 = new int[26];
		
		for(int T=0;T<N;T++) {

			st = new StringTokenizer(br.readLine());
			boolean compare=true;
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			char[] arr1 = str1.toCharArray();
			char[] arr2 = str2.toCharArray();
			for(int i=0;i<arr1.length;i++) {
				store1[((int)arr1[i]-97)]+=1;
			}
			for(int i=0;i<arr2.length;i++) {
				store2[((int)arr2[i]-97)]+=1;
			}
			for(int i=0;i<store1.length;i++) {
				if(store1[i]!=store2[i]) {
					compare=false;
				}
			}
			if(compare) bw.write("Possible\n");
			else bw.write("Impossible\n");
			
			for(int i=0;i<store1.length;i++) {
				store1[i]=0;
				store2[i]=0;
			}
		}	
		bw.flush();
		bw.close();
	}
}
