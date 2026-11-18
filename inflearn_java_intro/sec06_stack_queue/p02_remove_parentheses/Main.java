package inflearn_java_intro.sec06_stack_queue.p02_remove_parentheses;

import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String s = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";

        System.out.println(solution1(s));
    }

    public static String solution1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x != ')') {
                stack.push(x);
            } else {
                while (true) {
                    if (stack.pop() == '(') break;
                }
            }
        }
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
