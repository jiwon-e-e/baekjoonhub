class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int correctNum= 0;
        int zero = 0;
        
        for (int i=0;i<6;i++){
            if (lottos[i] == 0){
                System.out.println("zero: "+i);
                zero++;
                continue;
            }
            for (int j=0;j<6;j++){
                if (lottos[i] == win_nums[j]){
                    System.out.println("correct: "+i);
                    correctNum++;
                }
            }
        }
        
        System.out.println("Correct: "+correctNum);
        System.out.println("Zero: "+zero);
        
        // 맞은 문제의 개수와 0의 개수는 잘 출력되고 있음 
        

        answer[0] = 7-(correctNum+zero);
        answer[1] = 7-correctNum;
        
        if (correctNum == 0 && zero == 0) answer[0] = 6;
        if (correctNum == 0) answer[1] = 6;
        
        
        return answer;
    }
}