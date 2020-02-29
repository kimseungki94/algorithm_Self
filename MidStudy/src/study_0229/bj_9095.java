package study_0229;
import java.io.*;

public class bj_9095 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++){
            int N = Integer.parseInt(br.readLine());
            int store[] = new int[N+2];
            store[0] = 1;
            store[1] = 1;
            store[2] = 2;
            for (int j = 3; j <= N; j++){
            	store[j] = store[j-1] + store[j-2] + store[j-3];
            } 
            bw.write(store[N]+"\n");
            
        }
        bw.flush();
        bw.close();
    }
}