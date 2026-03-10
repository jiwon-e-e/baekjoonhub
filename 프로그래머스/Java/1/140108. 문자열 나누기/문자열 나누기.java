class Solution {
    public int solution(String s) {
        int ans = 0;

        int rootCharCnt = 1;
        int otherCharCnt = 0;
        char rootChar = s.charAt(0);

        for (int i=1;i<s.length();i++){
            if (rootCharCnt == 0) rootChar = s.charAt(i);

//            System.out.println("* i: "+i);

            if (s.charAt(i) == rootChar) rootCharCnt++;
            else otherCharCnt++;

            if ((rootCharCnt == otherCharCnt) && rootCharCnt!=0){
//                System.out.println("rootChar: "+ rootChar);
//                System.out.println("rootCharCnt: "+ rootCharCnt);

                ans++;
                rootCharCnt = 0;
                otherCharCnt = 0;
            }
        }

        // 마지막에 제대로 문자열이 안 만들어질 때
        if (rootCharCnt != 0) ans++;

        return ans;
    }
}