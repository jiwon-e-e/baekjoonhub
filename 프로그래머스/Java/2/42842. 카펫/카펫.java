class Solution {
    public int[] solution(int brown, int yellow) {
        // 세로의 길이를 x, 가로의 길이를 y 라고 설정했을 때
        // 갈색 격자의 개수는 2x + 2y - 4 = brown
        // 노란색 격자의 개수는 (x-2) * (y-2) =yellow
        
        // -> 약수찾기 
        int xPlusY = (brown + 4)/2;

        for (int i=1;i<5000;i++){
            int x = i;
            int y = xPlusY - x;
            
            if(isYellowAlso(x,y,yellow)){
                
                int[] answer = {Math.max(x,y), Math.min(x,y)};
                return answer;
            }
        }        
        
        return null;
    }
    
    boolean isYellowAlso(int x, int y, int yellow){
        if ((x-2) * (y-2) == yellow){
            return true;
        }
        return false;
    }
}