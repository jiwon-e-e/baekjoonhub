class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean blank = true;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                blank = true;
                sb.append(s.charAt(i));
                continue;
            }

            if (blank){
                sb.append(Character.toUpperCase(s.charAt(i)));
                blank = false;
            }else{
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        System.out.println(sb);
        return sb.toString();
    }
}