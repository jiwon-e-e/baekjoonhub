class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        int[] stack = new int[ingredient.length];
        // 제일 윗부분을 가리키는 인덱스 
        int top = 0;

        for (int i = 0; i < ingredient.length; i++) {

            //stack의 제일 윗 칸에 ingredient[i] 넣기 
            stack[top++] = ingredient[i];

            // 4칸 이상 쌓였다면
            if (top >= 4){
                // 제일 위 네 칸이 1 2 3 1 인지 확인 
                if(stack[top-4] == 1 && stack[top-3] == 2 && stack[top-2] == 3 &&stack[top-1] == 1){
                    // 맞다면 ++
                    top -= 4;
                    answer++;
                }
            }
        }

        return answer;
    }
}