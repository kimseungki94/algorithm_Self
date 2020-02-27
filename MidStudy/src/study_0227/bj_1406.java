package study_0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1406 {
	static String[] arr;
	static String[] data = new String[1000005];
	static int[] prev= new int[1000005];
	static int[] next= new int[1000005];
	static int curser;
	static int datasize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		arr = str.split("");

		// 루트노드 세팅
		data[0] = "root";
		prev[0] = -1;
		next[0] = 1;
		curser = 1;
		// 데이터 저장

		for (int i = 1; i <= arr.length; i++) {
			data[i] = arr[i - 1];
			prev[i] = i - 1;

			if (i == arr.length) {
				next[i] = -1;
			} else {
				next[i] = i + 1;
			}
		}
////		재대로 된지 확인
//		for(int i=0;i<=arr.length;i++) {
//			System.out.print(data[i]+" "+prev[i]+" "+next[i]);
//			System.out.println();
//		}
		st = new StringTokenizer(br.readLine());
		int SIZE = Integer.parseInt(st.nextToken());
		curser = arr.length;
		datasize =curser+1;
		System.out.println("커서 "+curser);
		for (int T = 0; T < SIZE; T++) {
			st = new StringTokenizer(br.readLine());
			String command1 = st.nextToken();
			if (command1.equals("P")) {
				String value=st.nextToken();
				insert(curser,value);
				System.out.println(curser);
			} else if (command1.equals("L")) {
				if (curser == 0)
					continue;
				else
					curser--;
			} else if (command1.equals("R")) {
				if (data[curser + 1] == null)
					continue;
				else
					curser++;
			} else if (command1.equals("B")) {
				delete(curser);
			}
		}
//		for(int i=0;i<=data.length;i++) {
//			if(data[i]==null) {
//				break;
//			}
//			System.out.print(data[i]+" "+prev[i]+" "+next[i]);
//			System.out.println();
//		}
		int temp=0;
		while(true) {
			if(next[temp]==-1) {
				break;
			}
			System.out.print(data[next[temp]]);
			temp=next[temp];
		}
		System.out.println();
	}

	private static void insert(int index, String value) {
		if(next[index]==-1) {
			data[datasize]=value;
			prev[datasize]=index;
			next[datasize]=next[index];
			next[prev[datasize]]=datasize;
		}else {
			data[datasize]=value;
			prev[datasize]=prev[next[index]];
			next[datasize]=next[index];
			
			
			prev[next[index]]=datasize;
			next[index]=datasize;
		}
		curser++;
		datasize++;
		
	}

	private static void delete(int index) {
		if(prev[index]==-1) {
		}
		else if(next[index]==-1) {
			prev[index]=next[index];
		}
		else {
			System.out.println("인덱스 "+index);
			next[prev[index]] = next[index];
			prev[next[index]]=prev[index];
		}
		System.out.println("start1");
		for(int i=0;i<=data.length;i++) {
			if(data[i]==null) {
				break;
			}
			System.out.print(data[i]+" "+prev[i]+" "+next[i]);
			System.out.println();
		}

	}

}
