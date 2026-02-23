class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] alphabet = new int[30];

        for (int i=0;i<s.length();i++){
            int pos = s.charAt(i)-'a';

            if(alphabet[pos] == 0){
                answer[i] = -1;
            }else{
                answer[i] = i - alphabet[pos] + 1;
            }

//            System.out.print("   # pos : "+pos+"    ");
//            System.out.println(alphabet[pos]);

            alphabet[pos]=i+1;
        }

        return answer;
    }
}