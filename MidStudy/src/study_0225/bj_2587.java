package study_0225;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2587{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum=0;
		int[] num = new int[5];
		for(int t=0;t<5;t++) {
			st = new StringTokenizer(br.readLine());
			num[t]=Integer.parseInt(st.nextToken());
		}
		
		for(int t=0;t<5;t++) sum+=num[t];			
		
		Arrays.sort(num);
		System.out.println(sum/num.length);
		System.out.println(num[2]);
	
	}
}
