package inflearn_java_intro.sec05_hashmap_treeset.p03_sliding_category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = new int[]{20, 12, 20, 10, 23, 17, 10};
        System.out.println(Arrays.toString(solution2(k, arr)));
    }

    public static int[] solution2(int k, int[] arr) {
        int[] answer = new int[arr.length - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt=k-1; rt<arr.length; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer[lt] = map.size();
            map.put(arr[lt], map.get(arr[lt])-1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

    public static int[] solution1(int k, int[] arr) {
        int[] answer = new int[arr.length - k + 1];

        int lt = 0;
        for (int rt=k-1; rt<arr.length; rt++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j=lt; j<=rt; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            answer[lt++] = map.size();
        }

        return answer;
    }
}
