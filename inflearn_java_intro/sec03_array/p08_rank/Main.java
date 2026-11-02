package inflearn_java_intro.sec03_array.p08_rank;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{87, 89, 92, 100, 76})));
    }

    public static int[] solution(int n, int[] arr) {
        int[] rank = new int[n];

        for (int i=0; i<rank.length; i++) {
            int cnt = 1;
            for (int j=0; j<arr.length; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            rank[i] = cnt;
        }
        return rank;
    }
}
