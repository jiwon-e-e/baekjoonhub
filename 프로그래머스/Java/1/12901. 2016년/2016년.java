class Solution {
    public String solution(int a, int b) {
        int start = 0;
        int[] monthDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        for (int i=0;i<(a-1);i++){
            System.out.println("+ " +monthDay[i]);
            start+=monthDay[i];
        }
        start+=b;

        String ans = day[ (start+4)%7 ];

        return ans;
    }
}