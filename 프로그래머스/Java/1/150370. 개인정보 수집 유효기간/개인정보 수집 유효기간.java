import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] todayString = today.split("\\.");

        int todayByDay = Integer.parseInt(todayString[0]) * 12 * 28
                + Integer.parseInt(todayString[1]) * 28
                + Integer.parseInt(todayString[2]);

        char[] termsType = new char[terms.length];
        int[] termsPeriod = new int[terms.length];

        for (int i=0;i<terms.length;i++){
            String[] tempTerms = terms[i].split(" ");
            termsType[i] = tempTerms[0].charAt(0);
            termsPeriod[i] = Integer.parseInt(tempTerms[1]);
        }

        for (int i=0;i<privacies.length;i++){
            String[] splitedPrivacies = privacies[i].split(" ");
            char type = splitedPrivacies[1].charAt(0);

            String[] date = splitedPrivacies[0].split("\\.");
            int day = Integer.parseInt(date[0]) * 12 * 28
                    + Integer.parseInt(date[1]) * 28
                    + Integer.parseInt(date[2]);

            for (int j=0;j<terms.length;j++){
                if(type == termsType[j]){
                    day += termsPeriod[j] * 28;
                }
            }

            if (todayByDay >= day){
                answer.add(i+1);
            }

        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}