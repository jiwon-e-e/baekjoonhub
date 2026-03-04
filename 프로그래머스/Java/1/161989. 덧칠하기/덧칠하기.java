class Solution {
    public int solution(int n, int m, int[] section) {

        // 1번 접근: 배열 0번째 idx 부터 n 번째 idx까지 확인하면서 m 만큼 다 칠하기

        int idx = 0, cnt = 0;
        for (int i= 0;i<n;i++) {
//            System.out.println(i);


            if (section[idx] == i+1) {
                cnt++;
                //배열을 도는데 칠해야할 부분을 만나면
                // System.out.println("i: "+i+" |m: "+m);
                i = i + m - 1; // idx도 옮기고 cnt도 올리기
//                System.out.println(2);
//                System.out.println("# idx: " + idx + " |section[idx]: " + section[idx] + " |i: " + i);




                while (section[idx] <= i+1) {
                    idx++;
                    if (idx >= section.length) return cnt;
                }
            }


        }
        return cnt;
    }
}