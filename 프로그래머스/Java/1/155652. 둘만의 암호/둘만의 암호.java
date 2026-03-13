class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<s.length();i++){

            char c = s.charAt(i);
            int stk = 0;
            for (int j=0;j<index+stk;j++){

                c++;

                if (c>'z'){
                    c='a';
                    
                }

                String checkSkip = String.valueOf(c);

                if (skip.contains(checkSkip)){
                    stk++;
                }
            }

            stringBuilder.append(c);
        }
        return String.valueOf(stringBuilder);
    }
}