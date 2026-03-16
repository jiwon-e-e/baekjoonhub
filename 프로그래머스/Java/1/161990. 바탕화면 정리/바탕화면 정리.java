class Solution {
    public int[] solution(String[] wallpaper) {
        int[][] idx = new int[wallpaper.length][wallpaper[0].length()];
        for (int i=0;i<wallpaper.length;i++){
            for (int j=0;j<wallpaper[0].length();j++){
                if (wallpaper[i].charAt(j) == '.'){
                    idx[i][j] = 0;
                }else{
                    idx[i][j] = 1;
                }
            }
        }

        int left = 100, right = -1, top = -1, bottom = 100;

        for (int i=0;i<wallpaper.length;i++){
            for (int j=0;j<wallpaper[0].length();j++){
                if (idx[i][j] == 1){
//                    System.out.println("chk: "+i+" "+j);
                    if (i > top){
                        top = i;
                    }
                    if (i < bottom){
                        bottom = i;
                    }

                    if (j > right){
                        right = j;
                    }

                    if (j <left){
                        left = j;
                    }
                }
//                System.out.print(" "+idx[i][j]);
            }
//            System.out.println();
        }
//
//        System.out.println("bottom left: "+bottom+" "+left);
//        System.out.println("top right: "+(top+1)+" "+(right+1));

        int[] answer = {bottom, left, (top+1), (right+1)};
        return answer;
    }
}