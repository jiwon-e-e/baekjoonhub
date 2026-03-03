class Solution {
    public int solution(int[] nums) {
        // 소수... 만 들어있는 list 를 만들고
        // 근데 너무 긴데....
        // 1이 포함되는 경우 -> 나머지 2개 구하기

        // 근데 이게
        // 1 5 11 -> 17
        // 2 4 11 -> 17 하면 경우의 수가 두개인지 ...

        // 정렬부터 하기
        //Arrays.sort(nums);
        int cnt = 0;

        //int[] numList = {5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139};

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++) {
                for (int k=j+1;k<nums.length;k++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime(sum)) cnt ++;
                }
            }
        }

        return cnt;
    }

    private boolean isPrime(int num){
        if (num<2) return false;

        for (int i=2;i*i<=num;i++){
            if (num%i == 0) return false;
        }
        return true;
    }
}