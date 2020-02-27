package study_0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1334_new {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		String tempstr = st.nextToken(); 
		String b;
		String a;
		char[] arr = tempstr.toCharArray();

		
		while(true) {
			int K = arr.length-1;
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]);
				sb2.append(arr[K]);
				K--;
			}
			a = sb.toString();
			b = sb2.toString();
			if(a.equals(b)) {
				bw.write(a+"\n");
				break;
			}else {
				arr[arr.length-1]=(char) ((int)arr[arr.length-1]+1);
				// :가 char형으로 0
				if(arr[arr.length-1]==':') {
					L:while(true) {
						for(int i=1;i<=arr.length;i++) {
							if(arr[arr.length-i]==':') {
								arr[arr.length-i]=48; // 아스키 코드로 변환해서 0으로 바꿈
								arr[arr.length-i-1]+=1; // 그 앞자리 수를 1 더 증가시킴
								if(arr[arr.length-i-1]==':') {
									continue;
								}else {
									break L;
								}				
							}
						}
					}
				}	
				sb.delete(0, sb.length());
				sb2.delete(0, sb2.length());
			}
		}
		bw.flush();
		bw.close();
	}
}
