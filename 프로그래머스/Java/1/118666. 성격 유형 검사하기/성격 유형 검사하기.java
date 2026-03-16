import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int[] score = new int[4]; //R C J A 가 더 빠름
        String[] surveyList = {"RT", "TR", "CF","FC", "JM", "MJ",  "AN", "NA"};

        for (int i=0;i<survey.length;i++){
            for (int j=0;j<8;j++){
                if(surveyList[j].equals(survey[i])){
                    System.out.println(survey[i] +" "+ j);
                    // RT 가 나왔으면
                    if(j%2 ==0){
                        score[j/2] += (choices[i]-4);
                    }
                    // TR 이 나왔으면
                    else{
                        score[j/2] += (choices[i]-4)*(-1);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(score));

        for (int i=0;i<4;i++){

            if(score[i]>0){
                answer.append(surveyList[i*2].charAt(1));
            }else{
                answer.append(surveyList[i*2].charAt(0));
            }
        }

        return String.valueOf(answer);
    }
}