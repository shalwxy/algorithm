package inflearn_java_intro.sec07_sorting_searching.p01_selection_sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] arr = {13, 5, 11, 7, 23, 15};

        System.out.println(Arrays.toString(solution1(arr)));
    }

    public static int[] solution1(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int idx = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
