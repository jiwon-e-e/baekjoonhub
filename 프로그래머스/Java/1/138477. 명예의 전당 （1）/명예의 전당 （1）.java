import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // score 의 길이만큼 k번째 점수가 나와야함
        int[] answer = new  int[score.length];

        List<Integer> kList = new ArrayList<>(); // 명예의 전당 리스트
        int kstScore = 0; // 제일 낮은 값 초기화

        for (int i= 0;i<score.length;i++){
            int chk = 0;
            //System.out.println("\nscore[i] = "+ score[i]);
            //System.out.println("kList.size = " +kList.size());
            // size 가 넘쳤고 새롭게 더 큰 점수가 들어오면 remove 해줘야함

            // 아직 리스트가 비어있으면 바로 add
            if (kList.size()<k){
                kList.add(score[i]);
                chk = 1;
            }

            // 리스트가 k 의 길이와 같아지고
            // kstScore 를 갈아줘야할때가 오면
            if (chk == 0 && kstScore < score[i]){
                // 제일 작은 값 삭제하고
                //System.out.println("삭제되는 값: "+ kList.get(0));
                kList.remove(0);
                kList.add(score[i]);
            }

            //sort
            Collections.sort(kList);
            // 제일 작은 값 kstScore 로 업데이트하기
            kstScore = kList.get(0);
            //System.out.println(kList);
            answer[i] = kstScore;
        }

        return answer;
    }
}