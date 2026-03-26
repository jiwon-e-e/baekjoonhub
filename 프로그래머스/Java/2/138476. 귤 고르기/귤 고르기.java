import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        // map 만들고 
        // value 값 나올때마다 더하고
        // map 다 돌면서 ... k개 뽑기 
        // 아니면 k 개 될 때까지 max 구하고 ... k 에서 빼고......
        
        Map<Integer, Integer> map= new HashMap<>();
        int answer = 0;
        
        for (int i=0;i<tangerine.length;i++){
            if(map.containsKey(tangerine[i])){
                int now = map.get(tangerine[i]);
                map.replace(tangerine[i], now+1);
            }
            else{
                map.put(tangerine[i],1);
            }
        }
        int[] mapValues= map.values().stream()
            .mapToInt(Integer::intValue)
            .toArray();
        Arrays.sort(mapValues);
        // System.out.println(Arrays.toString(mapValues));
        
        int pointer = mapValues.length-1;
        
        while(k>0){
            int max = mapValues[pointer];
            
            k -= max;
            pointer--;
            answer++;
        }
        return answer;
    }
}