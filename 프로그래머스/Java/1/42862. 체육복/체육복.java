import java.util.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i=0;i<lost.length;i++){
            for (int j=0;j<reserve.length;j++){
                // 도난당했는데 사실은 여벌옷이 있었을때
                if (reserve[j]== lost[i]){
                    reserve[j] = 0;
                    lost[i] = 0;
                    break;
                }
            }
        }

        for (int i =0;i<lost.length;i++){
            for (int j =0;j<reserve.length;j++){
                if (reserve[j] < lost[i]-1 || reserve[j] == 0 ) continue;

                if (reserve[j] == lost[i]-1){ // 만약 앞사람이 빌려줄 수 있다면
                    reserve[j] = 0; //그 앞사람이랑
                    lost[i] = 0 ; // 안 가져온 사람 둘 다 0으로 바꿔주기
                    break;
                }

                if (reserve[j] == lost[i]+1){
                    reserve[j] = 0; //그 뒷사람
                    lost[i] = 0 ; // 안 가져온 사람 둘 다 0으로 바꿔주기
                    break;
                }

                if (reserve[j] > lost[i]+1){
                    break;
                }
            }
        }

        // 수업 못 듣는 사람 cnt
        int cantAttendToClass = 0;
        for (int i=0;i<lost.length;i++){
            if (lost[i] != 0){
                cantAttendToClass++;
            }
        }

        return n - cantAttendToClass;
    }
}