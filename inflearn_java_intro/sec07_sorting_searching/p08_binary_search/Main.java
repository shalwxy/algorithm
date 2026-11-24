package inflearn_java_intro.sec07_sorting_searching.p08_binary_search;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int key = 32;
        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};

        System.out.println(solution1(key, arr));
    }

    public static int solution1(int key, int[] arr) {
        int lt = 0;
        int rt = arr.length - 1;
        int mid = -1;

        Arrays.sort(arr);

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (key < arr[mid]) {
                rt = mid - 1;
            }  else if (key > arr[mid]) {
                lt = mid + 1;
            } else {
                break;
            }
        }

        return mid+1;
    }
}
