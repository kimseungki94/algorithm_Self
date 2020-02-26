package study_0226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int[] item = new int[11];
		int count=0;
		char[] arr = str.toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='9' || arr[i]=='6') {
				if(item[9]==0 && item[6]==0) {
					count++;
					for(int m=0;m<=9;m++) {
						item[m]++;
					}
					item[arr[i]-'0']--;
				}
				else if(item[9]!=0 && item[6]==0) item[9]--;
				else if(item[9]==0 && item[6]!=0) item[6]--;
				else item[arr[i]-'0']--;
			}else {
				if(item[arr[i]-'0']==0) {
					count++;
					for(int m=0;m<=9;m++) {
						item[m]++;
					}
					item[arr[i]-'0']--;
				}else {
					item[arr[i]-'0']--;
				}
			}	
		}
		bw.write(count+"\n");
		bw.flush();
        bw.close();
	}
}
