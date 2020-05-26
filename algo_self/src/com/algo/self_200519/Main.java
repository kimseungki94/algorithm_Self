package com.algo.self_200519;
import java.io.*;
import java.util.*;
public class Main {
    static int n,k,ans;
    static String[] a = new String[51];
    public static void go(int cnt, int learn, int index){
        if(index>26) return;
        if(cnt==k){
            int total = 0;
            for(int i=0; i<n; i++){
                boolean isOk = true;
                String s = a[i];
                for(int j=0; j<s.length(); j++){
                    int num = s.charAt(j)-'a';
                    if((learn&(1<<num))>0) continue;
                    isOk=false;
                    break;
                }
                if(isOk) ++total;
            }
            ans = Math.max(total, ans);
            return;
        }
         
        if(index=='a'-'a' || index=='n'-'a' || index=='t'-'a' || index=='i'-'a' || index=='c'-'a')
            go(cnt,learn,index+1);
        else if(index!='a'-'a' && index!='n'-'a' && index!='t'-'a' && index!='i'-'a' && index!='c'-'a'){
            if(cnt<=k)
                go(cnt+1,(learn|(1<<index)),index+1);
            go(cnt,learn,index+1);
        }
    }
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        k =  Integer.parseInt(st.nextToken())-5;
        if(k<0){
            System.out.println(0);
            System.exit(0);
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            String s = st.nextToken();
            s = s.replaceAll("a","");
            s = s.replaceAll("n","");
            s = s.replaceAll("t","");
            s = s.replaceAll("i","");
            s = s.replaceAll("c","");
            a[i] = s;
        }
         
        go(0,0,0);
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}

