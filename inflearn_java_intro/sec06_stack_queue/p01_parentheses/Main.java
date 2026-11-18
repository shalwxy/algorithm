package inflearn_java_intro.sec06_stack_queue.p01_parentheses;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "(()(()))(()";

        System.out.println(solution1(s));
    }

    public static String solution1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
