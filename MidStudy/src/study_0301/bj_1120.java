package study_0301;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		String[] str1 = st.nextToken().split("");
		String[] str2 = st.nextToken().split("");
		// 예를들어 7개의 문자
		// 3개의 문자면
		// 0 2
		// 1 3
		// 2 4
		// 이런식으로 
		// 4 6까지 되게끔...
		int count=0;
		int N = str2.length;
		int size=str1.length;
		int max=0;
		for(int i=0;i<size;i++) {
			
			int temp=i;
			for(int j=0;j<str1.length;j++) {
				if(str1[j].equals(str2[temp])) {
					count++;	
				}
				temp+=1;
			}
			if(count>max) {
				max=count;
			}
			count=0;
			size+=1;
			
			if(size==N+1) {
				break;
			}
		}	
		bw.write(str1.length-max+"\n");
		bw.flush();
		bw.close();
	}
}
