package study_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_1267 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N;
		int m=0,y=0;
		int msum=0,ysum=0;
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {			
			arr[i] = Integer.parseInt(st.nextToken());
			while(arr[i]>=y) {
				y+=30;
				ysum+=10;
			}
			y=0;
			while(arr[i]>=m) {
				m+=60;
				msum+=15;
			}
			m=0;
		}
		if(ysum>msum) System.out.println("M "+msum);
		else if(ysum<msum) System.out.println("Y "+ysum);
		else if(ysum==msum) System.out.println("Y M "+msum);

	}

}
