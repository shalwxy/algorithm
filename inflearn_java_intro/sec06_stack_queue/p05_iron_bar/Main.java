package inflearn_java_intro.sec06_stack_queue.p05_iron_bar;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()(((()())(())()))(())";

        System.out.println(solution2(s));
    }

    public static int solution2(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if (s.charAt(i-1) == '(') answer += stack.size();
                else answer++;
            }
        }

        return answer;
    }

    public static int solution1(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char tmp = ' ';
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (tmp == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
            tmp = c;
        }
        return answer;
    }
}
