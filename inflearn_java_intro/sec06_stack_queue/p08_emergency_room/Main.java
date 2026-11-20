package inflearn_java_intro.sec06_stack_queue.p08_emergency_room;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int[] arr = new int[]{60, 50, 70, 80 , 90};
        System.out.println(solution2(k, arr));
    }

    public static int solution2(int k, int[] arr) {
        int answer = 0;

        Queue<Person> queue = new LinkedList<>();

        for (int i=0; i<arr.length; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person x : queue) {
                if (x.emergency > tmp.emergency) {
                    queue.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.idx == k) return answer;
            }
        }

        return answer;
    }

    public static int solution1(int k, int[] arr) {
        int answer = 0;

        Queue<Person> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.emergency, a.emergency)
        );

        for (int i=0; i<arr.length; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        while (true) {
            answer++;
            if (queue.peek().idx == k) {
                break;
            } else {
                queue.poll();
            }
        }

        return answer;
    }
}

class Person {
    int idx;
    int emergency;

    public Person(int idx, int emergency) {
        this.idx = idx;
        this.emergency = emergency;
    }
}
