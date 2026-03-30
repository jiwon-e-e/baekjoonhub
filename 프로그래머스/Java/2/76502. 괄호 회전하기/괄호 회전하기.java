
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i=0;i<s.length();i++){
            String newString = s.substring(i) + s.substring(0,i);
            if (stack(newString)) answer++;
        }
        // stack 으로 넣는다고 치면 
        // 일단 주어지는 문자열만 확인해보기 
        return answer;
    }
    
    private boolean stack(String s){
        int cnt = 0;
        int top = -1;
        int pointer = 0;
        char[] stringStack = new char[s.length()];
        
        // 문자열 전체를 돌면서 
        while(pointer<s.length()){
            if (top<0 || s.charAt(pointer) == '(' || s.charAt(pointer) == '{' || s.charAt(pointer) == '['){
                stringStack[++top] = s.charAt(pointer++);
                continue;
            }
            // 현재 가리키고 있는거랑 
            // 지금 넣을거랑 비교 
            if ( (stringStack[top] == '(' && s.charAt(pointer) == ')') ||
               (stringStack[top] == '{' && s.charAt(pointer) == '}') ||
               (stringStack[top] == '[' && s.charAt(pointer) == ']')){
                top--;
                cnt++;
                pointer++;
                continue;
            }else{
                return false;
            }
        }
        if (top == -1) return true;
        return false;
    }
}