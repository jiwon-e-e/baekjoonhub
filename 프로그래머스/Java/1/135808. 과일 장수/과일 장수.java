import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        // 정렬해서 큰수부터 m개씩 자르면 뭐가 문제지
        // score length = 12 고
        // 배열은 score[11] 까지만 존재 
        // 0 1 2 3 4 . . .10 11 
        // 0 4 8 뽑아야함 
        int answer = 0;
        
        Arrays.sort(score); // 정렬하고 
        int pointer = score.length;
        
        if (pointer < m) {
            return answer;
        }
        
        while(pointer-m>=0){
            answer+=score[pointer-m]*m;
            pointer -= m;
        }
        return answer;
    }
}