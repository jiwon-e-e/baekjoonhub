import java.util.*;
class Solution {
    Queue<Integer> q = new LinkedList<>();
    int[] visited;
    
    public int solution(int x, int y, int n) {
        
        visited = new int[y+1];
        
        q.offer(x);
        visited[x] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            if (now == y) return visited[now];
            
            int next1 = now + n;
            int next2 = now * 2;
            int next3 = now * 3;
            
            func(now, next1, y);
            func(now, next2, y);
            func(now, next3, y);
        }
        return -1;
    }
    
    public void func (int now, int next, int y){
        if (next <= y && visited[next] == 0){
            visited[next] = visited[now] + 1;
            q.offer(next);
        }
        
    }
}