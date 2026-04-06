import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[ (int) (right - left) + 1];

        for (long i = left; i<= right; i++){
            int x = (int) (i / n) + 1;
            int y = (int) (i % n) + 1;

            if (x>=y) answer[(int) (i - left)] = x;
            else answer[(int) (i - left)] = y;
        }

        return answer;
    }
}