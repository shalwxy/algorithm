package inflearn_java_intro.sec05_hashmap_treeset.p01_class_president;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "BACBACCACCBDEDE";

        System.out.println(solution2(s));
    }

    public static String solution2(String s) {
        // 1. HashMap 생성: Key는 기호(Character), Value는 득표수(Integer)
        Map<Character, Integer> map = new HashMap<>();

        // 2. 투표 결과 누적
        for(char x : s.toCharArray()) {
            // getOrDefault: x라는 키가 있으면 그 값을 가져오고, 없으면 0을 가져옴
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 3. 최다 득표자 찾기
        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return String.valueOf(answer);
    }

    public static String solution1(String s) {
        // 1. 크기가 5인 배열 생성 (A=0번, B=1번, C=2번, D=3번, E=4번 인덱스)
        int[] cnt = new int[5];
        // 2. 투표 결과 누적
        for (char x : s.toCharArray()) {
            cnt[x-'A']++;
        }
        // 3. 최다 득표자 찾기
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (int i=0; i<cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                answer = (char)(i+'A'); // 인덱스를 다시 알파벳으로 변환
            }
        }
        return String.valueOf(answer);
    }
}
