class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];

        int[] alphabet = new int[26];
        // 아니면 그냥 keymap 부터 돌면서 가장 먼저 나오는 알파벳 이 몇번째에 있는지 화깅ㄴ하는것도? 괜찮을듯
        for (int i=0;i< keymap.length;i++){
            for (int j=0;j<keymap[i].length();j++){
                int pointer = keymap[i].charAt(j)-'A';

                if (alphabet[pointer] == 0){
                    alphabet[pointer] = j+1;
                    continue;
                }

                // 더 작은 값으로 바꿔주기
                if(alphabet[pointer]>(j+1)){
                    alphabet[pointer] = j+1;
                }
            }
        }

        for (int i=0;i<targets.length;i++){

            for (int j=0;j<targets[i].length();j++){
                int targetPointer = targets[i].charAt(j)-'A';

                if (alphabet[targetPointer] == 0){
                    answer[i] = -1;
                    break;
                }
                else{
                    answer[i]+= alphabet[targetPointer];
                }

            }
        }

        return answer;
    }
}