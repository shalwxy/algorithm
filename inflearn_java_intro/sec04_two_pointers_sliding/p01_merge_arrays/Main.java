package inflearn_java_intro.sec04_two_pointers_sliding.p01_merge_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 6, 7, 9};

        System.out.println(Arrays.toString(solution2(arr1, arr2)));
    }

    public static int[] solution2(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<arr1.length && p2<arr2.length) {
            if (arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1<arr1.length) answer.add(arr1[p1++]);
        while (p2<arr2.length) answer.add(arr2[p2++]);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution1(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length + arr2.length];

        for (int i=0,j=0,k=0; k<answer.length; k++) {
            if (i == -1) {
                answer[k] = arr2[j++];
            } else if (j == -1) {
                answer[k] = arr1[i++];
            } else {
                if (arr1[i]<=arr2[j]) {
                    answer[k] = arr1[i];
                    if (i == arr1.length-1) {
                        i = -1;
                    } else {
                        i++;
                    }
                } else if (arr1[i]>arr2[j]) {
                    answer[k] = arr2[j];
                    if (j == arr2.length-1) {
                        j = -1;
                    } else {
                        j++;
                    }
                }
            }
        }
        return answer;
    }
}
