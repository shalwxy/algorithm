package inflearn_java_intro.sec07_sorting_searching.p10_stall;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int cnt = 3;
        int[] arr = {1, 2, 8, 4, 9};

        System.out.println(solution1(cnt, arr));
    }

    public static int solution1(int cnt, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[arr.length-1] - arr[0];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count2(arr, mid) >= cnt) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static int count2(int[] arr, int distance) {
        int cnt = 1;
        int ep = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - ep >= distance) {
                ep = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static int count1(int[] arr, int distance) {
        int cnt = 1;
        for (int i=arr.length-1; i>=1; i--) {
            for (int j=i-1; j>=0; j--) {
                if (arr[i]-arr[j] >= distance) {
                    i = j+1;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
