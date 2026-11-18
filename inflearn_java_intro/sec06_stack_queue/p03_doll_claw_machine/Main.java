package inflearn_java_intro.sec06_stack_queue.p03_doll_claw_machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[][] machine = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] play = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution2(machine, play));
    }

    public static int solution2(int[][] machine, int[] play) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int p : play) {
            for (int i=0; i<machine.length; i++) {
                if (machine[i][p-1] != 0) {
                    int tmp = machine[i][p-1];
                    machine[i][p-1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static int solution1(int[][] machine, int[] play) {
        int answer = 0;

        Stack<Integer>[] stacks = new Stack[machine[0].length];
        for (int i=0; i<stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int j=0; j<machine[0].length; j++) {
            for (int i=machine.length-1; i>=0; i--) {
                if (machine[i][j] == 0) continue;
                stacks[j].push(machine[i][j]);
            }
        }

        Stack<Integer> stack = new Stack();

        for (int i=0; i<play.length; i++) {
            if (stacks[play[i]-1].isEmpty()) continue;
            if (stack.isEmpty()) {
                stack.push(stacks[play[i]-1].pop());
            } else {
                int top = stack.peek();
                if (stacks[play[i]-1].peek() == top) {
                    stack.pop();
                    stacks[play[i]-1].pop();
                    answer += 2;
                } else {
                    stack.push(stacks[play[i]-1].pop());
                }
            }
        }

        return answer;
    }
}
