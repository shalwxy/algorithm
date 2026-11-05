package inflearn_java_intro.sec04_two_pointers_sliding.p01_merge_arrays;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 6, 7, 9};

        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length + arr2.length];
        int idx = 0;
        return new int[][]{};
    }
}
