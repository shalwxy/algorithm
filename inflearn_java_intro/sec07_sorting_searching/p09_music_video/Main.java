package inflearn_java_intro.sec07_sorting_searching.p09_music_video;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int m = 3;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(solution1(m, arr));
    }

    public static int solution1(int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum+x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}
