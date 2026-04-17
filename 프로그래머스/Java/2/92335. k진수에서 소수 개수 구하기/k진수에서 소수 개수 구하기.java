import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 1. K 진수로 바꾸기 -> Integer.toString(n,k)??? 라는 게 있다고 하네요 ㄹㅈㄷ 
        // 2. split 을 0으로 해서
        // 3. 각각 소수인지 확인하기 ... 이게맞다 
        
        // 반례 정리: 1번에서 k 진수로 바꿨을 때 Long 값이 나오는 경우가 있음 -> IsPrime 을 Long 을 받도록 수정 
        // 
        int answer = 0;
        
        String newK = Integer.toString(n,k); // String 형식으로 반환됨 
        // System.out.println("** "+ newK);
        String[] splitedK = newK.split("0");
        
        for (String smallK : splitedK){
            if (!smallK.isEmpty()){
                // System.out.println("*" + Long.parseLong(smallK));
                if (isPrime(Long.parseLong(smallK))) answer++;
            }
        }
        
        return answer;
    }
    
    // 소수면 true 반환, 소수가 아니라면 false 반환 
    private boolean isPrime(Long n){
        if (n < 2L) return false;
        
        for (int i =2;i<=Math.sqrt(n);i++){
            if (n%i == 0) {
                return false;
            }
                
        }
        return true;
    }
}