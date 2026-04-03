class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 2차원 행렬 곱 구하는 방법
        // answer[i][j] = arr1[i][0~j] + arr2[0~j][i] 맞나 
        // answer[0][1] = arr1[0][0]*arr2[0][1] 
        //                  + arr1[0][1]*arr2[1][1] 
        //                  + arr1[0][2]*arr2[2][1] 
        
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        // 반복문 돌면서 
        
        for (int i=0;i<answer.length;i++){
            for (int j=0;j<answer[0].length;j++){
                
                answer[i][j] = getValue(arr1,arr2,i,j);
            }
        }
        
        
        return answer;
    }
    
    private int getValue(int[][] arr1, int[][] arr2,int x,int y){
        int value =0;
        for (int i=0;i<arr1[0].length;i++){
            value+=arr1[x][i] * arr2[i][y];
        }
        return value;
    }
}