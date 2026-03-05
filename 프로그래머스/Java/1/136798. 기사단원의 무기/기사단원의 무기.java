class Solution {
    public int solution(int number, int limit, int power) {
        int ans = 0;
        for (int i=0;i<number;i++){
            int fe = calDivisor(i+1);
            //System.out.println("Fe: "+fe);
            if (fe > limit) fe = power;
            ans+=fe;
        }
        return ans;
    }
    
    
    private int calDivisor(int n){
        // 약수 구하는 방법...
        // 1. for 문을 1부터 n 까지 돌면서 나눴을 때 %i == 0 이면 약수개수 ++;
        int cnt = 0;
        
        for (int i= 1; i*i<=n; i++){
            if (i*i == n){
                cnt ++;
            }else if (n%i == 0){
                cnt = cnt + 2;
            }
        }
        
        // 약수 구하는데서 시간초과 발생
        // 약수 구하는 방법 
        
        return cnt;
    }
}