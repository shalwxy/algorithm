package inflearn_java_intro.sec07_sorting_searching.p04_least_recently_used;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        int[] arr = {1, 2, 3, 2, 6, 2, 3, 5, 7};

        System.out.println(Arrays.toString(solution1(size, arr)));
    }

    public static int[] solution1(int size, int[] arr) {
        int[] answer =  new int[size];

        for (int x : arr) {
            int pos = -1;
            for (int i=0; i<size; i++) {
                if (x == answer[i]) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i=size-1; i>=1; i--) {
                    answer[i] = answer[i-1];
                }
            } else {
                for (int i=pos; i>=1; i--) {
                    answer[i] = answer[i-1];
                }
            }
            answer[0] = x;
        }

        return answer;
    }
}
