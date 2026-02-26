class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        //pointer 사용해서 두개 다 확인하기 
        
        
        int p1 = 0;
        int p2 = 0;
        
        for (int i= 0;i<goal.length;i++){
            if (p1<cards1.length && goal[i].equals(cards1[p1])) {
                p1++;
            }
            else if (p2<cards2.length && goal[i].equals(cards2[p2])){
                p2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}