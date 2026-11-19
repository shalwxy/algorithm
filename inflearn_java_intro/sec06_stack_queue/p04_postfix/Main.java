package inflearn_java_intro.sec06_stack_queue.p04_postfix;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "352+*9-";

        System.out.println(solution1(s));
    }

    public static int solution1(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c-'0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt+rt);
                } else if (c == '-') {
                    stack.push(lt-rt);
                } else if (c == '*') {
                    stack.push(lt*rt);
                }  else if (c == '/') {
                    stack.push(lt/rt);
                }
            }
        }
        return stack.pop();
    }
}
