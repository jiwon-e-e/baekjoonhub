class Solution {
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return cnt;
    }
    
    private void dfs(int[] numbers, int index, int current, int target) {
        // 마지막 인덱스까지 다 골랐을 때
        if (index == numbers.length) {
            if (current == target) cnt++;
            return;
        }
        
        // 현재 숫자를 더하는 경우
        dfs(numbers, index + 1, current + numbers[index], target);
        
        // 현재 숫자를 빼는 경우
        dfs(numbers, index + 1, current - numbers[index], target);
    }
}