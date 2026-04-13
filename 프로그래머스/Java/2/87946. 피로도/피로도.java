class Solution {
    int max =0;
    
    public int solution(int k, int[][] dungeons) {
        // 최소 필요 피로도가 높을수록 먼저 탐험해야하고 
        // 소모 피로도가 낮을수록 먼저 탐험하면 될 것 같다
        
        // 아니면 던전이 8개니까 그냥 전체 탐색 해봐도 됨 
        // 8 * 7 * 6 . . .* 2 * 1 완전탐색 하자 
        
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        
        return max;
    }
    
    private void dfs (int tempK, int[][] dungeons, boolean[] visited, int cnt) {
        if (cnt > max) max = cnt;
        for (int i=0;i<dungeons.length;i++){
            
            if (!visited[i] && dungeons[i][0] <= tempK) {
                visited[i] = true;
                
                dfs (tempK - dungeons[i][1] , dungeons, visited, cnt + 1);
                
                visited[i] = false;
            }
        }
        
    }
}