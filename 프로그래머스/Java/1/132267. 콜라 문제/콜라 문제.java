class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // n -> 내가 처음에 가지고 있는 빈 병 수 
        while (n>=a){
            int temp = n;
            //System.out.println("## n: "+n);
            n = (n/a) * b;

            //System.out.println("pluc: "+ n);
            answer+= n;
            n += (temp%a);
            //System.out.println("answer = " + answer);
            //.out.println("n%a = " + temp%a);
        }
        return answer;
    }
}