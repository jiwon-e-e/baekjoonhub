class Solution {
    public String solution(String s) {

        String[] splitedS = s.split(" ");
        int max = Integer.parseInt(splitedS[0]);
        int min = Integer.parseInt(splitedS[0]);

        for (int i=1;i<splitedS.length;i++){
            int nowNum = Integer.parseInt(splitedS[i]);

            if (nowNum>max) max = nowNum;
            if (nowNum<min) min = nowNum;
        }
        
        String answer = min +" "+max;
        return answer;
    }
}