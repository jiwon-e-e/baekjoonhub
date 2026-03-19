class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int[][] parkMap = new int[park.length][park[0].length()];

        int w = 0;
        int h = 0;
        for (int i=0;i<park.length;i++){
            for (int j=0;j<park[0].length();j++){
                if (park[i].charAt(j) == 'S'){
                    w = j;
                    h = i;
                    parkMap[i][j] = 0;
                }
                else if (park[i].charAt(j) == 'O'){
                    parkMap[i][j] = 0;
                }else{
                    parkMap[i][j] = 1;
                }

            }
        }

//        System.out.println(Arrays.deepToString(parkMap));

        int[] dw = {1, -1, 0, 0};
        int[] dh = {0, 0 ,1, -1}; // 순서대로 E W S N
        char[] dirc = {'E', 'W', 'S', 'N'};

        for (int i=0;i<routes.length;i++){
            String[] splitRoute = routes[i].split(" ");
            int move = Integer.parseInt(splitRoute[1]);

            for (int j=0;j<4;j++) {
                if (splitRoute[0].charAt(0) == dirc[j]){
                    // 어디로 갈 지 결정했다면 (0, 1, 2, 3) dw[] dh[]*splitRoute[1]
//                    System.out.println("\n방향: "+dirc[j]+" | 이동할 칸 수: "+move);
//                    System.out.println("(h, w) = ("+h+", "+w+")");

                    int newW = w;
                    int newH = h;
                    boolean breakChk = true;
                    for (int k=0;k<move;k++){

                        newW += dw[j];
                        newH += dh[j];


                        if ((newW < parkMap[0].length && newW>=0 && newH <parkMap.length && newH >=0) && parkMap[newH][newW] == 0){
//                            System.out.println("moved!");
                        } else {
                            breakChk = false;
                            break;
                        }


                    }
                    if (breakChk){
                        w = newW;
                        h = newH;
//                        System.out.println("(newH, newW) = ("+newH+", "+newW+")");
                    }


                }
            }

        }

        answer = new int[]{h,w};
        return answer;
    }
}