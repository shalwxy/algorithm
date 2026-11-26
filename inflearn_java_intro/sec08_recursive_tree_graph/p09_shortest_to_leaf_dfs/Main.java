package inflearn_java_intro.sec08_recursive_tree_graph.p09_shortest_to_leaf_dfs;

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

        System.out.println(dfs1(root, 0));
    }

    public static int dfs1(Node root, int level) {
        if (root.left == null && root.right == null) {
            return level;
        }
        if (root.left == null) {
            return dfs1(root.right, level+1);
        }
        if (root.right == null) {
            return dfs1(root.left, level+1);
        }
        return Math.min(dfs1(root.left, level+1), dfs1(root.right, level+1));
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