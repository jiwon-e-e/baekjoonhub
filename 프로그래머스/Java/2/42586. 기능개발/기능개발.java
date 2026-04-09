import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // answer 는 arrayList 로 수정
        List<Integer> answer = new ArrayList<>();
        int pointer = 0;

        // pointer (0에서 시작) 가 progresses 와 똑같아지면 break;
        while (pointer < progresses.length){

            for (int i=pointer;i<progresses.length;i++){
                progresses[i] += speeds[i];
            }

            int todayProdCount = 0; // answer 에 더해질 값

            while (pointer<progresses.length && progresses[pointer] >= 100){
                todayProdCount++; // 앞에서 부터 보는데 100이 넘는다(배포가 가능하다) -> Count++
                pointer++;
            }

            if (todayProdCount == 0) continue; // 0이면 넣을 필요 없음

            answer.add(todayProdCount);
//            System.out.println(todayProdCount);
        }

        // 반복문 돌면서 progresses 에 speed 더하기
        // speed 더하고 다시 처음부터 확인해서 100 이하인 값이 나올때까지 answer에다가 처음에다가 값 더하기

        return answer.stream().mapToInt(i->i).toArray();
    }
}