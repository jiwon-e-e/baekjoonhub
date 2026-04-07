import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 경우의 수 구하는 문제

        Map<String, Integer> cloth_set = new HashMap<>();
        for (int i=0;i<clothes.length;i++){
            // 이미 값이 있다면 걔 가져오고 아니면 0
            int value = 0;
            if (cloth_set.containsKey(clothes[i][1])){
                value = cloth_set.get(clothes[i][1]);
            }
            cloth_set.put(clothes[i][1], value + 1);
            // System.out.println(cloth_set);
        }


        // 아무것도 안 입는 경우 1개를 빼주면 되는군아
        int answer = 1;
        for (String s : cloth_set.keySet()){
            answer *= (cloth_set.get(s) + 1);
        }

        return answer - 1;
    }
}