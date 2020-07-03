package programmers_Level1;

import java.util.*;
// 오늘의 교훈 : hash 정말 쓸만하다.. 익숙해져야지!
class pro_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> hash = new HashMap<>();
        for(String part : participant){
            if(hash.get(part)==null){
                hash.put(part,1);
            }else{
                int val = hash.get(part)+1;
                hash.put(part,val);
            }
        }
        for(String comp : completion){
            int val = hash.get(comp)-1;
            hash.put(comp,val);
        }
        for(String key : hash.keySet()){
            if(hash.get(key)==1){
                answer=key;
            }
        }
        
        return answer;
    }
}