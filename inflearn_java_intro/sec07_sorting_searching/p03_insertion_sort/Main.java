package inflearn_java_intro.sec07_sorting_searching.p03_insertion_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {13, 5, 11, 7, 23, 15};

        System.out.println(Arrays.toString(solution1(arr)));
    }

    public static int[] solution1(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int j;
            int tmp = arr[i];
            for (j=i; j>0&&arr[j-1]>tmp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
