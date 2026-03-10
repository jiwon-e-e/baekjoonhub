class Solution {
    public String solution(String X, String Y) {
        int[] x = new int[10];
        int[] y = new int[10];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<X.length();i++){
            x[X.charAt(i) - '0']++;
        }
        for (int i = 0; i<Y.length();i++){
            y[Y.charAt(i)-'0']++;
        }

        for (int i=9;i>=0;i--){

            int eachCount = Math.min(x[i], y[i]);

            for(int j=0;j<eachCount;j++){
                sb.append(i);
            }
        }
        
        String answer= sb.toString();

        //1이랑 0을 어케 구분하징
        if (answer.isBlank()) return "-1";

        for (int i=0;i<answer.length();i++){
            if (answer.charAt(i)!='0'){
                return answer;
            }
        }

        return "0";
    }
}