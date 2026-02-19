class Solution{
    public int solution(String s) {
        String newIntString = "";
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        for(int i=0;i<s.length();i++){
            char tempChar = s.charAt(i);

            if (Character.isDigit(tempChar)){
                //System.out.println("# "+tempChar);
                newIntString += tempChar;
                //System.out.println("## " +newIntString);
                continue;
            }

            for (int j=0;j< alphabet.length;j++){
                if (alphabet[j].charAt(0) == tempChar){
                    if (alphabet[j].charAt(1) == s.charAt(i + 1)) {
                        if (alphabet[j].charAt(2) == s.charAt(i+2)){
                            i = i + alphabet[j].length() - 1;
                            newIntString += j;
                            break;
                        }
                    }
                }
            }
        }

        return Integer.parseInt(newIntString);
    }
}