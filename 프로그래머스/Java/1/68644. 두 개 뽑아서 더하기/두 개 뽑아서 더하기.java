import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {

        int[] list = new int[200];
        int answerlength = 0;

        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                int cnt = numbers[i]+ numbers[j];
                if (list[cnt] == 0){
                    answerlength ++;
                    list[cnt] = 1;
                }
            }
        }

        int[] answer = new int[answerlength];

        int idx = 0;
        for (int i=0;i<list.length;i++){
            if (list[i] == 1){
                answer[idx++] = i;
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}