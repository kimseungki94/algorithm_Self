package programmers_Level1;


class pro_42840 {
    public int[] solution(int[] answers) {
        int score1=0,score2=0,score3=0;
        for(int i=0;i<answers.length;i++){          
            if((i%5)+1==answers[i]){
                score1++;
            }
            
            if(i%2==0&&answers[i]==2){
                score2++;
            }else if(i%8==1 && answers[i]==1){
                score2++;
            }else if(i%8==3 && answers[i]==3){
                score2++;
            }else if(i%8==5 && answers[i]==4){
                score2++;
            }else if(i%8==7 && answers[i]==5){
                score2++;
            }
            if(i%10<2 && answers[i]==3){
                score3++;
            }else if(i%10>=2 && i%10<4 && answers[i]==1){
                score3++;
            }else if(i%10>=4 && i%10<6 && answers[i]==2){
                score3++;
            }else if(i%10>=6 && i%10<8 && answers[i]==4){
                score3++;
            }else if(i%10>=8 && i%10<10 && answers[i]==5){
                score3++;
            }
    }

    if(score1 > score2 && score1 >score3){
       int[] answer = {1}; 
       return answer;
    }else if(score1 ==score2 && score1 ==score3){
        int[] answer = {1,2,3};
        return answer;
    }else if(score1 ==score2 && score1 >score3){
        int[] answer = {1,2};
        return answer;
    }else if(score1 == score3 && score1 >score2){
        int[] answer = {1,3};
        return answer;
    }else if(score2 >score1 && score2 >score3){
        int[] answer = {2};
        return answer;
    }else if(score2 >score1 && score2 == score3){
        int[] answer = {2,3};
        return answer;
    }else if(score3 > score1 && score3 >score2){
        int[] answer = {3};
        return answer;
    }else{
        int[] answer = {-1};
        return answer;
    }

 	
    }
}