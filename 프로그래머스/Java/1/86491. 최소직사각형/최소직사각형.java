class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        changeSideByLength(sizes);
        int maxw = 0;
        int maxh = 0;
        
        for (int i=0;i<sizes.length;i++){
            if (maxw<sizes[i][0]){
                maxw=sizes[i][0];
            }
            if (maxh<sizes[i][1]){
                maxh=sizes[i][1];
            }
        }
        
        return maxw*maxh;
    }
    public void changeSideByLength(int[][] sizes){
        for (int i= 0;i<sizes.length;i++){
            if (sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
    }
}