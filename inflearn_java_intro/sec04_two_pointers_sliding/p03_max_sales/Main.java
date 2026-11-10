package inflearn_java_intro.sec04_two_pointers_sliding.p03_max_sales;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};

        System.out.println(solution2(k, arr));
    }

    public static int solution2(int k, int[] arr) {
        // solution1과 같이 하면 이미 더했던 것에 대해서도 계속 덧셈을 진행하는 비효율이 있음
        // 그래서 이미 구한 합산에서 +-할 요소를 연산하는 편이 더 효율적
        int max = 0;
        for (int i=0; i<k; i++) {
            max += arr[i];
        }

        // index 헷갈림 조심
        // 이미 구한 합산에서 가장 첫번째 index 원소를 차감하고, 가장 마지막에서 +1한 index 원소를 더해야 함
        int tmp = max;
        for (int i=0; i<arr.length-k; i++) {
            tmp = tmp - arr[i] + arr[i+k];
            if (tmp > max)  max = tmp;
        }

        return max;
    }

    public static int solution1(int k, int[] arr) {
        // k == arr.length 이면 max = sum(arr)
        // k == arr.length -1 이면 for문은 2번 돌아서 max를 구함
        // k == arr.length -2 이면 for문은 3번 돌아서 max를 구함
        // -> 일반화: for문은 arr.length - k + 1 번 돌게 됨
        int max = 0;
        for (int i=0; i<arr.length-k+1; i++) {
            int tmp = 0;
            for (int j=i; j<i+k; j++) {
                tmp += arr[j];
            }
            if (tmp>max) max = tmp;
        }
        return max;
    }
}
