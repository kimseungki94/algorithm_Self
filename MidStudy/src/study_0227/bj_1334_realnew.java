package study_0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_1334_realnew {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String tempstr = st.nextToken();
		char[] arr = tempstr.toCharArray();
		if(arr.length==1 && (char)(arr[0]+1)!=':') {
			bw.write((char)(arr[0]+1)+"\n");	
		}
		else {
			if(arr.length==1 && (char)(arr[0]+1)==':') {
				arr = new char[2];
				arr[0]='0';
				arr[1]='1';
			}
			
			int starttemp=arr.length-1;
			for (int i = starttemp; i >=0; i--) {
				sb.append(arr[i]);
			}
			if(tempstr.equals(sb.toString())) {
				arr[arr.length-1]++;
				
				for(int i=0;i<arr.length;i++) {
					if(arr[arr.length-1-i]==':' && arr.length-2-i==-1) {
						arr[arr.length-1-i]='0';
						int sample = arr.length;
						arr = new char[sample+1];
						for(int z=sample;z>0;z--) {
							arr[z]='0';
						}
						arr[0]='1';
						break;
					}
					else if(arr[arr.length-1-i]==':') {
						arr[arr.length-1-i]='0';
						arr[arr.length-2-i]=(char) (arr[arr.length-2-i]+1);
					}
					else {
						System.out.println("브레이크");
						break;
					}
				}
				
			}
			
				sb.delete(0, arr.length);
				if (arr.length % 2 == 0) {
					int limit = arr.length / 2;
					int temp = arr.length - 1;
					int limitnum = arr[limit-1];
					int cmpint = arr[limit];
					//샘플로 +1한걸 저장
					char[] samplearr = new char[arr.length];
					for(int i=0;i<arr.length;i++) {
						samplearr[i]=arr[i];
					}
					
					for (int i = 0; i < limit; i++) {
						arr[temp--] = arr[i];
					}
					temp = 0;				
					
					if (cmpint > limitnum) {
						arr[limit - 1] =  (char) (limitnum+1);
						arr[limit]=(char) (limitnum+1);
					}else if(cmpint == limitnum) {
						
						
						boolean judge = false;
						for(int i=0;i<arr.length;i++) {
							if((int)samplearr[i]>(int)arr[i]) {
								judge=true;
							}
						}
						if(judge) {
							for(int i=0;i<arr.length;i++) {
								System.out.print(samplearr[i]);
							}
							System.out.println();
							arr[limit - 1] =  (char) (limitnum+1);
							arr[limit]=(char) (limitnum+1);					
							arr[arr.length-1]++;
							for(int i=0;i<arr.length;i++) {
								if(arr[limit-1-i]==':') {
									arr[limit-1-i]='0';
									arr[limit+i]='0';
									arr[limit-2-i]=(char) (arr[limit-2-i]+1);
									arr[limit+i+1]=(char) (arr[limit+i+1]+1);
									for(int z=0;z<arr.length;z++) {
										System.out.println(arr[z]);
									}
								}else {
									break;
								}
							}
							
						}
					}
					for (int i = 0; i < arr.length; i++) {
						sb.append(arr[i]);
					}
					bw.write(sb+"\n");		
					
					
					
					
					
					
					
					
					
					
					
				} else {
					int limit = arr.length / 2;
					int temp = arr.length - 1;
					int cmp1 = arr[limit-1];
					int cmp2 = arr[limit+1];
					for (int i = 0; i < limit; i++) {
						arr[temp--] = arr[i];
					}
					if(cmp1>cmp2) {
						for (int i = 0; i < arr.length; i++) {
							sb.append(arr[i]);
						}
						System.out.println(sb);
					}else if(cmp1<cmp2){
						arr[limit] = (char) (arr[limit] + 1);
						if (arr[limit] == ':') {
							arr[limit] = 48; // 아스키 코드로 변환해서 0으로 바꿈
							arr[limit-1]=(char) (cmp1+1);
							arr[limit+1]=(char) (cmp1+1);
							for (int i = 0; i < arr.length; i++) {
								sb.append(arr[i]);
							}
							bw.write(sb+"\n");
						}else {
							for (int i = 0; i < arr.length; i++) {
								sb.append(arr[i]);
							}
							bw.write(sb+"\n");
						}
					}else {
						for (int i = 0; i < arr.length; i++) {
							sb.append(arr[i]);
						}
						bw.write(sb+"\n");
					}
				}
		}
		bw.flush();
		bw.close();
	}
}
