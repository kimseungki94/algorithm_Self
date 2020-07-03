package programmers_Level1;

import java.util.*;
import java.awt.*;
public class pro_12906 {
    public int[] solution(int []arr) {
        int[] answer = {};
        int judge=0;
        int index=0;
        
        
        for(int i=1;i<arr.length;i++){
            if(arr[judge]==arr[i]){
                arr[i]=-1;
            }else{
                judge=i;
                index++;
                continue;
            }    
        }
        int length=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                continue;
            }
            else{
                length++;
            }
        }
        answer = new int[length];
        int startindex=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                continue;
            }else{
                answer[startindex]=arr[i];
                startindex++;
            }
        }
        
        
        return answer;
    }
}