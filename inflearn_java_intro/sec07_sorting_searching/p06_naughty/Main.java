package inflearn_java_intro.sec07_sorting_searching.p06_naughty;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {120, 125, 152, 130, 135, 135, 143, 127, 160};

        System.out.println(Arrays.toString(solution2(arr)));
    }

    public static int[] solution2(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != tmp[i]) answer.add(i + 1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution1(int[] arr) {
        int[] answer = new int[2];
        int idx = 0;
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                answer[idx] = i+idx+1;
                idx++;
            }
        }
        return answer;
    }
}
