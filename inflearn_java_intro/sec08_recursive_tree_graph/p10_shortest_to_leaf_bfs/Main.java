package inflearn_java_intro.sec08_recursive_tree_graph.p10_shortest_to_leaf_bfs;

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

        System.out.println(bfs1(root));
    }

    public static int bfs1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return level;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return -1;
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