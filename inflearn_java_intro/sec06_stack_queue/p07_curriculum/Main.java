package inflearn_java_intro.sec06_stack_queue.p07_curriculum;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String s1 = "CBA";
        String s2 = "CBDAGE";

        System.out.println(solution1(s1, s2));
    }

    public static String solution2(String s1, String s2) {
        String answer = "YES";

        Queue<Character> queue = new LinkedList<>();
        for (char x : s1.toCharArray()) {
            queue.offer(x);
        }
        for (char x : s2.toCharArray()) {
            if (queue.contains(x)) {
                if (x!=queue.poll()) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) return "NO";
        return answer;
    }

    public static String solution1(String s1, String s2) {
        String s2Refine = s2.replaceAll(String.format("[^%s]", s1), "");

        return s1.equals(s2Refine) ? "YES" : "NO";
    }
}
