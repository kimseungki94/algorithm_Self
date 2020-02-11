package com.ssafy.disjoint;
import java.util.Scanner;

public class sw_1234 {
    static int[] dy= {-1,1,0,0};
    static int[] dx= {0,0,-1,1};
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        //int T = sc.nextInt();
        for (int t = 0; t < 10; t++) {
            int count=0;
            int size = sc.nextInt();
            int[] num = new int[size];
            String store;
            store = sc.next();
            char ch;
            for(int i=0;i<size;i++) {
                num[i] = (int)store.charAt(i)-'0';
            }
            int a=0;
            while(true) {
                for(int i=1;i<size-count;i++) {
                    if(num[i-1]==num[i]) {
                        for(int j=i-1;j<size-count;j++) {
                            if(j+2<size-count) {
                                num[j]=num[j+2];
                                 
                            }
                        }
                        count+=2;
                         
                    }
                }
                a++;
                if(a==10000) {
                    break;
                }
            }
            System.out.println("#"+(t+1)+" ");
            for(int i=0;i<size-count;i++) {
                System.out.print(num[i]);
            }
            System.out.println();
             
        }
    }
}
