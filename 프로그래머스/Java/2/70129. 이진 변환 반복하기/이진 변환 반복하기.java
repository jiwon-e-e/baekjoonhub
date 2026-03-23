import java.util.*;
public class a81301 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "1111111";
        System.out.println(Arrays.toString(sol.solution(s)));
    }
}


class Solution {
    int removedZero = 0;
    int changeCnt = 0;

    public int[] solution(String s) {
        // StringBuilder sb = new StringBuilder(s);
        while(!s.equals("1")){
            s = removeOne(s);
            s = toBinary(s);
        }

        int[] answer = {changeCnt,removedZero};
        return answer;
    }

    private String toBinary(String s){
        // 1 여러개가 들어오면 길이를 이진으로 변환해서 반환
        changeCnt++;
        return Integer.toBinaryString(s.length());
    }

    private String removeOne(String s){
        // 이진숫자에서 0을 제거해서 반환
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                removedZero++;
            }else{
                sb.append("1");
            }
        }
        return sb.toString();
    }
}