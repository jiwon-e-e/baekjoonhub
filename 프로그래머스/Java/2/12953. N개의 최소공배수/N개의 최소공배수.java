class Solution {
    public int solution(int[] arr) {
        // 최대공약수로 나누기 그리구 곱하기 
        
        int gcd = arr[0];
        for (int i=1;i<arr.length;i++){
            gcd = getLCM(gcd, arr[i]);
        }

        return gcd;

    }
    private int getLCM(int a, int b){
        return a*b / getGCD(a,b);
    }
    private int getGCD(int a, int b){
        while(b!=0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}