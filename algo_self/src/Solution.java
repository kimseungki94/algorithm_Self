import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Solution {
    static String text;
    static char[] store;
    static int max;
    static int N;
    static int size;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        
        int T =Integer.parseInt(st1.nextToken());
        for (int t = 0; t < T; t++) {
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            text = st.nextToken();
            store = text.toCharArray();
            N = Integer.parseInt(st.nextToken());
            size = store.length;
            
            search(0, 0);
            System.out.println("#" + (t+1) + " " + max);
        }
    }
 
    private static void search(int num, int index) {
        if (num == N) {
        	if(max<Integer.parseInt(text)) {
        		max=Integer.parseInt(text);
        	}
            return;
        }
        for (int i = index; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if(text.charAt(i)<=text.charAt(j)) {
                swp(i, j);
                search(num + 1, i);
                swp(j, i);
                }
            }
        }
    }
 
    private static void swp(int a, int b) {
        StringBuilder stb = new StringBuilder(text);
        char textA = text.charAt(a);
        char textB = text.charAt(b);
        stb.setCharAt(a, textB);
        stb.setCharAt(b, textA);
        text = stb.toString();
        //System.out.println(text);
    }
 
}