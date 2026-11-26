package inflearn_java_intro.sec08_recursive_tree_graph.p07_breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        bfs1(root);
    }

    public static void bfs2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.printf("%d : ", level);
            for (int i=0; i<size; i++) {
                Node cur = queue.poll();
                System.out.printf("%d ", cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if  (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
            System.out.println();
        }
    }

    public static void bfs1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.printf("%d ", cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if  (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
    }
}