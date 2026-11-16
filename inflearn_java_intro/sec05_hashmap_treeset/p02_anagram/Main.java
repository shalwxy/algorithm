package inflearn_java_intro.sec05_hashmap_treeset.p02_anagram;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "AbaAeCe";
        String s2 = "baeeACA";

        System.out.println(solution1(s1, s2));
    }

    public static String solution3(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }
        return "YES";
    }

    public static String solution2(String s1,  String s2) {
        // 1. HashMap 생성: Key는 기호(Character), Value는 개수(Integer)
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // 2. 개수 누적
        for(char x : s1.toCharArray()) {
            // getOrDefault: x라는 키가 있으면 그 값을 가져오고, 없으면 0을 가져옴
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        for(char x : s2.toCharArray()) {
            // getOrDefault: x라는 키가 있으면 그 값을 가져오고, 없으면 0을 가져옴
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        // 3. 동일 여부 비교
        if (map1.equals(map2)) {
            return "YES";
        }
        return "NO";
    }

    public static String solution1(String s1, String s2) {
        // 1. 크기가 58인 배열 생성 (A~Z, a~z)
        int[] cnt1 = new int['z'-'A'+1];
        int[] cnt2 = new int[cnt1.length];
        // 2. 개수 누적
        for (char x : s1.toCharArray()) {
            cnt1[x-'A']++;
        }
        for  (char x : s2.toCharArray()) {
            cnt2[x-'A']++;
        }
        // 3. 동일 여부 비교
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] != cnt2[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
