package inflearn_java_intro.sec08_recursive_tree_graph.p08_find_calf;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] elements = new int[]{1, -1, 5};
        int n = 5;
        int m = 14;
        int max = 10000;

        System.out.println(bfs1(elements, n, m, max));
    }

    public static int bfs1(int[] elements, int n, int m, int max) {
        int[] check = new int[max];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        check[n-1] = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int x = queue.poll();
                if (x == m) return level;
                for (int j=0; j<elements.length; j++) {
                    int dx = x + elements[j];
                    if (dx>=1 && dx<=max && check[dx-1] == 0) {
                        queue.offer(dx);
                        check[dx-1] = 1;
                    }
                }

            }
            level++;
        }
        return -1;
    }
}