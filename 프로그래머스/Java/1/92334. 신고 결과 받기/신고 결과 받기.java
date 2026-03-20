import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //Map<String, Set<String>> 으로 받아보는거 어떤지
        // 중복확인...

        Map<String, Set<String>> reportMap = new HashMap<>();
        int[] answer = new int[id_list.length];


        // 일단 id_list 를 key 값으로 다 넣기
        for (int i=0;i<id_list.length;i++){
            reportMap.put(id_list[i], new HashSet<>());
        }

        // report 를 돌면서 value 에다가 넣어주기 (중복 허용 x)\
        // 누구한테 신고당했는지 적어주기
        for (int i=0;i<report.length;i++){
            String[] splitedReport = report[i].split(" ");
            reportMap.get(splitedReport[1]).add(splitedReport[0]);
        }

//        for (int i=0;i< id_list.length;i++){
//            System.out.println(id_list[i] + " " + reportMap.get(id_list[i]));
//        }

        // 만약에 총 신고 횟수가 k 번을 넘겼다면
        // 해당 프렌즈를 신고한 사람들한테 결과 메일을 보냄
        // count 용 맵 새로 만들기
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : id_list) {
            countMap.put(s, 0);
        }

        for (int i=0;i<id_list.length;i++){
            if (reportMap.get(id_list[i]).size()>=k){
                for (String s : reportMap.get(id_list[i])){
                    countMap.put(s, countMap.get(s)+1);
                }
            }
        }

        for (int i=0;i< id_list.length;i++){
//            System.out.println(id_list[i] + " " + countMap.get(id_list[i]));
            answer[i] = countMap.get(id_list[i]);
        }

        return answer;
    }
}