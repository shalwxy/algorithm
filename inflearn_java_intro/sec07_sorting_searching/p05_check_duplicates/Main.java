package inflearn_java_intro.sec07_sorting_searching.p05_check_duplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] arr = {20, 25, 52, 30, 39, 33, 43, 33};

        System.out.println(solution2(arr));
    }

    public static String solution2(int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                return "D";
            }
        }
        return answer;
    }

    public static String solution1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size() == arr.length ? "U" : "D";
    }
}
