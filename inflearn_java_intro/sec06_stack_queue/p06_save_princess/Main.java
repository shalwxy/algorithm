package inflearn_java_intro.sec06_stack_queue.p06_save_princess;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int k = 3;

        System.out.println(solution2(n, k));
    }

    public static int solution2(int n, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i=1; i<k; i++) queue.offer(queue.poll());
            queue.poll();
            if (queue.size() == 1) answer = queue.poll();
        }
        return answer;
    }

    public static int solution1(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }

        int idx = 0;
        while (queue.size() > 1) {
            idx++;
            if (idx == k) {
                queue.poll();
                idx = 0;
            } else {
                queue.offer(queue.poll());
            }
        }

        return queue.poll();
    }
}
