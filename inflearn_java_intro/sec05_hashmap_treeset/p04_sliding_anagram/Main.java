package inflearn_java_intro.sec05_hashmap_treeset.p04_sliding_anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "bacaAacba";
        String s2 = "abc";

        System.out.println(solution1(s1, s2));
    }

    public static int solution1(String s1, String s2) {
        if (s1.length() < s2.length()) return 0;
        if (s1.length() == 0 || s2.length() == 0) return 0;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char x : s2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        for (int i=0; i<s2.length()-1; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int ans = 0;
        int lt = 0;
        for (int rt=s2.length()-1; rt<s1.length(); rt++) {
            map1.put(s1.charAt(rt), map1.getOrDefault(s1.charAt(rt), 0) + 1);
            if (map1.equals(map2)) ans++;
            map1.put(s1.charAt(lt), map1.get(s1.charAt(lt)) - 1);
            if (map1.get(s1.charAt(lt)) == 0) map1.remove(s1.charAt(lt));
            lt++;
        }

        return ans;
    }
}
