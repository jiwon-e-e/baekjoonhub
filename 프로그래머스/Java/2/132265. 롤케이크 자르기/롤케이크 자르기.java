import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int len = topping.length;
        
        int[] visit1 = new int[10001];
        int[] visit2 = new int[10001];
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        int answer = 0;
        
        if (len == 1) return 0;
        // 1 ||| 2, 1, 3, 1, 4, 1, 2 저기서 끊기 시작해서 하나씩 늘려가기 
        visit1[topping[0]] = 1;
        cnt1 = 1;
        
        for (int i=1;i<len;i++){
            visit2[topping[i]]++;
            if (visit2[topping[i]] == 1) cnt2++;
        }
        
        for (int i=1;i<len;i++){
            int targetTopping = topping[i];
            visit1[targetTopping] ++;
            if (visit1[targetTopping] == 1) cnt1++;
            
            visit2[targetTopping] --;
            if (visit2[targetTopping] == 0) cnt2--;
            
            // System.out.println("visit1: "+Arrays.toString(visit1));
            // System.out.println("visit2: "+Arrays.toString(visit2));
            
            if (cnt1 == cnt2) answer++;
        }
        
        return answer;
    }
}