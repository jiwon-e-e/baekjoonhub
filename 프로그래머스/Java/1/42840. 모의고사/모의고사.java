import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        // for (시험문제 전체 ) 하면서
        // answers[i%5] = method1[i%5] 인지...

        int[] method1 = {1, 2, 3, 4, 5};
        int[] method2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] method3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = {0, 0, 0};

        for (int i=0 ;i<answers.length; i++){
            if (answers[i] == method1[i%5]){
                correct[0]++;
            }
            if (answers[i] == method2[i%8]){
                correct[1]++;
            }
            if (answers[i] == method3[i%10]){
                correct[2]++;
            }
        }

        int max = Math.max(Math.max(correct[1], correct[0]),correct[2]);
        for (int i=0; i<3; i++) {
            if (correct[i] == max) {
                answer.add(i + 1);
            }
        }

        int[] returnAnswer = new int[answer.size()];
        for (int i=0;i< answer.size();i++){
            returnAnswer[i] = answer.get(i);
        }


        return returnAnswer;
    }
}