package inflearn_java_intro.sec05_hashmap_treeset.p05_kth_largest_num;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{13, 15, 34, 23, 45, 65, 33, 11, 26, 42};

        System.out.println(solution1(k, arr));
    }

    public static int solution1(int k, int[] arr) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int l = j + 1; l < arr.length; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        if (set.size() < k) return -1;

        Integer[] arrSorted = set.toArray(new Integer[0]);
        return arrSorted[arrSorted.length - k];
    }
}
