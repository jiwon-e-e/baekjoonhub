import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        // PrioirtyQueue 사용하기 
        // 숫자가 높은것부터 우선순위를 가지니까 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 지금은 그냥 prioirties 에 들어있는 숫자 기준으로 비교하면 되니까 comparator를 구현해줄 필요 X
        // 아니면 pq 에 넣을때 Integer 말고 Integer (우선순위) + Integer (인덱스) 이렇게 넣어서
        // 우선순위로 출력하고 Index 로 location 비교 근데 그럼 객체를 만들어얃함
        
        for (int i=0;i<priorities.length;i++){
            pq.offer(priorities[i]);
        }
        
        int pointer= 0;
        
        while(!pq.isEmpty()){
            
            for (int i=pointer;i<pointer + priorities.length;i++){
                if (pq.peek() == priorities[i%priorities.length]){
                    int value = pq.poll();
                    answer ++;
                    priorities[i%priorities.length] = -1;
                    
                    if (i%priorities.length == location) return answer;
                }
            }
            
            
        }
        
        return answer;
    }
}