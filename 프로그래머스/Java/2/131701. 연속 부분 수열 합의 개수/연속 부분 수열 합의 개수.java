import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // length 를 1부터 elements.length 까지 돌면서
        // 더하기
        // 중복불가니까 list에 1로 저장해서 마지막에 반복문 돌기
        // O(n^2) 뜰 거 같아요

        // linked list 로 바꿔서 마지막 요소의 tail 을 제일 앞의 head 로 옮기고
        // pointer 옮기기
        // pointer 가 시작점이랑 같아지면 continue?

        Set<Integer> set = new HashSet<>();
        // 중복불가 set 정하고


        for (int i=0;i<elements.length;i++){
            // i
            // i~i+1 if (i>elementLength) i+1%element length?
            // 근데 이렇게하면 element[n-1] element[0] element[1] 이걸 못 잡음
            int head = 0;
            int tail = i+1;
            int value = 0;
            for (int j=0;j<=i;j++){
                value += elements[j];
            } // 일단 value 값에 하나 저장하고

//            System.out.println("i: "+i+" | startValue: "+value);
            for (int j=0;j< elements.length;j++){
                // 매번 다 더하는건 아닌 거 같고
                // value 를 정해뒀다가 앞에꺼 빼고 뒤에꺼 더하고 하면 되지않을까
//                System.out.println("   head: "+head+" | tail: "+tail);
                int addValue = (value - elements[head%elements.length]) + elements[tail%elements.length];

//                System.out.println("    * elements[head%elements.length]: "+elements[head%elements.length]);
//                System.out.println("    * elements[tail%elements.length]: "+elements[tail%elements.length]);
//                System.out.println("    * addValue: "+addValue);

                head++;
                tail++;
                set.add(addValue);
                value = addValue;
            }
        }
        return set.size();
    }
}