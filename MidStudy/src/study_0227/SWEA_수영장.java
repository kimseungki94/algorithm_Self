package study_0227;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class SWEA_수영장 {
 
    static int T;
    static int[] money = new int[4];
    static int[] play = new int[12];
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for(int a=1;a<=T;a++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
            for (int i = 0; i < 4; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
            	play[i] = Integer.parseInt(st.nextToken());
            }       
            min = money[3];
            permutation(0,0);
            bw.write("#"+ a +" "+min+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void permutation(int status, int sum) {
        
        if(status >= 12) {
        	if(min>sum) {
        		min=sum;
        	}
            return;
        }
     		permutation(status+1,sum+(play[status]*money[0]));
        	permutation(status+1,sum+money[1]);
        	permutation(status+3,sum+money[2]);
    }
}
