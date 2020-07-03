package programmers_Level1;

import java.util.*;

class pro_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        int answerindex=0;
        
        for(int t =0;t<commands.length;t++){
            int index = commands[t][1]-commands[t][0]+1;
            int[] arr = new int[index];
            
            int arrindex=0;
            for(int i=commands[t][0]-1;i<commands[t][1];i++){
                arr[arrindex]=array[i];
                arrindex++;
            }
            
            Arrays.sort(arr);
            answer[answerindex] = arr[commands[t][2]-1];
            answerindex++;
        }
        
        return answer;
    }
}