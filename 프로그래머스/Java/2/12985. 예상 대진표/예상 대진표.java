class Solution
{
    // n -> 사람 수, 
    // a -> A 의 첫 번호, 
    // b -> B의 첫 번호
    public int solution(int n, int a, int b)
    {

        int round = 1;
        // a가 b-1 값이 되면 맞붙는다고 생각, 그 때 round 반환 
        // a 와 b 값은 반복문을 한 번 돌 때 마다 /2 가 됨 홀수면 /2+1
        
        // 일단 이상한점... 어차피 /2 씩 하는거면 반복문을 많아봤자 20번 도는데 이렇게 나오는게 말이 안 됨 
        // 시간초과는 해결......
        // 반례는 왜뜨지 
        
        for (int i=0;i<21;i++){
            System.out.println("a: "+a+" b: "+b);
            // a %2 == 0 일 때 b = a-1이 어야하고 
            // b%2 ==0 일 때 a = b-1 이어야함 
            if ((a%2 == 0 && b == a-1) || (b%2 ==0 && a == b-1)){
                return round;
            }
            
            a = (a+1)/2;
            b = (b+1)/2;
            round++;
            
        }
        

        return round;
    }
}