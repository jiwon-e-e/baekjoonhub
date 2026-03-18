import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        // 만약에 그냥 이름 나올때까지 반복ㅁ누 돌면서 하면..
        // 1 000 000 * 999 999 ... 
        
        // 사실 다른사람들의 순서는 안 바뀌고 둘만 바뀌는거니까
        // 반복문 돌면서 이름 찾기 ... 그리고 찾으면 앞뒷사람만 바꿔주기 
        // 1 000 000 * 50 000
        
        // map 으로 이름, 순위 저장 
        // key 로 이름을 빨리 찾는다고 해도 그 앞 사람을 찾을 수 없음.... map 은 순서 보장 안 하니까 
        // -> map 이랑 list 같이쓰기 
        Map<String, Integer> playerMap = new HashMap<>(players.length);
        for (int i =0;i<players.length;i++){
            playerMap.put(players[i],i);
        }
        
        // linked list 
        
        // 완전탐색 1 000 000 * 50 000
        for (int i=0;i<callings.length;i++){
            int nowRank = playerMap.get(callings[i]);
            // 순서 바뀌는 사람 이름 
            String target = players[nowRank-1];
            
            
            // players[nowRank] 랑 nowRank-1 이랑 바꿔주기 
            String temp = players[nowRank];
            players[nowRank] = players[nowRank-1];
            players[nowRank-1] = temp;
            
            // map 에서도 바꿔주기 
            playerMap.replace(callings[i], nowRank -1);
            playerMap.replace(target, nowRank);
            
        }
        
        return players;
        
    }
}