package inflearn_java_intro.sec04_two_pointers_sliding.p02_common_elements;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 9, 5, 2};
        int[] arr2 = {3, 2, 5, 7, 8};

        System.out.println(Arrays.toString(solution3(arr1, arr2)));
    }

    public static int[] solution3(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1=0, p2=0;
        while (p1<arr1.length && p2<arr2.length) {
            if (arr1[p1]<arr2[p2]) p1++;
            else if (arr1[p1]>arr2[p2]) p2++;
            else {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution2(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : arr1) {
            set1.add(i);
        }

        Set<Integer> answer = new TreeSet<>();
        for (int i : arr2) {
            if (set1.contains(i)) {
                answer.add(i);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution1(int[] arr1, int[] arr2) {
        Set<Integer> answer = new TreeSet<>();

        for (int j : arr1) {
            for (int k : arr2) {
                if (j == k) {
                   answer.add(j);
                }
            }
        }

       return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
