class Solution {
    public static final int FIVE = 5;
    public int solution(String word) {

        // AE << AAE 가 더 빠름 
        int answer = 0;
        char[] list = {'A', 'E', 'I', 'O', 'U'};
        int[] cnt = new int[FIVE];
        for (int i=0;i<FIVE;i++){
            for (int j=0;j<=i;j++){
                cnt[i] += (int) Math.pow(FIVE, j);
            }
            // System.out.println("* "+ cnt[i]);
        }
        
        for (int i=0;i<word.length();i++){
            for (int j=0;j<FIVE;j++){
                if (word.charAt(i) == list[j]){
                    answer += ( cnt[FIVE-i-1] * j) +1 ;
                }
            }
        }
        return answer;
    }
}