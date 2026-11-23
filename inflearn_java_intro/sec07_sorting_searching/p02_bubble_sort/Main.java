package inflearn_java_intro.sec07_sorting_searching.p02_bubble_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {13, 5, 11, 7, 23, 15};

        System.out.println(Arrays.toString(solution1(arr)));
    }

    public static int[] solution1(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j-1, j);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
