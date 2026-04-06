import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantCount = new HashMap<>();
        for (int i=0;i<want.length;i++){
            wantCount.put(want[i], number[i]);
        } // 원하는 개수만큼 적어두기



        // 일단 초기 10개
        // 흠
        for(int i=0;i<10;i++){
            if (!wantCount.containsKey(discount[i])) continue;
            wantCount.put(discount[i], wantCount.get(discount[i]) -1);

        }

        if (isValid(wantCount)){
            answer ++;
        }

//        System.out.print(wantCount.values());
        int tail = 0;

        for (int i=10;i<discount.length;i++){

            if (wantCount.containsKey(discount[tail])){
                wantCount.put(discount[tail], wantCount.get(discount[tail]) + 1 );
            }
            tail++; // if 문 안에 넣으면 tail 이 안 움직임 

            if (wantCount.containsKey(discount[i])){
                wantCount.put(discount[i], wantCount.get(discount[i]) - 1 );
            }

            if (isValid(wantCount)){
//                System.out.println("i : "+ i);
                answer ++;
            }
        }

        return answer;
    }

    private boolean isValid(Map<String, Integer> map){
        for (int value: map.values()){
            if (value > 0) return false;
        }
        return true;
    }
}