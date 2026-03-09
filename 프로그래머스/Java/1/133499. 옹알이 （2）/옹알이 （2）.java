class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] babyList = {"aya", "ye", "woo", "ma"};

        for (int i=0;i<babbling.length;i++){

            for (int j=0;j<babbling[i].length();j++){

                for (int k=0;k<4;k++){
                    if ((j+babyList[k].length())>babbling[i].length()) {
                        //indexOfBoundException 안 나오게 하기
                        continue;
                    }

                    if(babbling[i].substring(j,j+babyList[k].length()).equals(babyList[k])){

                        String before = babbling[i].substring(0, j);
                        String after = babbling[i].substring(j + babyList[k].length());
                        babbling[i] = before + k + after;

//                        j = j+babyList[k].length()-1;
                        break;
                    }
                }
            }
            System.out.println(babbling[i]);

            boolean chk = true;
            if (!babbling[i].matches("[0-3]+")){
                chk = false;
            }
            for (int n=0;n<babbling[i].length()-1;n++){
                if (babbling[i].charAt(n) == babbling[i].charAt(n+1)){
                    chk = false;
                }
            }
            if (chk) answer ++;

        }

        return answer;
    }
}